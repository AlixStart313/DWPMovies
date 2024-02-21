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
              <li class="nav-item">
                <router-link to="/capchat" class="nav-link text-light"
                  >friendly Capchat</router-link
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
    <div>
      <form action="">
        <label for="name">Nombre</label><br />
        <input type="text" id="name" v-model="form.name" required />
        <br />
        <br />
        <div
        ref="container"
          class="frc-captcha"
          data-sitekey="FCMH919S6MGNTSB8"
          data-callback="myCallback"
        ></div>
        <b-button type="submit">Registrar</b-button>
      </form>
    </div>
  </div>
</template>

<script>
import { WidgetInstance } from "friendly-challenge";
import { ref } from "vue";
// importar captcha service
import CaptchaService from "../components/CaptchaService.js"


export default {
  data() {
    return {
      container: ref(),
      widget: ref(),
      formData: ref(),
      form: {
        name: "",
      },
    };
  },
  methods: {
    doneCallback(solution) {
      console.log("Captcha was solved. The form can be submitted.");
      console.log(solution);
      this.verifyCaptcha(solution);
    },
    errorCallback (err) {
    console.log('There was an error when trying to solve the Captcha.');
    console.log(err);
  },
  async verifyCaptcha(){
    let response= await CaptchaService.verificarCaptcha(solution);
    console.log(response);
  }
  },
  mounted() {
    if (this.$refs.container) {
        this.widget= new WidgetInstance(
            this.$refs.container,
            {
                startMode:"auto",
                doneCallback:this.doneCallback,
                errorCallback:this.errorCallback
            }
        )
    }
  },
  before(){
    if(this.widget){
        this.widget.destroy()
    }
  }
};
</script>