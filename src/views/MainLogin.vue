<template>
  <div>
    <form class="loginForm">
      <h2>Login</h2>
      <div class="inputDiv">
        <input type="text" class="inputForm" placeholder="ID" v-model="id" />
      </div>
      <div class="inputDiv">
        <input type="password" class="inputForm" placeholder="PW" v-model="password" />
      </div>
      <button type="button" class="btn" onclick="button()">LOG IN</button>
      <div class="bottomText">
        <router-link to="/join">sign up </router-link> |
        <router-link to="/"> forgot password</router-link>
      </div>
    </form>
  </div>
</template>
<script>
export default {
  data() {
    return {
      id: "",
      password: "",
    };
  },
};
</script>
<style>
@import "./css/Main.css";
</style>
