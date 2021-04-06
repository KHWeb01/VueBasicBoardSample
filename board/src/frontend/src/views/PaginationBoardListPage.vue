<template>
  <div id="board">
    <h2>Board List</h2>
    <router-link :to="{ name: 'BoardRegisterPage' }">
      Create New Board
    </router-link>
    <!-- <board-list :boards="boards"/> -->
    <!-- 결국 Vue Component를 만들면 전용 커스텀 tag를 만든것이됨
    언제든지 필요하면 재활용을 할 수 있고 중복 코드를 방지할 수 있음
    :~~~ v-bind와 같은것이므로 전달되는 Vue Component에서
    해당 내용을 어떻게 다룰지에 대해 명시해줘야 한다.
    현재 Vue Component에서는 pageArray를 전달한다.
    전달 받는 대상이 BoardListPageForm 컴포넌트다. -->
    <board-list-page-form :list-array="pageArray"/>
  </div>
</template>

<script>
import axios from 'axios'
import BoardListPageForm from '../components/BoardListPageForm.vue'

export default {
  name: 'PaginationBoardListPage',
  components: {
    BoardListPageForm
  },
  data () {
    return {
      pageArray: []
    }
  },
  created () {
    axios.get('http://localhost:7777/boards')
      .then(res => {
        this.pageArray = res.data
      })
      .catch(err => {
        console.log(err)
      })
  }
}

</script>

<style>
h1 {
  color: #454545;
  text-align: center;
}
</style>
