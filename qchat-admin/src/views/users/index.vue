<template>
  <div class="app-container">
    <el-table
      v-loading="listLoading"
      :data="list"
      element-loading-text="Loading"
      border
      fit
      highlight-current-row
    >
      <el-table-column align="center" label="序号" width="95">
        <template slot-scope="scope">
          {{ scope.$index + 1 }}
        </template>
      </el-table-column>
      <el-table-column label="用户账号" align="center" prop="username">
      </el-table-column>
      <el-table-column label="用户名" align="center" prop="nickname">
      </el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button
                type="text"
                icon="el-icon-delete"
                class="red"
                @click="confirmDelete(scope.row)"
            >删除
            </el-button>
      </template>
      </el-table-column>
      
    </el-table>
  </div>
</template>

<script>
import { getUserList, deleteUser } from '@/api/user'


export default {
  filters: {
    statusFilter(status) {
      const statusMap = {
        published: 'success',
        draft: 'gray',
        deleted: 'danger'
      }
      return statusMap[status]
    }
  },
  data() {
    return {
      list: [],
      listLoading: true
    }
  },
  created() {
    this.fetchData()
  },
  methods: {
    fetchData() {
      this.listLoading = true
      getUserList().then(response => {
        console.log("===user");

        const data = response.data

        if(data.status == 200){
          this.list = data.data
          this.listLoading = false
        }else{
          this.$message.error(data.msg)
        }
      })
    },
    confirmDelete(column){

      deleteUser(column.username).then(response => {
        const data = response.data

        if(data.status == 200){
          this.$message.success("成功删除："+column.username)
          this.fetchData()
          }
      })
      
    }
  }
}
</script>
