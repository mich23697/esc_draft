import Vue from 'vue'
import VueRouter from 'vue-router'
import App from './App.vue'
import Student from './views/Student.vue'
import Login from './views/Login.vue'
import Admin from './views/Admin.vue'

Vue.use(VueRouter)

Vue.config.productionTip = false

const routes = [
  {
    path: '/',
    redirect: {
      name: "Login"
    }
  },
  {
    path: "/login",
    name: "Login",
    component: Login
  },
  {
    path: "/student",
    name: "Student",
    component: Student
  },
  {
    path: "/admin",
    name: "Admin",
    component: Admin
  }
]

const router = new VueRouter({
  // mode: 'history',
  routes: routes
})

new Vue({
  render: h => h(App),
  router: router,
}).$mount('#app')
