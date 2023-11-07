<template>
  <v-container>
    <v-btn @click="$router.back()">
        <span class="mdi mdi-arrow-left"></span>
    </v-btn>
    <br>
    <br>
    <br>
    <v-form>

      <v-row>
        <v-col>
          <v-row>
              <v-textarea label="Descripción del proyecto" v-model="descripcion" :maxlength="max.descripcion"></v-textarea>
          </v-row>
          <v-row>
              <v-text-field label="Lugar" v-model="lugar" :maxlength="max.lugar"></v-text-field>
          </v-row>
          <v-row>
              <v-textarea label="Observaciones" v-model="observaciones" :maxlength="max.observaciones"></v-textarea>
          </v-row>

        </v-col>
        <v-col>
            <h4>Fecha de inicio</h4>
            <v-date-picker v-model="fechaInicio" elevation="10" :min="today"> </v-date-picker>
        </v-col>
      </v-row>
      <br>

      <v-container style="padding: 30px; justify-content: space-between;">
        <v-row>
          <v-spacer></v-spacer>
          <v-btn
            class="white--text"
            color="blue"
            @click="aceptar()"
          >
            Aceptar
          </v-btn>
          <v-spacer></v-spacer>
          <v-btn
            class="white--text"
            color="red"
            @click="cancelar()">
            Cancelar
          </v-btn>
          <v-spacer></v-spacer>
        </v-row>

      </v-container>
    </v-form>

  </v-container>
</template>


<script>
import axios from 'axios';
import Swal from 'sweetalert2';

export default {
  name: "alta-proyecto-comp",

  data: () => ({
    descripcion: "",
    fechaInicio: "",
    lugar: "",  // 30
    observaciones: "",  // 300

    max: {
      descripcion: 125,
      fechaInicio: 10,
      lugar: 30,
      observaciones: 300,
    },

    min: {
      descripcion: 1,
      fechaInicio: 10,
      lugar: 1,
      observaciones: 1,
    },

  }),

  computed: {
    today(){
      return new Date().toISOString().substring(0, 10);
    },
    formulario(){
        return {
          descripcion: this.descripcion,
          fechaInicio: this.fechaInicio,
          lugar: this.lugar,
          observaciones: this.observaciones,
        };
    },
  },

  methods:{

    wrongFields(){
        const fechaRe = new RegExp("^[0-9]{4}-[0-9]{2}-[0-9]{2}$");
        let emptyfields = [];
        let wrong = [];

        if (this.descripcion.length < this.min.descripcion) emptyfields.push('Descripción');
        else if (this.descripcion.length > this.max.descripcion) wrong.push('Descripción demasiado larga');

        if (this.fechaInicio.length < this.min.fechaInicio) emptyfields.push("Fecha de incio");
        else if (!fechaRe.test(this.fechaInicio)) wrong.push("Fecha de inicio: formato incorrecto");
        
        if (this.lugar.length < this.min.lugar) emptyfields.push("Lugar");
        else if (this.lugar.length > this.max.lugar) wrong.push("Lugar: demasiado largo")

        if (this.observaciones.length < this.min.observaciones) emptyfields.push("Observaciones");
        else if (this.observaciones.length > this.max.observaciones) wrong.push("Observaciones: demasiado largas")

        return [emptyfields, wrong];
    },

    aceptar(){
        console.log(this.formulario);
        // checks
        let [emptyFields, wrong] = this.wrongFields();
        console.log(emptyFields, wrong);
        if (emptyFields.length > 0 || wrong.length > 0){
            let estr = emptyFields.length > 0?
                ("<b>Hay campos obligatorios sin completar:</b> <ul>" + emptyFields
                .map(f => "<li> - " + f + "</li>")
                .reduce((a, b) => a + b) + "</ul>") : "";
            let wstr = wrong.length > 0 ? 
                ("<b>Error en los campos:</b> <ul>" + wrong
                    .map(f => "<li> - " + f + "</li>")
                    .reduce((a, b) => a + b) + "</ul>") :
                "";

            Swal.fire({
                titleText: "Es obligatorio introducir todos los datos para dar de alta un nuevo proyecto",
                html:  "<div style='text-align: left'>"+ estr + wstr + "</div>",
                icon: "error",
            })
            return;
        }

        axios.put(this.apiBaseUrl + 'proyecto', this.formulario)
            .then(() => {
                this.$router.back();
                
                Swal.fire({
                    titleText: "Nuevo proyecto dado de alta",
                    text: this.descripcion,
                    icon: "success",
                })
            })
            .catch(resp => {
                console.log(resp)
                Swal.fire({
                    titleText: "Error",
                    html: resp,
                    icon: "error",
                })
            });

    },

    cancelar(){
        //back
        this.$router.back();
    },

  },

  mounted(){
  },

};

</script>
<!--
Esperado por el PUT {
  "descripcion": "Test description",  // 125
  "fechaInicio": "2023-11-03",
  "lugar": "Madrid",  // 30
  "observaciones": "Ninguna"  // 300
}
12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345
-->