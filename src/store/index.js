import Vue from 'vue'
import Vuex from 'vuex'
import AuthService from '../services/auth.service';

Vue.use(Vuex)

const user = JSON.parse(localStorage.getItem('user'));
const initialState = user
  ? { status: { loggedIn: true }, user }
  : { status: { loggedIn: false }, user: null };

const state = {
  initialState
}

const mutations = {
  loginSuccess(state, user) {
    state.initialState.status.loggedIn = true;
    state.initialState.user = user;
  },
  loginFailure(state) {
      state.initialState.status.loggedIn = false;
      state.initialState.user = null;
  },
  logout(state) {
      state.initialState.status.loggedIn = false;
      state.initialState.user = null;
  },
  registerSuccess(state) {
      state.initialState.status.loggedIn = false;
  },
  registerFailure(state) {
      state.initialState.status.loggedIn = false;
  }   
}

const actions = {
  login({ commit }, user) {
    return AuthService.login(user).then(
        user => {
        commit('loginSuccess', user);
        return Promise.resolve(user);
        },
        error => {
        commit('loginFailure');
        return Promise.reject(error);
        }
    );
  },
  logout({ commit }) {
      AuthService.logout();
      commit('logout');
  }
}

const store = new Vuex.Store({
  strict: true, // process.env.NODE_ENV !== 'production',
  mutations,
  state,
  actions,
})

export default store