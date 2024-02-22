<template>
  <div>
    <!-- Navbar -->
    <b-navbar style="background-color: #026c80;">
      <b-navbar-brand to="/" class="text-light">AndyLiss Filmsy</b-navbar-brand>
    </b-navbar>
    <b-jumbotron class="text-center" style="background-color: #026c80; color: white;">
      <template #header>
        Cartelera
      </template>
      <template #lead>
        Descubre una selección impresionante de películas para disfrutar en la comodidad de tu hogar.
      </template>
    </b-jumbotron>

    <!-- Sidebar para agregar película -->
    <b-sidebar id="sidebar-right" title="Agregar Película" right shadow v-model="showSidebar">
      <b-container>
        <b-form @submit.prevent="registerMovie">
          <b-form-group label="Nombre de la película">
            <b-form-input v-model="newMovie.title"></b-form-input>
          </b-form-group>
          <b-form-group label="Género">
            <b-form-select v-model="newMovie.genre" :options="genresOptions"></b-form-select>
          </b-form-group>
          <b-form-group label="Descripción">
            <b-form-textarea v-model="newMovie.description"></b-form-textarea>
          </b-form-group>
          <b-button type="submit" variant="primary">Registrar</b-button>
        </b-form>
      </b-container>
    </b-sidebar>
    <section class="container my-5">
      <!-- Filtrado y búsqueda -->
      <div class="row mb-3">
        <div class="col-md-4">
          <b-form-input v-model="searchQuery" placeholder="Buscar por nombre de película"></b-form-input>
        </div>
        <div class="col-md-4">
          <b-form-select v-model="selectedGenre" :options="genresOptions" :value="selectedGenre" placeholder="Todos los géneros"></b-form-select>
        </div>
        <div class="col-md-4 text-right">
          <b-button variant="primary" @click="showSidebar = true">
            <b-icon icon="camera-reels-fill" class="mr-1"></b-icon>
            Agregar
          </b-button>
        </div>
      </div>
      <div class="row">
        <div class="col-md-4" v-for="(movie, index) in paginatedMovies" :key="index">
          <b-card>
            <b-card-body>
              <h5 class="card-title">{{ movie.title }}</h5>
              <p class="card-text"><strong>Género:</strong> {{ movie.genre }}</p>
              <p class="card-text"><strong>Descripción:</strong> {{ movie.description }}</p>
            </b-card-body>
          </b-card>
        </div>
      </div>

      <!-- Paginación -->
      <div class="row mt-4">
        <div class="col-md-12">
          <b-pagination v-model="currentPage" :total-rows="filteredMovies.length" :per-page="moviesPerPage"></b-pagination>
        </div>
      </div>
    </section>
    <b-alert v-model="showErrorAlert" variant="danger" dismissible fade @dismissed="showErrorAlert = false">
      Ocurrió un error al obtener las películas. Por favor, inténtalo de nuevo más tarde.
    </b-alert>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      movies: [],
      currentPage: 1,
      moviesPerPage: 3,
      selectedGenre: null,
      searchQuery: '',
      showSidebar: false,
      newMovie: {
        title: '',
        genre: '',
        description: ''
      },
      showErrorAlert: false
    };
  },
  computed: {
    filteredMovies() {
      let filtered = this.movies;
      if (this.selectedGenre) {
        filtered = filtered.filter(movie => movie.genre === this.selectedGenre);
      }
      if (this.searchQuery) {
        filtered = filtered.filter(movie => movie.title.toLowerCase().includes(this.searchQuery.toLowerCase()));
      }
      return filtered;
    },
    paginatedMovies() {
      const startIndex = (this.currentPage - 1) * this.moviesPerPage;
      return this.filteredMovies.slice(startIndex, startIndex + this.moviesPerPage);
    },
    genresOptions() {
      return [{ text: 'Todos los géneros', value: null }].concat(
        [...new Set(this.movies.map(movie => movie.genre))]
          .map(genre => ({ text: genre, value: genre }))
      );
    }
  },
  methods: {
    async registerMovie() {
      try {
        const response = await axios.post('/api/movies/saveMovie', this.newMovie);
        this.movies.push(response.data.payload);
        this.resetForm();
        this.showSidebar = false;
      } catch (error) {
        console.error('Error al registrar película:', error);
        this.showErrorAlert = true; 
      }
    },
    resetForm() {
      this.newMovie.title = '';
      this.newMovie.genre = '';
      this.newMovie.description = '';
    }
  },
  async created() {
    try {
      const response = await axios.get('/api/movies/');
      this.movies = response.data.payload;
    } catch (error) {
      console.error('Error al obtener películas:', error);
      this.showErrorAlert = true; 
    }
  }
};
</script>

<style>
</style>
