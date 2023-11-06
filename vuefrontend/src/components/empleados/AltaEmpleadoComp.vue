<template>
  <v-container>
    <v-btn @click="$router.back()">
        <span class="mdi mdi-arrow-left"></span>
    </v-btn>

    <v-form>

        <v-col>
        <v-row>
            <v-text-field label="NIF" v-model="nif"></v-text-field>
            <v-spacer></v-spacer>
        </v-row>
        <v-row>
            <v-text-field label="Nombre" v-model="nombre"></v-text-field>
            <br>
            <v-text-field label="Primer apellido" v-model="primerApellido"></v-text-field>
            <v-text-field label="Segundo apellido" v-model="segundoApellido"></v-text-field>
        </v-row>

        <v-row>
            <v-text-field label="Primer teléfono de contacto" v-model="telefono1"></v-text-field>
            <v-spacer></v-spacer>
            <v-text-field label="Segundo teléfono de contacto" v-model="telefono2"></v-text-field>
            <v-spacer></v-spacer>
        </v-row>

        <v-row>
            <v-text-field label="Email" v-model="email"></v-text-field>
            <v-spacer></v-spacer><v-spacer></v-spacer>
        </v-row>

        <v-row>        
            <v-select
                v-model="estadoCivil"
                :items="['Soltero', 'Casado']"
                label="Estado civil"
                persistent-hint
                return-object
                single-line
                >
            </v-select>
            <v-spacer></v-spacer>
            <v-select
                v-model="servicioMilitar"
                :items="['No', 'Si']"
                label="Servicio militar"
                persistent-hint
                return-object
                single-line
                >
            </v-select>
            <v-spacer></v-spacer>
        </v-row>

        <v-row>
            <v-col>
                <h4>Fecha de nacimiento</h4>
                <v-date-picker v-model="fechaNacimiento" > </v-date-picker>
            </v-col>
            <v-col>
                <h4>Fecha de alta</h4>
                <v-date-picker v-model="fechaAlta" > </v-date-picker>
            </v-col>
        </v-row>

        </v-col>
    </v-form>

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

  </v-container>
</template>


<script>
import axios from 'axios';
import Swal from 'sweetalert2';

export default {
  name: "alta-empleados-comp",

  data: () => ({
    nif: "",
    nombre: "",
    primerApellido: "",
    segundoApellido: "",
    fechaNacimiento: "",
    fechaAlta: "",
    telefono1: "",
    telefono2: "",
    email: "",
    estadoCivil: "", // [Soltero/Casado]
    servicioMilitar: "", // [Si/No]
  }),

  computed: {
    formulario(){
        return {
            nif: this.nif,
            nombre: this.nombre,
            primerApellido: this.primerApellido,
            segundoApellido: this.segundoApellido,
            fechaNacimiento: this.fechaNacimiento,
            fechaAlta: this.fechaAlta,
            telefono1: this.telefono1,
            telefono2: this.telefono2,
            email: this.email,
            estadoCivil: this.estadoCivil, // [Soltero/Casado]
            servicioMilitar: this.servicioMilitar, // [Si/No]
        };
    },
  },

  methods:{

    wrongFields(){
        const fechaRe = new RegExp("^[0-9]{4}-[0-9]{2}-[0-9]{2}$");
        const emailRe = new RegExp("^(.+)@(.+)\\.(.+)$");
        const telefonoRe = new RegExp("^[0-9]{1,12}$");
        let emptyfields = [];
        let wrong = [];

        if (this.nif.length < 1) emptyfields.push('Nif');
        else if (this.nif.length > 20) wrong.push('Nif');
        if (this.nombre < 1) emptyfields.push("Nombre");
        else if (this.nombre.length > 30) wrong.push('Nombre');
        if (this.primerApellido < 1) emptyfields.push("1º Apellido");
        else if (this.primerApellido.length > 40) wrong.push('1º Apellido');
        if (this.segundoApellido < 1) emptyfields.push("2º Apellido");
        else if (this.segundoApellido.length > 40) wrong.push('2º Apellido');
        
        if (this.fechaNacimiento < 1) emptyfields.push("Fecha de nacimiento");
        else if (!fechaRe.test(this.fechaNacimiento)) wrong.push("Fecha de nacimiento");
        
        if (this.fechaAlta < 1) emptyfields.push("Fecha de alta");
        else if (!fechaRe.test(this.fechaAlta)) wrong.push("Fecha de alta");
        
        if (this.telefono1 < 1) emptyfields.push("1º Teléfono");
        else if (!telefonoRe.test(this.telefono1)) wrong.push("1º Teléfono");

        if (this.telefono2 < 1) emptyfields.push("2º Teléfono");
        else if (!telefonoRe.test(this.telefono2)) wrong.push("1º Teléfono");
        
        if (this.email < 1) emptyfields.push("Email");
        else if (!emailRe.test(this.email) || this.email.length > 40) wrong.push("Email");

        if (this.estadoCivil < 1) emptyfields.push("Estado civil");
        else if (this.estadoCivil != "Casado" && this.estadoCivil != "Soltero") wrong.push("Estado civil");

        if (this.servicioMilitar < 1) emptyfields.push("Servicio militar");
        else if (this.servicioMilitar != "Si" && this.servicioMilitar != "No") wrong.push("Servicio militar");

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
                titleText: "Es obligatorio introducir todos los datos para dar de alta un nuevo empleado",
                html:  "<div style='text-align: left'>"+ estr + wstr + "</div>",
                icon: "error",
            })
            return;
        }

        let empleado = `${this.nombre} ${this.primerApellido} ${this.segundoApellido}`;
        axios.put(this.apiBaseUrl + 'empleado', this.formulario)
            .then(() => {
                this.$router.back();
                
                Swal.fire({
                    titleText: "Nuevo empleado dado de alta",
                    text: empleado,
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
