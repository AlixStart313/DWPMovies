<template>
  <div>
    <header class="text-light text-center py-5" style="background-color: #026c80;">
      <nav class="navbar navbar-expand-lg " style="background-color: #026c80;">
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
        Descubre una selección impresionante de películas para disfrutar en la comodidad de tu hogar.
      </p>
    </header>

    <section class="container my-5">
      <h2 class="text-center mb-4">Tendencia en peliculas</h2>

      <div class="row">
        <div class="col-md-4 mb-4">
          <div class="card">
            <img
             :src="require('@/assets/peli2.jpg')"
              class="card-img-top"
              alt="Feature 1"
            />
            <div class="card-body">
              <h5 class="card-title">Amores, enredos y una boda</h5>
              <p class="card-text">
               Una mujer desesperada (Debra Messing) le paga a un hombre (Dermot Mulroney) 6,000 dólares para que la acompañe a Londres a la boda de su hermana.
              </p>
            </div>
          </div>
        </div>

        <div class="col-md-4 mb-4">
          <div class="card">
            <img
             :src="require('@/assets/peli1.jpg')"
              class="card-img-top"
              alt="Feature 2"
            />
            <div class="card-body">
              <h5 class="card-title">LOS CABALLEROS DEL ZODIACO</h5>
              <p class="card-text">
                Seiya, un adolescente huérfano que vive en las calles y busca a su hermana desaparecida, descubre que es la única persona que puede proteger es a una diosa.
              </p>
            </div>
          </div>
        </div>

        <div class="col-md-4 mb-4">
          <div class="card">
            <img
              :src="require('@/assets/peli3.jpg')"
              class="card-img-top"
              alt="Feature 3"
            />
            <div class="card-body">
              <h5 class="card-title">Como si fuera la primera vez</h5>
              <p class="card-text">
                Henry, biólogo marino, no tiene la mínima intención de comprometerse con nadie, hasta que conoce a Lucy, la chica de sus sueños.
              </p>
            </div>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
export default {};
</script>

<style></style>
z
