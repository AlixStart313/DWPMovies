<template>
  <div>
    <header class="text-light text-center py-5" style="background-color: #026c80">
      <nav class="navbar navbar-expand-lg" style="background-color: #026c80">
        <div class="container">
          <router-link to="/" class="navbar-brand text-light">AndyLiss Filmsy</router-link>
          <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ml-auto">
              <li class="nav-item">
                <router-link to="/listmovie" class="nav-link text-light">Lista de peliculas</router-link>
              </li>
              <li class="nav-item">
                <router-link to="/drag" class="nav-link text-light">Drag and drop</router-link>
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
        <b-col class="my-2">
          <b-card class="my-2" draggable="true" @dragstart="handleDragStart(index)">
            <b-form>
              <b-form-group id="input-group-1" label="Titulo de la pelicula" label-for="input-1">
                <b-form-input id="input-1" v-model="movie.name" type="text" required></b-form-input>
              </b-form-group>

              <b-form-group id="input-group-2" label="description" label-for="input-2">
                <b-form-input id="input-2" v-model="movie.description" required></b-form-input>
              </b-form-group>

              <b-form-group id="input-group-2" label="description" label-for="input-2">
                <b-form-input id="input-2" v-model="movie.directorsName" required></b-form-input>
              </b-form-group>

              <b-form-group id="input-group-3" label="Genero" label-for="input-3">
                <b-form-select id="input-3" v-model="movie.gender" :options="option" required></b-form-select>

              </b-form-group>
              <b-button type="submit" variant="primary">Submit</b-button>
              <b-button type="reset" variant="danger">Reset</b-button>
            </b-form>
          </b-card>
        </b-col>
      </b-row>
      <b-row>
        <b-col>
          <b-card class="text-center mt-3 mb-5">
            <h3>Sin registros</h3>
            <b-row>
              <b-col>
                <TransitionGroup name="bounceDown" tag="div" class="list-group">
                  <li v-for="item of items" class="list-group-item" :key="item">
                    {{ item }}
                  </li>
                </TransitionGroup>
              </b-col>
            </b-row>
          </b-card>
        </b-col>
      </b-row>
    </b-container>
  </div>
</template>

<script>
export default {
  data() {
    return {
      movie: {
        name: '',
        gender: 0,
        description: '',
        publicacionDate: new Date(),
        directorsName: ''
      },
      option: [
        { id: 1, gender: "Accion" },
        { id: 2, gender: "Romance" },
        { id: 3, gender: "Aventura" },
        { id: 4, gender: "fantasia" },
      ]
    };
  },
  methods: {
    handleDragStart(index) {
      // Guardamos el índice del elemento arrastrado
      event.dataTransfer.setData("text/plain", index);
    },
    handleDrop(event) {
      // Prevenir el comportamiento predeterminado
      event.preventDefault();

      // Obtener el índice del elemento arrastrado
      const index = event.dataTransfer.getData("text/plain");

      // Obtener el texto del elemento arrastrado
      const itemText = this.items[index];

      // Obtener el índice del contenedor donde se soltó el elemento
      const dropIndex = this.items.indexOf(event.target.innerText);

      // Eliminar el elemento de la lista original
      this.items.splice(index, 1);

      // Insertar el elemento en su nueva posición
      this.items.splice(dropIndex, 0, itemText);
    },
  },
};
</script>

<style></style>