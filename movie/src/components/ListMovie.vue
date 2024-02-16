<template>
  <div>
    <header
      class="text-light text-center py-5"
      style="background-color: #026c80"
    >
      <nav
        class="navbar navbar-expand-lg text-light"
        style="background-color: #026c80"
      >
        <div class="container">
          <router-link to="/" class="navbar-brand text-light"
            >Lista de peliculas</router-link
          >
          <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ml-auto">
              <li class="nav-item">
                <router-link to="/inicio" class="nav-link text-light"
                  >Inicio</router-link
                >
              </li>
            </ul>
          </div>
        </div>
      </nav>
      <h1 class="display-4 mt-4">Cartelera</h1>
    </header>
    <section class="container my-5">
      <div>
        <div class="row mb-3">
          <div class="col-md-4">
            <input
              type="text"
              class="form-control"
              v-model="searchQuery"
              placeholder="Buscar por nombre de película"
            />
          </div>
          <div class="col-md-4">
            <select class="form-control" v-model="selectedGenre">
              <option value="">Todos los géneros</option>
              <option v-for="genre in genres" :key="genre" :value="genre">
                {{ genre }}
              </option>
            </select>
          </div>
          <div class="col-md-4 text-right">
            <button class="btn btn-custom text-white" @click="openSidebar">
              <b-icon
                icon="camera-reels-fill"
                font-scale="1"
                class="text-white"
              ></b-icon>
              Agregar
            </button>
            <b-sidebar
              id="sidebar-right"
              title="Agregar Película"
              right
              shadow
              v-model="showSidebar"
            >
              <div class="px-3 py-2">
                <div class="mb-3">
                  <label for="movieTitle" class="form-label"
                    >Nombre de la película:</label
                  >
                  <input
                    type="text"
                    class="form-control"
                    id="movieTitle"
                    v-model="newMovie.title"
                  />
                </div>
                <div class="mb-3">
                  <label for="movieGenre" class="form-label">Género:</label>
                  <select
                    class="form-control"
                    id="movieGenre"
                    v-model="newMovie.genre"
                  >
                    <option v-for="genre in genres" :key="genre" :value="genre">
                      {{ genre }}
                    </option>
                  </select>
                </div>
                <div class="mb-3">
                  <label for="movieDescription" class="form-label"
                    >Descripción:</label
                  >
                  <textarea
                    class="form-control"
                    id="movieDescription"
                    v-model="newMovie.description"
                  ></textarea>
                </div>
                <button class="btn btn-primary" @click="registerMovie">
                  Registrar
                </button>
              </div>
            </b-sidebar>
          </div>
        </div>

        <div class="row">
          <div
            class="col-md-4"
            v-for="(movie, index) in paginatedMovies"
            :key="index"
          >
            <div class="card">
              <div class="card-body">
                <h5 class="card-title">{{ movie.title }}</h5>
                <p class="card-text">
                  <strong>Género:</strong> {{ movie.genre }}
                </p>
                <p class="card-text">
                  <strong>Descripción:</strong> {{ movie.description }}
                </p>
              </div>
            </div>
          </div>
        </div>

        <div class="row mt-4">
          <div class="col-md-12">
            <nav aria-label="Page navigation example">
              <ul class="pagination justify-content-center">
                <li
                  class="page-item"
                  v-for="page in totalPages"
                  :key="page"
                  :class="{ active: page === currentPage }"
                >
                  <a class="page-link" @click="changePage(page)">{{ page }}</a>
                </li>
              </ul>
            </nav>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
export default {
  data() {
    return {
      movies: [
        { title: 'Pelicula 1', genre: 'Aventura', description: 'Descripción de la Película 1' },
        { title: 'Pelicula 2', genre: 'Comedia', description: 'Descripción de la Película 2' },
        { title: 'Pelicula 3', genre: 'Drama', description: 'Descripción de la Película 3' },
        { title: 'Pelicula 4', genre: 'Acción', description: 'Descripción de la Película 4' },
        { title: 'Pelicula 5', genre: 'Terror', description: 'Descripción de la Película 5' },
      ],
      currentPage: 1,
      moviesPerPage: 3,
      selectedGenre: null,
      searchQuery: '',
      showSidebar: false,
      newMovie: {
        title: '',
        genre: '',
        description: ''
      }
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
    totalPages() {
      return Math.ceil(this.filteredMovies.length / this.moviesPerPage);
    },
    genres() {
      return this.movies.reduce((acc, movie) => {
        if (!acc.includes(movie.genre)) {
          acc.push(movie.genre);
        }
        return acc;
      }, []);
    }
  },
  methods: {
    changePage(page) {
      this.currentPage = page;
    },
    openSidebar() {
      this.showSidebar = true;
    },
    registerMovie() {
      // Validar que los campos no estén vacíos
      if (this.newMovie.title && this.newMovie.genre && this.newMovie.description) {
        // Agregar la nueva película al arreglo de películas
        this.movies.push({
          title: this.newMovie.title,
          genre: this.newMovie.genre,
          description: this.newMovie.description
        });
        // Limpiar los campos del formulario
        this.newMovie.title = '';
        this.newMovie.genre = '';
        this.newMovie.description = '';
        // Cerrar el sidebar después de agregar la película
        this.showSidebar = false;
      } else {
        alert('Por favor, complete todos los campos antes de registrar la película.');
      }
    }
  }
};
</script>

<style scoped>
.btn-custom {
  background-color: #ed6335;
  border-color: #ed6335;
}

.btn-custom:hover {
  background-color: #d65d31;
  border-color: #d65d31;
}
</style>
