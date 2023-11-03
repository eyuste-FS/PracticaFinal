import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/empleados',
    name: 'empleados',
    // lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "empleados" */ '../views/EmpleadosView.vue')
  },
  {
    path: '/proyectos',
    name: 'proyectos',
    // lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "proyectos" */ '../views/ProyectosView.vue')
  },
  {
    path: '/analisis',
    name: 'analisis',
    // lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "analisis" */ '../views/AnalisisView.vue')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
