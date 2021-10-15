<template>
  <div class="dashboard-container">
    <div class="dashboard-text"> 欢迎来到QChat管理中心</div>
    <br>
    <img src="@/assets/University.jpg" width="85%">
  </div>
</template>

<script>
import { mapGetters } from 'vuex'

export default {
  name: 'Dashboard',
  computed: {
    ...mapGetters([
      'name'
    ])
  }
}
</script>

<style lang="scss" scoped>
.dashboard {
  &-container {
    margin: 30px;
  }
  &-text {
    font-size: 30px;
    line-height: 46px;
  }
}
</style>
