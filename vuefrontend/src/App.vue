<template>
  <v-app>
    <v-app-bar
      app
      color="primary"
      dark
    >
    
      <v-btn v-show="$route.name != 'home'" @click="$router.push({name: 'home'})">
        <span class="mr-2">Home</span>
        <v-icon>mdi-home</v-icon>
      </v-btn>

      <span style="width: 20px"></span>

      <v-app-bar-title><div>Práctica final - Erik Yuste</div></v-app-bar-title>

      <v-spacer></v-spacer>

      <v-btn
        href="https://github.com/eyuste-FS/PracticaFinal"
        target="_blank"
        text
      >
        <span class="mr-2">Github</span>
        <v-icon>mdi-open-in-new</v-icon>
      </v-btn>
    </v-app-bar>

    <v-main>
      <router-view/>
    </v-main>
  </v-app>
</template>

<script>

export default {
  name: 'App',

  data: () => ({
    //
  }),
};
</script>
