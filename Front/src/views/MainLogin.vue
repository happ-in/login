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
      <button type="button" class="btn" @click="checkValue">LOG IN</button>
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
  methods: {
    checkValue() {
      console.log(this.id + " " + this.password);
      if (this.id && this.password) {
        this.login();
      } else {
        alert("ID 또는 PASSWORD를 입력하세요.");
      }
    },
    login() {
      this.$axios
        .post("http://localhost:9999/happyhouse/login", {
          userid: this.id,
          userpwd: this.password,
        })
        .then((data) => {
          console.log(data);
        })
        .catch(() => {
          console.log("error!");
        });
    },
  },
};
</script>
<style>
@import "./css/Main.css";
</style>
