import VueRouter from "vue-router";
import Vue from "vue";

Vue.use(VueRouter);

const routes = [
    {
        path:'/',
        redirect:'/inicio'
    },
    //Las rutas asociadas
    {
        path:'/',
        component:{
            render(c){
                return c('router-view');
            },
        },
        //Los componentes que se renderizan en router-view
        children:[
            {
                path:'/inicio',
                name:'inicio',
                component: () => import('../components/Inicio.vue')
            },
            {
                path:'/listmovie',
                name:'list',
                component: () => import('../components/ListMovie.vue')
            },
            /* {
                path:'/savemovie',
                name:'movie',
                component: () => import('../components/SaveMovie.vue')
            } */,
            {
                path:'/drag',
                name:'drag',
                component: () => import('../components/dragandDrop.vue')
            }


        ]
    }
]

const router = new VueRouter({routes,});
export default router;