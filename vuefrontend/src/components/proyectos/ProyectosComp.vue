<template>
  <v-container>
    
    <v-overlay
      :z-index="3"
      v-if="proyectoBaja != null"
    >
      <v-container style="background-color: #404040; padding: 30px; border-radius: 20px; justify-content: space-between;">
        <h3>
          Baja de proyecto
        </h3>
        <span>
          ¿Quieres dar de baja el proyecto "{{proyectoBaja.txDescripcion}}"?
        </span>
        <br>
        <br>
        <v-row>
          <v-spacer></v-spacer>
          <v-btn
            class="white--text"
            color="blue"
            @click="baja(proyectoBaja); proyectoBaja = null;"
          >
            Confirmar
          </v-btn>
          <v-spacer></v-spacer>
          <v-btn
            class="white--text"
            color="red"
            @click="proyectoBaja = null;">
            Cancelar
          </v-btn>
          <v-spacer></v-spacer>
        </v-row>

      </v-container>
    </v-overlay>

    <v-container><v-row>
      <h1>Proyectos</h1>
      <v-spacer></v-spacer>
      <v-btn @click="$router.push({name: 'altaproyecto'})">
        Alta de proyecto
      </v-btn>
    </v-row></v-container>

    <v-simple-table dense>
      <template v-slot:default>
      <thead>
        <tr>
          <th>Descripción</th>
          <th>Fecha de inicio</th>
          <th>Fecha de finalización</th>
          <th>Lugar</th>
          <th>Baja</th>
        </tr>
      </thead>

      <tbody>
        <tr v-for="p, i in proyectos" :key="i">
          <td>{{p.txDescripcion}}</td>
          <td>{{p.fInicio}}</td>
          <td>{{p.fFin}}</td>
          <td>{{p.txLugar}}</td>
          <td><span class="mdi mdi-alpha-x" style="font-size: 30px" @click="proyectoBaja = p"></span></td>
          <br>
        </tr>
      </tbody>
      </template>
    </v-simple-table>

    <br>
    <v-row>
    <div>
      <v-btn v-show="page" @click="backward_page()">
          {{ page }} &lt;
      </v-btn>
      <v-btn @click.stop.prevent="">
          Página actual {{ page + 1}}
      </v-btn>
      <v-btn v-show="proyectos.length >= pagesize" @click="forward_page()">
          &gt; {{ page + 2 }}
      </v-btn>
    </div>
    <v-spacer></v-spacer>
    <v-btn @click="$router.push({name: 'asignarempleados'})">
      Asignar Empleados
    </v-btn>
    </v-row>

  </v-container>
</template>


<script>
import axios from 'axios';
import Swal from 'sweetalert2';

export default {
  name: "proyectos-comp",

  data: () => ({
    page: 0,
    proyectos: [],
    pagesize: 10,
    proyectoBaja: null,
  }),

  methods:{

    loadPage(){
        if(this.page < 0) this.page = 0;

        axios.get(this.apiBaseUrl + 'proyecto', {params: {page: this.page}})
            .then(({data}) => {console.log(data); this.proyectos=data;})
            .catch((data) => {console.log(data)})
    },

    forward_page(){
        if (this.proyectos.length < this.pagesize) return;
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

    baja(proyecto){
      if (proyecto == null) return;
      console.log('Baja ' + proyecto.idProyecto);

      axios.delete(this.apiBaseUrl + 'proyecto/' + proyecto.idProyecto)
        .then(resp => {
          console.log('OK');
          console.log(resp);

          this.alerta({
            title: "Proyecto dado de baja",
            text: proyecto.txDescipcion,
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
  Retorno del GET proyecto: [{    {
    "idProyecto": 11,
    "txDescripcion": "near flew condition own health step both heading mathematics discuss organized syllable ",
    "fInicio": "2019-08-07",
    "fFin": null,
    "fBaja": null,
    "txLugar": "Eguocuru",
    "txObservaciones": "dust yourself possible needs swimming first monkey religious south question milk card tube fort bet twice being carefully these sail serve rule master other"
    },
  }, ...]


campos esperados por el PUT {
    "descripcion": "Test description",
    "fechaInicio": "2023-11-03",
    "lugar": "Madrid",
    "observaciones": "Ninguna"
}

-->
