import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Home from '@/components/Home'
import Login from '@/components/Login'

Vue.use(Router)

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/HelloWorld',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/',
      name: 'home',
      component: Home
    },
    {
      path: '/login',
      name: 'Login',
      component: Login,
    }
  ]
})

router.beforeEach((to, from, next) => {
  const publicPages = ['Login'];
  const authRequired = !publicPages.includes(to.name);
  const loggedIn = localStorage.getItem('user');
    
  if (authRequired && !loggedIn) {
    router.push({ name: 'Login', query: { to: to.path }});
  } else {
    next();
  }
});

export default router