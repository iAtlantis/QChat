(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-18988d77"],{"371d":function(e,s,t){"use strict";t.r(s);var o=function(){var e=this,s=e.$createElement,t=e._self._c||s;return t("div",{staticClass:"app-container"},[t("el-form",{ref:"form",attrs:{model:e.form,"label-width":"120px"}},[t("el-form-item",{attrs:{label:"管理员名称*："}},[t("el-input",{model:{value:e.form.name,callback:function(s){e.$set(e.form,"name",s)},expression:"form.name"}})],1),t("el-form-item",{attrs:{label:"密码*："}},[t("el-input",{attrs:{type:"password"},model:{value:e.form.password,callback:function(s){e.$set(e.form,"password",s)},expression:"form.password"}})],1),t("el-form-item",{attrs:{label:"确认密码*："}},[t("el-input",{attrs:{type:"password"},model:{value:e.form.passwordRe,callback:function(s){e.$set(e.form,"passwordRe",s)},expression:"form.passwordRe"}})],1),t("el-form-item",{attrs:{label:"管理员权限*："}},[t("el-checkbox-group",{model:{value:e.form.type,callback:function(s){e.$set(e.form,"type",s)},expression:"form.type"}},[t("el-checkbox",{attrs:{label:"deleteUser",name:"type"}})],1)],1),t("el-form-item",{attrs:{label:"管理员描述："}},[t("el-input",{attrs:{type:"textarea"},model:{value:e.form.desc,callback:function(s){e.$set(e.form,"desc",s)},expression:"form.desc"}})],1),t("el-form-item",[t("el-button",{attrs:{type:"primary"},on:{click:e.onSubmit}},[e._v("Create")]),t("el-button",{on:{click:e.onCancel}},[e._v("Cancel")])],1)],1)],1)},a=[],r=(t("b0c0"),t("c24f")),n={data:function(){return{form:{name:"",password:"",passwordRe:"",type:[],desc:""}}},methods:{onSubmit:function(){var e=this;this.$message("submit!"),Object(r["h"])(this.form.name,this.form.password,this.form.desc).then((function(s){var t=s.data;200==t.status?(e.$message.success(t.msg),e.form={name:"",password:"",passwordRe:"",type:[],desc:""}):e.$message.error(t.msg)}))},onCancel:function(){this.$message({message:"cancel!",type:"warning"})},showPwd:function(){var e=this;"password"===this.passwordType?this.passwordType="":this.passwordType="password",this.$nextTick((function(){e.$refs.password.focus()}))}}},c=n,l=(t("c939"),t("2877")),m=Object(l["a"])(c,o,a,!1,null,"18911771",null);s["default"]=m.exports},b1c9:function(e,s,t){},c939:function(e,s,t){"use strict";t("b1c9")}}]);