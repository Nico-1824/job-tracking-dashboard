<script setup lang="ts">

const pages = [
  { name: "Home", path: '/' },
]

</script>

<template>
  <div id="main-app">

    <header>

      <h1>Agent Dashboard</h1>
      <nav>
        <ul> 
          <li v-for="link in pages" :key="link.name">
            <router-link :to="link.path">{{ link.name }}</router-link>
          </li>
        </ul>
      </nav>

    </header>
    <div>
      <router-view />
    </div>

  </div>
</template>

<style>

#main-app header {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
  margin: 1rem;
}

#main-app ul {
  list-style: none;
  gap: 0.5rem; 
}

#main-app a {
  text-decoration: none;
  color: white;
}

#main-app li {
  border: 0.1rem solid rgba(255, 255, 255, 0.288);
  padding: 0.5rem;
  border-radius: 0.5rem;
  background-color: #383737;
  font-size: 1.5rem;
  transition: transform 0.15s, background-color 0.15s, box-shadow 0.15s;
}

#main-app li:hover {
  background-color:#494949;
  transform: scale(1.1);
  border: 0.1rem solid rgba(255, 255, 255, 0.5);
  box-shadow: 0.1rem 0.1rem 1rem rgba(255, 254, 254, 0.868);
}

#main-app li:active {
  background-color:#262626;
  transform: scale(1);
  border: 0.1rem solid rgba(59, 58, 58, 0.5);
  box-shadow: 0 0 0;
}

#main-app {
  background-color: #494949;
  min-height: 100vh;
}

h1, h2 {
  color: white;
  padding: 1rem;
}

body {
  margin: 0;
  background-color: #494949;
}

</style>
