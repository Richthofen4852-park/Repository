import Vue from 'vue'
import App from './App'
import router from './router'
import store from './store'

import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import * as VeeValidate from 'vee-validate';


Vue.config.productionTip = false
Vue.use(BootstrapVue)
Vue.use(VeeValidate)

new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>'
})