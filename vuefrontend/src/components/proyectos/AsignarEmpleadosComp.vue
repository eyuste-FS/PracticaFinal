
<style scoped>
  .seleccionada{
    background-color: #2080e0;
    color: #fff;
  }
</style>

<template>
  <v-container>

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

          <tbody>
            <tr v-for="e, i in empleadosMod" :key="i">
              <td>{{e.txNombre}}</td>
              <td @click="toggleEmpleado(e)"
              style="cursor: pointer"></td>
            </tr>
          </tbody>
        </v-simple-table>
      </v-flex>
      </v-layout>

    </v-col>
    </v-row>

    </v-container>


  </v-container>
</template>


<script>
import axios from 'axios';
//import Swal from 'sweetalert2';

export default {
  name: "asignar-empleados-comp",

  data: () => ({
    proyectoActual: null,
    proyectos: [],  // [{idProyecto, txDescripcion}]
    empleadosOriginal: [],  // TODO: {id: {...empleado}}
    empleadosMod: [],  // TODO: {id: {...empleado}}
  }),

  methods: {

    setProyecto(proyecto){
      this.proyectoActual = proyecto;
      this.loadEmpleados();
    },

    aceptar(){

    },

    cancelar(){
      this.empleadosMod = [...this.empleadosOriginal.map(e => ({...e}))];

    },

    toggleEmpleado(e){
      e
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
      this.empleadosOriginal = [];
      this.empleadosMod = [];
      if (this.proyectoActual == null){
        return;
      }
      axios.get(this.apiBaseUrl + `proyecto/${this.proyectoActual.idProyecto}/empleado`)
        .then(({data}) => {
          console.log(data);

          this.empleadosOriginal = data;
          this.empleadosMod = [...data.map(e => ({...e}))];

        })
        .catch(resp => {console.log('Catch loadProyectos'); console.log(resp)});
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
