<template>
  <div id="app">
    <div id="nav">
      <router-link v-if="authenticated" to="/login" v-on:click.native="logout()">Logout</router-link>
    </div>
    <router-view @authenticated="setAuthenticated"></router-view>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'App',
  data() {
    return {
      message: [],
      authenticated: false,
      account: {
        groupId: "student",
        password: "student"
      }
    }
  },
  created() {
    axios.get('http://localhost:3000/')
    .then(response => {
      this.message = response.data.message
    })
  },
  mounted() {
    if(!this.authenticated) {
      this.$router.replace({ name: "Login" });
    }
  },
  methods: {
    setAuthenticated(status) {
      this.authenticated = status;
    },
    logout() {
      this.authenticated = false;
    }
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>
