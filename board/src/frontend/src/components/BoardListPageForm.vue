<template>
  <div>
    <h3>Board List View</h3>
    <table border="1">
      <tr>
        <th align="center" width="80">No</th>
        <th align="center" width="320">Title</th>
        <th align="center" width="100">Writer</th>
        <th align="center" width="180">Registration Date</th>
      </tr>
      <tr v-for="page in paginatedData" :key="page.boardNo">
        <td>{{ page.boardNo }}</td>
        <td>{{ page.title }}</td>
        <td>{{ page.writer }}</td>
        <td>{{ page.regDate }}</td>
      </tr>
    </table>
    <div class="btn-cover">
      <button :disabled="pageNum === 0"
        @click="prevPage" class="page-btn">
        이전
      </button>
      <span class="page-count">{{ pageNum + 1 }} / {{ pageCount }} 페이지</span>
      <button :disabled="pageNum >= pageCount - 1"
        @click="nextPage" class="page-btn">
        다음
      </button>
    </div>
  </div>
</template>

<script>
export default {
  name: 'VuetifyListPageForm',
  data () {
    return {
      pageNum: 0
    }
  },
  props: {
    // 이 녀석이 list-array
    // required의 경우는 실제 데이터가 필요함을 의미함
    listArray: {
      type: Array,
      required: true
    },
    // 실제 한 페이지에 몇 개의 보드 데이터를 입력할 것인지의 기준 척도
    pageSize: {
      type: Number,
      default: 20
    }
  },
  methods: {
    // 다음 페이지
    nextPage () {
      this.pageNum += 1
    },
    // 이전 페이지
    prevPage () {
      this.pageNum -= 1
    }
  },
  computed: {
    pageCount () {
      // DB에서 받아온 전체 데이터 개수
      const listLen = this.listArray.length
      // 우리가 디폴트로 설정해놓은 값
      const listSize = this.pageSize
      // ceil(): 천정(올림), floor(): 바닥(버림)
      // 예로 전체가 99개고 기준이 20이라면 4.9x
      // 결국 버림을 하므로 4가 된다.
      let page = Math.floor(listLen / listSize)
      // 4.9x 라면 나머지인 0.9x 때문에 기준치로 나눈 나머지가 남는다.
      // 나머지가 존재한다면 페이지를 하나 더 추가해준다.
      // 없다면 그냥 깔끔하게 기준치로 나눠 떨어지는 상황임
      if (listLen % listSize > 0) {
        page += 1
      }

      return page
    },
    paginatedData () {
      // 즉 한 페이지 내에서 보드 데이터의 시작 인덱스(0 ~ 19)
      // (20 ~ 39), (40, 59), (60 ~ 79) ...
      const start = this.pageNum * this.pageSize
      // 기준치를 포함하도록 끝값을 가져야 하는데
      // 시작 기준이 전부 다르니 시작값을 더해놓는다.
      const end = start + this.pageSize
      // 전체 DB 정보에서 start ~ end까지의 정보만을 출력
      return this.listArray.slice(start, end)
    }
  }
}
</script>
