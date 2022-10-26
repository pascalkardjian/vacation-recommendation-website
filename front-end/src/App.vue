<template>
  <div id="app">
  <b-container>
    <div>
      <b-navbar toggleable type="dark" variant="dark">
      <b-navbar-brand href="#"><b-icon icon="book" variant="warning" style="margin-left: 20px;"></b-icon> MIE350 University </b-navbar-brand>

      <b-navbar-toggle target="sidebar-menu">
      </b-navbar-toggle>
      <b-sidebar id="sidebar-menu" title="MIE350 University" backdrop-variant="dark" backdrop shadow>
        <b-nav vertical align="center">
          <b-nav-item to="/" exact exact-active-class="exact-active">Home</b-nav-item>
          <b-nav-item to="/students" exact exact-active-class="exact-active">Students</b-nav-item>
          <b-nav-item to="/professors" exact exact-active-class="exact-active">Professors</b-nav-item>
          <b-nav-item disabled>Admin</b-nav-item>
        </b-nav>
      </b-sidebar>
    </b-navbar>
    </div>
    <br />
    <router-view/>
    </b-container>
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 20px;
}
</style>
