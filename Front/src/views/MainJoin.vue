<template>
  <div>
    <form class="loginForm">
      <h2>Join</h2>
      <div class="inputDiv">
        <input type="text" class="inputForm" placeholder="ID" />
      </div>
      <div class="inputDiv">
        <input type="password" class="inputForm" placeholder="PW" />
      </div>
      <div class="inputDiv">
        <input type="Username" class="inputForm" placeholder="USERNAME" />
      </div>
      <div class="inputDiv">
        <input type="Username" class="inputForm" placeholder="E-MAIL" />
      </div>
      <div class="inputDiv">
        <input type="Username" class="inputForm" placeholder="ADDRESS" />
      </div>
      <button type="button" class="btn" onclick="button()">Join Us</button>
      <div class="bottomText"><router-link to="/">sign in</router-link></div>
    </form>
  </div>
</template>
<script>
export default {
  data() {
    return {};
  },
};
</script>
<style>
@import "./css/Main.css";
</style>
