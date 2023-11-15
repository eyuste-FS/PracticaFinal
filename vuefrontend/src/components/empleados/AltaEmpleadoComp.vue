<template>
  <v-container>
    <v-btn @click="$router.back()">
        <span class="mdi mdi-arrow-left"></span>
    </v-btn>
    <h2>
        Alta de empleado
    </h2>
    <v-form>

        <v-col>
        <v-row>
            <v-text-field
                label="NIF" v-model="nif" :maxlength="max.nif"
                ></v-text-field>
            <v-spacer></v-spacer>
        </v-row>
        <v-row>
            <v-col>
            <v-text-field label="Nombre" v-model="nombre" :maxlength="max.nombre"></v-text-field>
            <v-text-field label="Primer apellido" v-model="primerApellido" :min="min.primerApellido" :maxlength="max.primerApellido"></v-text-field>
            <v-text-field label="Segundo apellido" v-model="segundoApellido" :min="min.segundoApellido" :maxlength="max.segundoApellido"></v-text-field>
            </v-col>
            <v-col>
            <v-text-field label="Primer teléfono de contacto" v-model="telefono1" :maxlength="max.telefono1"></v-text-field>
            <v-text-field label="Segundo teléfono de contacto" v-model="telefono2" :maxlength="max.telefono2"></v-text-field>
            </v-col>
            <v-spacer></v-spacer>
            <v-spacer></v-spacer>
        </v-row>

        <v-row>
            <v-text-field label="Email" v-model="email" :maxlength="max.email"></v-text-field>
            <v-spacer></v-spacer><v-spacer></v-spacer>
        </v-row>

        <v-row>
            <v-col>
            <v-select
                v-model="estadoCivil"
                :items="['Soltero', 'Casado']"
                label="Estado civil"
                persistent-hint
                return-object
                single-line
                >
            </v-select>
            <v-select
                v-model="servicioMilitar"
                :items="['No', 'Si']"
                label="Servicio militar"
                persistent-hint
                return-object
                single-line
                >
            </v-select>
            </v-col>
            <v-spacer></v-spacer>
            <v-spacer></v-spacer>
        </v-row>

        <v-row>
            <v-col>
                <h4>Fecha de nacimiento</h4>
                <v-date-picker v-model="fechaNacimiento" elevation="10" :max="yearsAgo(15)"> </v-date-picker>
            </v-col>
            <v-col>
                <h4>Fecha de alta</h4>
                <v-date-picker v-model="fechaAlta" elevation="10" :min="today"> </v-date-picker>
            </v-col>
            <v-spacer></v-spacer>
        </v-row>

        </v-col>

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
  name: "alta-empleado-comp",

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

    max: {
        nif: 20,
        nombre: 30,
        primerApellido: 40,
        segundoApellido: 40,
        telefono1: 12,
        telefono2: 12,
        email: 40,
        fechaAlta: 10,
        fechaNacimiento: 10,
    },
    min: {
        nif: 1,
        nombre: 1,
        primerApellido: 1,
        segundoApellido: 1,
        telefono1: 3,
        telefono2: 3,
        email: 5,
        fechaAlta: 10,
        fechaNacimiento: 10,
        estadoCivil: 6,
        servicioMilitar: 2,
    }

}),

  computed: {
    today(){
      return new Date().toISOString().substring(0, 10);
    },
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
    yearsAgo(n){
        let today = new Date();
        today.setFullYear(today.getFullYear() - n);
        return today.toISOString().substring(0, 10);
    },

    wrongFields(){
        const fechaRe = new RegExp("^[0-9]{4}-[0-9]{2}-[0-9]{2}$");
        const emailRe = new RegExp("^(.+)@(.+)\\.(.+)$");
        const telefonoRe = new RegExp("^[0-9]{1,12}$");
        let emptyfields = [];
        let wrong = [];

        if (this.nif.length < this.min.nif) emptyfields.push('Nif');
        else if (this.nif.length > this.max.nif) wrong.push('Nif demasiado largo');
        if (this.nombre.length < this.min.nombre) emptyfields.push("Nombre");
        else if (this.nombre.length > this.max.nombre) wrong.push('Nombre demasiado largo');
        if (this.primerApellido.length < this.min.primerApellido) emptyfields.push("1º Apellido");
        else if (this.primerApellido.length > this.max.primerApellido) wrong.push('1º Apellido demasiado largo');
        if (this.segundoApellido.length < this.min.segundoApellido) emptyfields.push("2º Apellido");
        else if (this.segundoApellido.length > this.max.segundoApellido) wrong.push('2º Apellido demasiado largo');
        
        if (this.fechaNacimiento.length < this.min.fechaNacimiento) emptyfields.push("Fecha de nacimiento");
        else if (!fechaRe.test(this.fechaNacimiento)) wrong.push("Fecha de nacimiento: formato incorrecto");
        
        if (this.fechaAlta.length < this.min.fechaAlta) emptyfields.push("Fecha de alta");
        else if (!fechaRe.test(this.fechaAlta)) wrong.push("Fecha de alta: formato incorrecto");
        
        if (this.telefono1.length < this.min.telefono1) emptyfields.push("1º Teléfono");
        else if (!telefonoRe.test(this.telefono1)) wrong.push("1º Teléfono: formato incorrecto");

        if (this.telefono2.length < this.min.telefono2) emptyfields.push("2º Teléfono");
        else if (!telefonoRe.test(this.telefono2)) wrong.push("1º Teléfono: formato incorrecto");
        
        if (this.email.length < this.min.email) emptyfields.push("Email");
        else if (!emailRe.test(this.email)) wrong.push("Email: formato incorrecto");
        else if (this.email.length > this.max.email) wrong.push("Email: demasiado largo")

        if (this.estadoCivil.length < this.min.estadoCivil) emptyfields.push("Estado civil");
        else if (this.estadoCivil != "Casado" && this.estadoCivil != "Soltero") wrong.push("Estado civil fuera de rango");

        if (this.servicioMilitar.length < this.min.servicioMilitar) emptyfields.push("Servicio militar");
        else if (this.servicioMilitar != "Si" && this.servicioMilitar != "No") wrong.push("Servicio militar fuera de rango");

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
                let msg = resp;
                if (msg.response) msg = msg.response;
                if (msg.data) msg = msg.data;
                if (msg.error) msg = msg.error;
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
