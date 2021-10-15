import request from '@/utils/request'

export function login(username, password) {
  return request({
    url: '/user/login',
    method: 'post',
    data: {username, password}
  })
}

export function getInfo(token) {
  return request({
    url: '/vue-admin-template/user/info',
    method: 'get',
    params: { token }
  })
}

export function logout() {
  return request({
    url: '/vue-admin-template/user/logout',
    method: 'post'
  })
}

export function regist(username, password, des){
  return request({
    url:'/user/regist',
    method:'post',
    data:{username, password, des}

  })
}


export function getAdminList() {
  return request({
    url: '/user/adminList',
    method: 'get'
  })
}


export function getUserList(){
  return request({
    url: '/user/userList',
    method: 'get'
  })
}


export function deleteUser(username){
  return request({
    url: '/u/deleteUser',
    method: 'delete',
    data:{username}
  })
}


export function deleteAdmin(username){
  return request({
    url: '/user/deleteAdmin',
    method: 'delete',
    data:{username}
  })
}