<template>
  <div class="tf-width">
    <h1 class="m-3">Login</h1>
    <br />
    <v-row>
      <v-col cols="12" sm="9">
        <v-row>
          <v-text-field label="ID" hide-details="auto"></v-text-field>
        </v-row>
        <v-row>
          <v-text-field label="PassWord"></v-text-field>
        </v-row>
      </v-col>
      <v-col cols="12" sm="3">
        <v-btn outlined height="100%">Login</v-btn>
      </v-col>
    </v-row>
  </div>
</template>

<script>
export default {};
</script>

<style>
.tf-width {
  width: 300px;
  margin: 0 auto;
  text-align: center;
}
.btn-height {
  height: 300px;
}
</style>
