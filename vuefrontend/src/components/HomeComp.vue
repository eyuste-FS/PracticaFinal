<template>
  <v-container>
    <v-row class="text-center">
      <v-col class="mb-4" v-for="(page, pidx) in pages" :key="pidx">
        <v-card @click="$router.push({name: page.name})">
          <span :class="page.icon" style="font-size: 90px"></span>
          <v-card-title class="justify-center">{{page.title}}</v-card-title>
          <v-card-text>{{page.desc}}</v-card-text>
          <router-link :to="{name: page.name}"></router-link>
        </v-card>
      </v-col>

    </v-row>
  </v-container>
</template>

<script>
export default {
  name: "home-comp",

  data: () => ({
    pages: [
      {
        title: "Empleados",
        desc: "Página de gestión de empleados",
        name:"empleados",
        icon: "mdi mdi-account-circle",
      },
      {
        title: "Proyectos",
        desc: "Página de gestión de proyectos",
        name:"proyectos",
        icon: "mdi mdi-file-document-multiple",
      }
    ],
  }),
};
</script>
