<template>
  <v-container>
    
    <v-overlay
      :z-index="3"
      v-if="empleadoBaja != null"
    >
      <v-container style="background-color: #404040; padding: 30px; border-radius: 20px; justify-content: space-between;">
        <h3>
          Baja de empleado
        </h3>
        <span>
          ¿Quieres dar de baja a {{empleadoBaja.txNombre}} {{empleadoBaja.txApellido1}} {{empleadoBaja.txApellido2}}?
        </span>
        <br>
        <br>
        <v-row>
          <v-spacer></v-spacer>
          <v-btn
            class="white--text"
            color="blue"
            @click="baja(empleadoBaja); empleadoBaja = null;"
          >
            Confirmar
          </v-btn>
          <v-spacer></v-spacer>
          <v-btn
            class="white--text"
            color="red"
            @click="empleadoBaja = null;">
            Cancelar
          </v-btn>
          <v-spacer></v-spacer>
        </v-row>

      </v-container>
    </v-overlay>

    <v-container><v-row>
      <h1>Empleados</h1>
      <v-spacer></v-spacer>
      <v-btn @click="$router.push({name: 'altaempleado'})">
        Alta de empleado
      </v-btn>
    </v-row></v-container>


    <v-simple-table dense>
      <template v-slot:default>
      <thead>
        <tr>
          <th>NIF</th>
          <th>Nombre</th>
          <th>Primer apellido</th>
          <th>Segundo apellido</th>
          <th>Fecha de nacimiento</th>
          <th>Primer teléfono de contacto</th>
          <th>Email</th>
          <th>Estado civil</th>
          <th>Servicio militar</th>
          <th>Baja</th>
        </tr>
      </thead>

      <tbody>
        <tr v-for="e, i in empleados" :key="i">
          <td>{{e.txNif}}</td>
          <td>{{e.txNombre}}</td>
          <td>{{e.txApellido1}}</td>
          <td>{{e.txApellido2}}</td>
          <td>{{e.fnacimiento}}</td>
          <td>{{e.ntelefono1}}</td>
          <td>{{e.txEmail}}</td>
          <td>{{e.cxEdocivil | estadoCivil}}</td>
          <td>{{e.bservmilitar | servicioMilitar}}</td>
          <td><span class="mdi mdi-alpha-x" style="font-size: 30px" @click="empleadoBaja = e"></span></td>
          <br>
        </tr>
      </tbody>
      </template>
    </v-simple-table>



    <div>
      <v-btn v-show="page" @click="backward_page()">
          {{ page }} &lt;
      </v-btn>
      <v-btn @click.stop.prevent="">
          Página actual {{ page + 1}}
      </v-btn>
      <v-btn v-show="empleados.length >= pagesize" @click="forward_page()">
          &gt; {{ page + 2 }}
      </v-btn>
    </div>

  </v-container>
</template>


<script>
import axios from 'axios';
import Swal from 'sweetalert2';

export default {
  name: "empleados-comp",

  data: () => ({
    page: 0,
    empleados: [],
    pagesize: 10,
    empleadoBaja: null,
  }),

  filters:{
    estadoCivil(str){
      if(str == "C") return "Casado";
      if(str == "S") return "Soltero";
      return "";
    },
    servicioMilitar(str){
      if(str=="S") return "Si";
      if(str=="N") return "No";
      return "";
    }
  },

  methods:{

    loadPage(){
        if(this.page < 0) this.page = 0;

        axios.get(this.apiBaseUrl + 'empleado', {params: {page: this.page}})
            .then(({data}) => {console.log(data); this.empleados=data;})
            .catch((data) => {console.log(data)})
    },

    forward_page(){
        if (this.empleados.length < this.pagesize) return;
        this.page += 1;
        this.loadPage(); 
    },

    backward_page(){
        if (this.page <= 0){
           return;
        }
        this.page -= 1;
        this.loadPage();
    },

    baja(empleado){
      if (empleado == null) return;
      console.log('Baja ' + empleado.idEmpleado);

      axios.delete(this.apiBaseUrl + 'empleado/' + empleado.idEmpleado)
        .then(resp => {
          console.log('OK');
          console.log(resp);

          this.alerta({
            title: "Empleado dado de baja",
            text: empleado.txNombre + " " + empleado.txApellido1 + " " + empleado.txApellido2,
            error: false,
          });

          this.loadPage();
          })
        .catch(({response}) => {
          console.log(response);

          this.alerta({
            title: "Error",
            text: response.data,
            error: true,
          });
        });

    },

    alerta (obj) {
      // {title: "", text: "", error: true/false}
      Swal.fire({
        titleText: obj.title,
        html: obj.text,
        icon: obj.error ? "error" : 'success',
      })

    }

  },

  mounted(){
    this.loadPage();
  },

};
</script>


<!--
  Retorno del GET empleado: [{
    "idEmpleado": 1,
    "txNif": "43807951L",
    "txNombre": "Jason",
    "txApellido1": "Rodriquez",
    "txApellido2": "Grant",
    "txEmail": "ga@puto.ve",
    "cxEdocivil": "C",
    "fbaja": null,
    "fnacimiento": "1972-08-13",
    "ntelefono1": "783800640",
    "falta": "2014-02-07",
    "bservmilitar": "S",
    "ntelefono2": "966981589"
  }, ...]
-->
