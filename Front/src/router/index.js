import Vue from "vue";
import VueRouter from "vue-router";
import MainLogin from "../views/MainLogin.vue";
import MainJoin from "../views/MainJoin.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Login",
    component: MainLogin,
  },
  {
    path: "/join",
    name: "Join",
    component: MainJoin,
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
