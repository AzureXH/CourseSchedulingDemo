(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-217c3d5d"],{"35e0":function(t,e,a){"use strict";var l=a("4ed4"),o=a.n(l);o.a},"4ed4":function(t,e,a){},"7f7f":function(t,e,a){var l=a("86cc").f,o=Function.prototype,r=/^\s*function ([^ (]*)/,i="name";i in o||a("9e1e")&&l(o,i,{configurable:!0,get:function(){try{return(""+this).match(r)[1]}catch(t){return""}}})},f557:function(t,e,a){"use strict";a.r(e);var l=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"main-container"},[t.tableData?a("div",{staticClass:"table-container"},[a("el-table",{staticStyle:{width:"100%"},attrs:{data:t.tableData,"default-sort":{prop:"department",order:"descending"}}},[a("el-table-column",{attrs:{type:"expand"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-form",{staticClass:"demo-table-expand",attrs:{"label-position":"left"}},[a("el-form-item",[a("label",[t._v("教授课程 ")]),a("span",[t._v(t._s(e.row.course))])])],1)]}}],null,!1,3764565329)}),a("el-table-column",{attrs:{prop:"department",label:"所属院系",width:"500",sortable:""}}),a("el-table-column",{attrs:{prop:"name",label:"姓名",width:"500"}}),a("el-table-column",{attrs:{prop:"title",label:"职称",width:"500",sortable:""}}),a("el-table-column",{attrs:{fixed:"right",label:"操作",width:"200"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-button",{attrs:{type:"primary",icon:"el-icon-edit"},on:{click:function(a){t.editFormVisible=!0,t.editParams(e.row)}}},[t._v("编辑")]),a("el-button",{attrs:{type:"danger",icon:"el-icon-delete"},on:{click:function(a){return t.deleteForTeacher(e.row)}}},[t._v("删除")])]}}],null,!1,1789990037)})],1),a("div",{staticClass:"addContainer",staticStyle:{"margin-top":"20px"}},[a("el-button",{attrs:{type:"primary",icon:"el-icon-plus"},on:{click:function(e){t.dialogFormVisible=!0}}},[t._v("添加")]),a("el-dialog",{attrs:{title:"添加教师",visible:t.dialogFormVisible},on:{"update:visible":function(e){t.dialogFormVisible=e}}},[a("el-form",{attrs:{model:t.form}},[a("el-form-item",{attrs:{label:"教师所属院系","label-width":t.formLabelWidth}},[a("el-select",{attrs:{placeholder:"请选择教师所属院系"},model:{value:t.form.department,callback:function(e){t.$set(t.form,"department",e)},expression:"form.department"}},[a("el-option",{attrs:{label:"工程管理学院",value:"工程管理学院"}}),a("el-option",{attrs:{label:"计算机科学与技术系",value:"计算机科学与技术系"}}),a("el-option",{attrs:{label:"软件学院",value:"软件学院"}}),a("el-option",{attrs:{label:"外国语学院",value:"外国语学院"}}),a("el-option",{attrs:{label:"数学系",value:"数学系"}})],1)],1),a("el-form-item",{attrs:{label:"教师姓名","label-width":t.formLabelWidth}},[a("el-input",{attrs:{placeholder:"请输入教师姓名"},model:{value:t.form.name,callback:function(e){t.$set(t.form,"name",e)},expression:"form.name"}})],1),a("el-form-item",{attrs:{label:"教师职称","label-width":t.formLabelWidth}},[a("el-select",{attrs:{placeholder:"请选择教师职称"},model:{value:t.form.title,callback:function(e){t.$set(t.form,"title",e)},expression:"form.title"}},[a("el-option",{attrs:{label:"教授",value:"教授"}}),a("el-option",{attrs:{label:"副教授",value:"副教授"}}),a("el-option",{attrs:{label:"讲师",value:"讲师"}})],1)],1)],1),a("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(e){t.dialogFormVisible=!1}}},[t._v("取 消")]),a("el-button",{attrs:{type:"primary"},on:{click:t.addForTeacher}},[t._v("确 定")])],1)],1)],1),a("el-dialog",{attrs:{title:"修改教师",visible:t.editFormVisible,"before-close":t.clearForm},on:{"update:visible":function(e){t.editFormVisible=e}}},[a("el-form",{attrs:{model:t.form}},[a("el-form-item",{attrs:{label:"教师所属院系","label-width":t.formLabelWidth}},[a("el-select",{attrs:{placeholder:"请选择教师所属院系"},model:{value:t.form.department,callback:function(e){t.$set(t.form,"department",e)},expression:"form.department"}},[a("el-option",{attrs:{label:"工程管理学院",value:"工程管理学院"}}),a("el-option",{attrs:{label:"计算机科学与技术系",value:"计算机科学与技术系"}}),a("el-option",{attrs:{label:"软件学院",value:"软件学院"}}),a("el-option",{attrs:{label:"外国语学院",value:"外国语学院"}}),a("el-option",{attrs:{label:"数学系",value:"数学系"}})],1)],1),a("el-form-item",{attrs:{label:"教师姓名","label-width":t.formLabelWidth}},[a("el-input",{attrs:{placeholder:"请输入教师姓名"},model:{value:t.form.name,callback:function(e){t.$set(t.form,"name",e)},expression:"form.name"}})],1),a("el-form-item",{attrs:{label:"教师职称","label-width":t.formLabelWidth}},[a("el-select",{attrs:{placeholder:"请选择教师职称"},model:{value:t.form.title,callback:function(e){t.$set(t.form,"title",e)},expression:"form.title"}},[a("el-option",{attrs:{label:"教授",value:"教授"}}),a("el-option",{attrs:{label:"副教授",value:"副教授"}}),a("el-option",{attrs:{label:"讲师",value:"讲师"}})],1)],1)],1),a("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(e){t.editFormVisible=!1,t.clearForm()}}},[t._v("取 消")]),a("el-button",{attrs:{type:"primary"},on:{click:function(e){return t.editForTeacher()}}},[t._v("确 定")])],1)],1)],1):t._e()])},o=[],r=(a("7f7f"),a("7338")),i=a.n(r),n={name:"teacher",data:function(){return{tableData:null,dialogFormVisible:!1,editFormVisible:!1,form:{department:"",name:"",title:"",course:[]},formLabelWidth:"150px",editTeacherId:0}},created:function(){this.fetchData()},watch:{$route:"fetchData"},computed:{},methods:{fetchData:function(){var t=this;i.a.get("/teacher/get").then(function(e){t.tableData=e.data})},addForTeacher:function(){var t=this;i.a.post("/teacher/add",{department:this.form.department,name:this.form.name,title:this.form.title}).then(function(e){t.clearForm(),t.fetchData()})},editParams:function(t){this.editTeacherId=t.id,this.form.department=t.department,this.form.name=t.name,this.form.title=t.title},editForTeacher:function(t){var e=this;i.a.post("/teacher/update",{id:this.editTeacherId,department:this.form.department,name:this.form.name,title:this.form.title}).then(function(t){e.clearForm(),e.fetchData()})},deleteForTeacher:function(t){var e=this;this.$confirm("此操作将永久删除该教师信息，是否继续？","删除确认",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){i.a.post("/teacher/delete",t).then(function(t){e.fetchData()}),e.$message({type:"success",message:"删除成功！"})}).catch(function(){e.$message({type:"info",message:"已取消删除"})})},clearForm:function(){this.editTeacherId=0,this.form.department="",this.form.name="",this.form.title="",this.dialogFormVisible=!1,this.editFormVisible=!1}}},s=n,c=(a("35e0"),a("2877")),m=Object(c["a"])(s,l,o,!1,null,"2fc2bd1a",null);e["default"]=m.exports}}]);
//# sourceMappingURL=chunk-217c3d5d.b85f285c.js.map