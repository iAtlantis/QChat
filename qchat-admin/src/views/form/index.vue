<template>
  <div class="app-container">
    <el-form ref="form" :model="form" label-width="120px">

      <el-form-item label="管理员名称*：">
<!--        <p style="color:#FF0000">*</p>-->
        <el-input v-model="form.name" />
      </el-form-item>

      <el-form-item label="密码*：">
        <el-input v-model="form.password" type="password"/>
        <!-- <span class="show-pwd" @click="showPwd">
          <svg-icon :icon-class="passwordType === 'password' ? 'eye' : 'eye-open'" />
        </span> -->
      </el-form-item>

      <el-form-item label="确认密码*：">
        <el-input v-model="form.passwordRe" type="password"/>
        <!-- <span class="show-pwd" @click="showPwd">
          <svg-icon :icon-class="passwordType === 'password' ? 'eye' : 'eye-open'" />
        </span> -->
      </el-form-item>

      <!-- <el-form-item label="Activity zone">
        <el-select v-model="form.region" placeholder="please select your zone">
          <el-option label="Zone one" value="shanghai" />
          <el-option label="Zone two" value="beijing" />
        </el-select>
      </el-form-item> -->

      <!-- <el-form-item label="Activity time">
        <el-col :span="11">
          <el-date-picker v-model="form.date1" type="date" placeholder="Pick a date" style="width: 100%;" />
        </el-col>
        <el-col :span="2" class="line">-</el-col>
        <el-col :span="11">
          <el-time-picker v-model="form.date2" type="fixed-time" placeholder="Pick a time" style="width: 100%;" />
        </el-col>
      </el-form-item> -->

      <!-- <el-form-item label="Instant delivery">
        <el-switch v-model="form.delivery" />
      </el-form-item> -->

      <el-form-item label="管理员权限*：">
        <el-checkbox-group v-model="form.type">
          <el-checkbox label="deleteUser" name="type" />

        </el-checkbox-group>
      </el-form-item>

      <!-- <el-form-item label="Resources">
        <el-radio-group v-model="form.resource">
          <el-radio label="Sponsor" />
          <el-radio label="Venue" />
        </el-radio-group>
      </el-form-item> -->

      <el-form-item label="管理员描述：">
        <el-input v-model="form.desc" type="textarea" />
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="onSubmit">Create</el-button>
        <el-button @click="onCancel">Cancel</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import {regist} from '@/api/user.js'
export default {
  data() {


    return {
      form: {
        name: '',
        password:'',
        passwordRe:'',
        type: [],
        desc: ''
      }
    }
  },
  methods: {
    onSubmit() {
      this.$message('submit!')
      regist(this.form.name, this.form.password, this.form.desc).then(
        res=>{
          const data = res.data
          if(data.status==200){
              this.$message.success(data.msg)
              this.form = {
                  name: '',
                  password:'',
                  passwordRe:'',
                  type: [],
                  desc: ''
                }
          }else{
              this.$message.error(data.msg)
          }
        }
      )

    },
    onCancel() {
      this.$message({
        message: 'cancel!',
        type: 'warning'
      })
    },
    showPwd() {
      if (this.passwordType === 'password') {
        this.passwordType = ''
      } else {
        this.passwordType = 'password'
      }
      this.$nextTick(() => {
        this.$refs.password.focus()
      })
    }
  }
}
</script>

<style scoped>
.line{
  text-align: center;
}
</style>

