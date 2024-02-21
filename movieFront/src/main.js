import Vue from 'vue'
import App from './App.vue'
import router from './router/index'


import axios from 'axios'
import VueAxios from 'vue-axios'
import Vuelidate from 'vuelidate'
import VueSweetalert2 from 'vue-sweetalert2';
import { BootstrapVue, IconsPlugin } from 'bootstrap-vue'
import Loading from 'vue-loading-overlay'

import './assets/main.css'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import 'sweetalert2/dist/sweetalert2.min.css';
import 'vue-loading-overlay/dist/vue-loading.css';

import { library } from '@fortawesome/fontawesome-svg-core'
import { fas } from '@fortawesome/free-solid-svg-icons'
import { far } from '@fortawesome/free-regular-svg-icons'
import { fab } from '@fortawesome/free-brands-svg-icons'
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'


Vue.use(BootstrapVue)
Vue.use(IconsPlugin)
Vue.use(Vuelidate)
Vue.use(VueSweetalert2);
Vue.use(VueAxios, axios)


library.add(fas, far, fab)
Vue.component('font-awesome-icon', FontAwesomeIcon)


Vue.config.productionTip = false

new Vue({
   router,
   render: (h) => h(App)
}).$mount('#app')