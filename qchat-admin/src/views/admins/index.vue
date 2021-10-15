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
      <el-table-column label="管理员账号" width="110" align="center" prop="username">
      </el-table-column>
      <el-table-column label="创建日期" width="200" align="center" prop="createDate">
      </el-table-column>
      <el-table-column label="备注" align="center" prop="des">
        
      </el-table-column>
      <el-table-column label="操作" width="100" align="center">
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
      
      <!-- 
        <el-table-column class-name="status-col" label="Status" width="110" align="center">
        <template slot-scope="scope">
          <el-tag :type="scope.row.status | statusFilter">{{ scope.row.status }}</el-tag>
        </template>
      </el-table-column>
      <el-table-column align="center" prop="created_at" label="Display_time" width="200">
        <template slot-scope="scope">
          <i class="el-icon-time" />
          <span>{{ scope.row.display_time }}</span>
        </template>
      </el-table-column> 
      -->
    </el-table>
  </div>
</template>

<script>
import { getAdminList,deleteAdmin } from '@/api/user'

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
      getAdminList().then(response => {
        console.log("====admin");
        
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

      deleteAdmin(column.username).then(response => {
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
