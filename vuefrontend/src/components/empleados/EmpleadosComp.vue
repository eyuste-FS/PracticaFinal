<template>
  <v-container>

    <h1>Empleados</h1>






    <v-btn v-show="page" @click="backward_page()">
        {{ page }} &lt;
    </v-btn>
    <v-btn @click.stop.prevent="">
        Current {{ page + 1}}
    </v-btn>
    <v-btn v-show="empleados.length >= pagesize" @click="forward_page()">
        &gt; {{ page + 2 }}
    </v-btn>


  </v-container>
</template>


<script>
import axios from 'axios';
export default {
  name: "empleados-comp",

  data: () => ({
    page: 0,
    empleados: [],
    pagesize: 10,  //TEMP
  }),

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
        this.loadPage;
    }

  },

  mounted(){
    this.loadPage();
  }

};
</script>
