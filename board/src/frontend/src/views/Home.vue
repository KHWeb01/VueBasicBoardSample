<template>
  <div class="home">
    <div id="header">
      <button id="login">
        Login
      </button>
      <button id="login">
        Register Admin
      </button>
      <router-link :to="{ name: 'Home' }"
          class="nav-link"
          active-class="active">
        Home
      </router-link>
      <router-link :to="{ name: 'BoardListPage' }"
          class="nav-link"
          active-class="active">
        Board
      </router-link>
      <router-link :to="{ name: 'VueHTMLTest' }"
          clss="nav-link" active-class="active">
        VueHTMLTest
      </router-link>
      <!-- 라우터 페이지
      router > index.js 에 name에 해당하는 페이지 URL 경로 설정
      실제 name에 해당하는 Vue Component를 작성해야함 -->
      <router-link :to="{ name: 'PaginationBoardListPage' }"
          clss="nav-link" active-class="active">
        PaginationBoard
      </router-link>
    </div>
  </div>
</template>

<script>
// @ is an alias to /src
// import HelloWorld from '@/components/HelloWorld.vue'
/* eslint-disable no-unused-vars */
import store from '../store'
import Vue from 'vue'
// import cookies from 'vue-cookies'

// import { mapState, mapGetters, mapActions } from 'vuex'

// Vue.use(cookies)

export default {
  name: 'Home',
  data: function () {
    return {
      message: 'Vue Test Message'
    }
  },
  methods: {
  },
  computed: {
  },
  components: {
  }
}
</script>

<style scoped>
div {
  border: 1px solid #ccc;
}

#header {
  padding: 15px;
  margin-bottom: 15px;
  margin: 5px 5px;
}

img {
  width: auto;
  height: auto;
  max-width: 1000px;
  max-height: 350px;
  display: block;
  margin-left: auto;
  margin-right: auto;
}

#login {
  background-color: #77aadd;
  color: #ffffff;
  font-weight: bold;
  float: right;
}

</style>
