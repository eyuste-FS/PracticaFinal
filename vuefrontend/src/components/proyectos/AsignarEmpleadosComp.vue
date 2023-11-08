
<style scoped>
  .seleccionada{
    background-color: #2080e0;
    color: #fff;
  }
</style>

<template>
  <v-container>


    <v-overlay
      :z-index="3"
      v-if="proyectoActual != null && aceptTrigger"
    >
      <v-container style="background-color: #404040; padding: 30px; border-radius: 20px; justify-content: space-between;">
        <h3>
          ¿Modificar la asignación de empleados al proyecto "{{proyectoActual.txDescripcion}}"?
        </h3>
        <br>
        <v-row>
          <v-spacer></v-spacer>
          <v-btn
            class="white--text"
            color="blue"
            @click="aceptTrigger = false; aceptar();"
          >
            Confirmar
          </v-btn>
          <v-spacer></v-spacer>
          <v-btn
            class="white--text"
            color="red"
            @click="aceptTrigger = false;">
            Cancelar
          </v-btn>
          <v-spacer></v-spacer>
        </v-row>

      </v-container>
    </v-overlay>



    <v-btn @click="$router.back()">
      <span class="mdi mdi-arrow-left"></span>
    </v-btn>
    <h2>
      Asignación de Empleados
    </h2>

    <v-container>
      <v-row>

        <v-col>
          <v-layout column style="height: 400px">
          <v-flex style="overflow: auto">

            <v-simple-table dense>
              <thead>
                <tr>
                  <th>Proyectos</th>
                </tr>
              </thead>

              <tbody>
                <tr 
                  v-for="p, i in proyectos" :key="i"
                  @click="setProyecto(p)"
                  :class="getRowColor(p)"
                  style="cursor: pointer">
                  <td>{{p.txDescripcion}}</td>
                </tr>
              </tbody>
            </v-simple-table>
          </v-flex>
          </v-layout>
        </v-col>
        
        <v-col>

          <v-layout column style="height: 400px">
          <v-flex style="overflow: auto">

            <v-simple-table dense>
              <thead>
                <tr>
                  <th>Empleados</th>
                  <th>Asignado</th>
                </tr>
              </thead>

              <tbody v-if="empleadosOriginal != null">
                <tr v-for="(e, i) in empleadosOriginal" :key="i">
                  <td>{{e.txNombre}} {{e.txApellido1}} {{e.txApellido2}}</td>
                  <td @click="toggleEmpleado(e)"
                    style="cursor: pointer">
                    <span :class="getEmpleadoCheck(e) ? checkClass : uncheckClass"></span>
                    <span v-show="e.modificado">  *</span>
                  </td>
                </tr>
              </tbody>
            </v-simple-table>
          </v-flex>
          </v-layout>

        </v-col>
      </v-row>

    </v-container>
    
    <v-container style="padding: 30px; justify-content: space-between;">
        <v-row>
          <v-spacer></v-spacer>
          <v-btn
            v-show="empleadosAnadidos.length > 0 || empleadosEliminados.length > 0"
            class="white--text"
            color="blue"
            @click="aceptTrigger = true;"
          >
            Aceptar
          </v-btn>
          <v-spacer></v-spacer>
          <v-btn
            v-show="empleadosAnadidos.length > 0 || empleadosEliminados.length > 0"
            class="white--text"
            color="red"
            @click="cancelar()">
            Revertir cambios
          </v-btn>
          <v-spacer></v-spacer>
        </v-row>

      </v-container>

  </v-container>
</template>


<script>
import axios from 'axios';
import Swal from 'sweetalert2';

export default {
  name: "asignar-empleados-comp",

  data: () => ({
    proyectoActual: null,
    proyectos: [],  // [{idProyecto, txDescripcion}]
    empleadosOriginal: [],  // [{...empleado, asignado, ...}]

    empleadosAnadidos: [],
    empleadosEliminados: [],

    checkClass: 'mdi mdi-checkbox-marked',
    uncheckClass: 'mdi mdi-checkbox-blank-outline',

    aceptTrigger: false,
  }),

  methods: {

    setProyecto(proyecto){
      /* Selecciona un proyecto */
      this.proyectoActual = proyecto;
      this.loadEmpleados();
    },

    aceptar(){
      /* Manda una petición de actualizacion a la API */
      if(this.proyectoActual == null){
        Swal.fire({
          titleText: "Selecciona un proyecto para modificar los empleados asignados",
          icon: "info"})
        return;
      }

      if(this.empleadosAnadidos.length < 1 && this.empleadosEliminados.length < 1){
        Swal.fire({
          titleText: 'No hay modificaciones que actualizar',
          icon: 'warning',
        })
        return;
      }

      let banner = {};
      axios.post(this.apiBaseUrl + `proyecto/${this.proyectoActual.idProyecto}/empleado`, {
          empleadosBaja: this.empleadosEliminados,
          empleadosAlta: this.empleadosAnadidos,
        }).then(() =>{
          this.loadEmpleados();
          banner = {
            titleText: 'Asignacion de proyecto actualizada',
            icon: 'success',
          }
        }).catch(resp => {
          banner = {
            titleText: 'Se ha producido un error',
            text: resp.response.data,
            icon: 'error',
          };
          console.log(resp);
        }).finally(() => {Swal.fire(banner)})

    },

    cancelar(){
      /* Revierte los cambios */
      this.empleadosAnadidos = [];
      this.empleadosEliminados = [];
      for (let empleado of this.empleadosOriginal){
        empleado.modificado = false;
      }
    },

    toggleEmpleado(e){
      /* Cambia el check de un empleado */
      let id = e.idEmpleado;

      if (e.asignado){
        let eliminado = this.empleadosEliminados.indexOf(id);
        if (eliminado >= 0){
          // Deshacer uncheck
          this.empleadosEliminados.splice(eliminado, 1);
          e.modificado = false;
        }else{
          // Uncheck
          this.empleadosEliminados.push(id);
          e.modificado = true;
        }

      }else{
        let anadido = this.empleadosAnadidos.indexOf(id);
        if (anadido >= 0){
          // Deshacer check
          this.empleadosAnadidos.splice(anadido, 1);
          e.modificado = false;
        }else{
          // Check
          this.empleadosAnadidos.push(id);
          e.modificado = true;
        }

      }
    },

    getEmpleadoCheck(empleado){
      return empleado.asignado != empleado.modificado;
    },

    loadProyectos(){
      this.proyectos = [];
      axios.get(this.apiBaseUrl + 'proyecto')
        .then(({data}) => {
          this.proyectos = data.map(p => {
            return {idProyecto: p.idProyecto, txDescripcion: p.txDescripcion};
            });
        })
        .catch(resp => {console.log('Catch loadProyectos'); console.log(resp)});
    },

    loadEmpleados(){
      this.empleadosAnadidos = [];
      this.empleadosEliminados = [];
      this.empleadosOriginal = [];

      if (this.proyectoActual == null){
        return;
      }
      axios.get(this.apiBaseUrl + `proyecto/${this.proyectoActual.idProyecto}/empleado`)
        .then(({data}) => {
          //console.log(data);
          this.empleadosOriginal = data.map(v => ({
            ...v.empleado, fAlta: v.fAlta, idProyecto: v.idProyecto, asignado: v.asignado, modificado: false,
          }));
          //console.log(this.empleadosOriginal);
        })
        .catch(resp => {console.log('Catch loadEmpleados'); console.log(resp)});
    },

    getRowColor(p){
      if (this.proyectoActual != null && p.idProyecto == this.proyectoActual.idProyecto){
        return 'seleccionada';
      }
      return '';    
    }

  },

  mounted(){
    this.proyectoActual = null;
    this.loadProyectos();
    this.loadEmpleados();
  },

};
</script>
