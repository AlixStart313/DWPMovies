<template>
  <div>
    <header class="text-light text-center py-5" style="background-color: #026c80">
      <nav class="navbar navbar-expand-lg text-light" style="background-color: #026c80">
        <div class="container">
          <router-link to="/" class="navbar-brand text-light">Lista de peliculas</router-link>
          <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ml-auto">
              <li class="nav-item">
                <router-link to="/inicio" class="nav-link text-light">Inicio</router-link>
              </li>
            </ul>
          </div>
        </div>
      </nav>
      <h1 class="display-4 mt-4">Cartelera</h1>
    </header>
    <b-container class="my-5">
      <b-row>
        <b-col md="4" class="mb-3">
          <b-form-input v-model="searchQuery" placeholder="Buscar por nombre de película"></b-form-input>
        </b-col>
        <b-col md="4" class="">
          <b-form-select class="form-control " v-model="selected" :options="formattedOptions"></b-form-select>
        </b-col>
        <b-col md="4" class="text-right">
          <b-button variant="primary" @click="openModal">
            <b-icon icon="camera-reels-fill" font-scale="1"></b-icon>Agregar</b-button>
          <b-modal id="saveMovie" size="lg" title="Registro de pelicula">
            <b-container>
              <b-row class="px-3 py-2">
                <b-col md="12">
                  <b-form-group label="Nombre de la película:">
                    <b-form-input v-model="newMovie.title"></b-form-input>
                  </b-form-group>
                </b-col>
                <b-col md="12">
                  <b-form-group label="Género:">
                    <b-form-select class="form-control" v-model="newMovie.genre"
                      :options="formattedOptions"></b-form-select>
                  </b-form-group>
                </b-col>
                <b-col md="12">
                  <b-form-group label="Descripción:">
                    <b-form-textarea v-model="newMovie.description"></b-form-textarea>
                  </b-form-group>
                </b-col>
              </b-row>
            </b-container>
            <template #modal-footer>
              <b-button variant="danger" block @click="closeModal">cerrar Modal</b-button>
              <b-button variant="success" @click="alertConfirmation">Registrar</b-button>
            </template>
          </b-modal>
          <!-- <b-sidebar id="sidebar-right" title="Agregar Película" right shadow v-model="showSidebar">
            
          </b-sidebar> -->
        </b-col>
      </b-row>

      <b-row class="my-5">
        <b-col md="4" v-for="(movie, index) in paginatedMovies" :key="index">
          <b-card>
            <b-card-body>
              <h5 class="card-title">{{ movie.title }}</h5>
              <p class="card-text">
                <strong>Género:</strong> {{ movie.genre }}
              </p>
              <p class="card-text">
                <strong>Descripción:</strong> {{ movie.description }}
              </p>
            </b-card-body>
          </b-card>
        </b-col>
        <b-col v-if="movies.length === 0" class="text-center">
          <h1 class="text-cnter">Sin registros</h1>
        </b-col>
      </b-row>

      <b-row class="mt-4 d-flex d-flex justify-content-center align-items-center">
        <b-col md="12" class="text-center">
          <b-pagination v-if="movies.length === 0" disabled :total-rows="totalMovies" :per-page="perPage"
            v-model="currentPage" @change="changePage"></b-pagination>
          <b-pagination v-else :total-rows="totalMovies" :per-page="perPage" v-model="currentPage"
            @change="changePage"></b-pagination>
        </b-col>
      </b-row>
    </b-container>
  </div>
</template>

<script>
const AxiosClient = require('./axios');

export default {
  data() {
    return {
      searchQuery: '',
      selected: null,
      formattedOptions: [
        { value: null, text: 'Seleccionar Género' },
        { value: 'Accion', text: 'Acción' },
        { value: 'Comedia', text: 'Comedia' },
        { value: 'Drama', text: 'Drama' },
        { value: 'Fantasia', text: 'Fantasía' },
        { value: 'Ciencia Ficcion', text: 'Ciencia Ficción' }
      ],
      newMovie: {
        title: '',
        genre: null,
        description: ''
      },
      showSidebar: false,
      currentPage: 1,
      perPage: 3,
      movies: [/* Inserta aquí tus datos de películas */]
    };
  },
  computed: {
    totalMovies() {
      return this.movies.length;
    },
    paginatedMovies() {
      const start = (this.currentPage - 1) * this.perPage;
      const end = start + this.perPage;
      return this.movies.slice(start, end);
    },
    totalPages() {
      return Math.ceil(this.totalMovies / this.perPage);
    }
  },
  methods: {
    getMovies() {
      AxiosClient.doGet('/movies')
        .then(response => {
          this.movies = response.data;
        })
        .catch(error => {
          console.error('Error al obtener las películas:', error);
        });
    },
    openSidebar() {
      this.showSidebar = true;
    },
    changePage(page) {
      this.currentPage = page;
    },
    registerMovie() {
      console.log("entra aca");
      this.$swal
        .fire({
          text: "¿Desea registrar esta pelicula?",
          icon: "warning",
          title: "Exito",
          showDenyButton: true,
          denyButtonText: "Cancelar",
          confirmButtonColor: "#0d8e66",
          confirmButtonText: "Aceptar",
        })

    },
    openModal() {
      this.$bvModal.show("saveMovie")
    },
    closeModal() {
      this.$bvModal.hide("saveMovie")
    },
    alertConfirmation() {
      this.$swal
        .fire({
          text: "Exito",
          icon: "warning",
          /*   */
          showDenyButton: true,
          denyButtonText: "Cancelar",
          confirmButtonColor: "#0d8e66",
          confirmButtonText: "Aceptar",
        })
        .then(() => {
          if (result.isConfirmed) {
            this.registerMovie()
          }
        });
    }
  },
  mounted(){
   this.getMovies()
  }
};
</script>
