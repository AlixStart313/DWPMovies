<template>
  <div>
    <header
      class="text-light text-center py-5"
      style="background-color: #026c80"
    >
      <nav class="navbar navbar-expand-lg" style="background-color: #026c80">
        <div class="container">
          <router-link to="/" class="navbar-brand text-light"
            >AndyLiss Filmsy</router-link
          >
          <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ml-auto">
              <li class="nav-item">
                <router-link to="/listmovie" class="nav-link text-light"
                  >Lista de peliculas</router-link
                >
              </li>
              <li class="nav-item">
                <router-link to="/drag" class="nav-link text-light"
                  >Drag and drop</router-link
                >
              </li>
            </ul>
          </div>
        </div>
      </nav>
      <h1 class="display-4 mt-4">¡Bienvenido a AndyLiss Films!</h1>
      <p class="lead">
        Descubre una selección impresionante de películas para disfrutar en la
        comodidad de tu hogar.
      </p>
    </header>
    <b-container fluid>
      <b-row>
        <b-col class="border">
          <b-form>
            <b-form-group
              id="input-group-1"
              label="Titulo de la pelicula"
              label-for="input-1"
            >
              <b-form-input
                id="input-1"
                v-model="movie.name"
                type="text"
                required
              ></b-form-input>
            </b-form-group>

            <b-form-group
              id="input-group-2"
              label="description"
              label-for="input-2"
            >
              <b-form-input
                id="input-2"
                v-model="email.description"
                required
              ></b-form-input>
            </b-form-group>

            <b-form-group id="input-group-3" label="Genero" label-for="input-3">
              <b-form-select
                id="input-3"
                v-model="form.food"
                :options="option"
                required
              ></b-form-select>
            </b-form-group>
            <b-button type="submit" variant="primary">Submit</b-button>
            <b-button type="reset" variant="danger">Reset</b-button>
          </b-form>
        </b-col>
      </b-row>
    </b-container>
  </div>
</template>

<script>
export default {
    data() {
        movie:{
            name:'',
            gender:'',
            description:''
        },
        option:[
            {id:1,gender:"Accion"},
            {id:2,gender:"Romance"},
            {id:3,gender:"Aventura"},
            {id:4,gender:"fantasia"},
        ]
    }
};
</script>

<style>
</style>