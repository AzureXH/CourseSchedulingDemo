<template>
  <div class="main-container">
    <div v-if="tableData" class="table-container">
      <el-table
        :data="tableData"
        style="width: 100%"
        :default-sort = "{prop: 'department', order: 'descending'}">

        <el-table-column type="expand">
          <template slot-scope="props">
            <el-form label-position="left" class="demo-table-expand">
              <el-form-item>
                <label>教授课程 </label>
                <span>{{ props.row.course }}</span>
              </el-form-item>
            </el-form>
          </template>
        </el-table-column>

        <el-table-column
          prop="department"
          label="所属院系"
          width="500"
          sortable>
        </el-table-column>
        <el-table-column
          prop="name"
          label="姓名"
          width="500">
        </el-table-column>
        <el-table-column
          prop="title"
          label="职称"
          width="500"
          sortable>
        </el-table-column>
        <el-table-column
          fixed="right"
          label="操作"
          width="200">
          <template slot-scope="scope">
            <el-button @click="editFormVisible = true;editParams(scope.row)" type="primary" icon="el-icon-edit">编辑</el-button>
            <el-button @click="deleteForTeacher(scope.row)" type="danger" icon="el-icon-delete">删除</el-button>
          </template>
        </el-table-column>
      </el-table>

      <div class="addContainer" style="margin-top: 20px">

        <el-button @click="dialogFormVisible = true" type="primary" icon="el-icon-plus">添加</el-button>
        
        <el-dialog title="添加教师" :visible.sync="dialogFormVisible">

          <el-form :model="form">

            <el-form-item label="教师所属院系" :label-width="formLabelWidth">
              <el-select v-model="form.department" placeholder="请选择教师所属院系">
                <el-option label="工程管理学院" value="工程管理学院"></el-option>
                <el-option label="计算机科学与技术系" value="计算机科学与技术系"></el-option>
                <el-option label="软件学院" value="软件学院"></el-option>
                <el-option label="外国语学院" value="外国语学院"></el-option>
                <el-option label="数学系" value="数学系"></el-option>
              </el-select>
            </el-form-item>

            <el-form-item label="教师姓名" :label-width="formLabelWidth">
              <el-input v-model="form.name" placeholder="请输入教师姓名" ></el-input>
            </el-form-item>

            <el-form-item label="教师职称" :label-width="formLabelWidth">
              <el-select v-model="form.title" placeholder="请选择教师职称">
                <el-option label="教授" value="教授"></el-option>
                <el-option label="副教授" value="副教授"></el-option>
                <el-option label="讲师" value="讲师"></el-option>
              </el-select>
            </el-form-item>

          </el-form>

          <div slot="footer" class="dialog-footer">
            <el-button @click="dialogFormVisible = false">取 消</el-button>
            <el-button type="primary" @click="addForTeacher">确 定</el-button>
          </div>

        </el-dialog>

      </div>

      <el-dialog title="修改教师" :visible.sync="editFormVisible" :before-close="clearForm">

        <el-form :model="form">

          <el-form-item label="教师所属院系" :label-width="formLabelWidth">
            <el-select v-model="form.department" placeholder="请选择教师所属院系">
              <el-option label="工程管理学院" value="工程管理学院"></el-option>
              <el-option label="计算机科学与技术系" value="计算机科学与技术系"></el-option>
              <el-option label="软件学院" value="软件学院"></el-option>
              <el-option label="外国语学院" value="外国语学院"></el-option>
              <el-option label="数学系" value="数学系"></el-option>
            </el-select>
          </el-form-item>

          <el-form-item label="教师姓名" :label-width="formLabelWidth">
            <el-input v-model="form.name" placeholder="请输入教师姓名" ></el-input>
          </el-form-item>

          <el-form-item label="教师职称" :label-width="formLabelWidth">
            <el-select v-model="form.title" placeholder="请选择教师职称">
              <el-option label="教授" value="教授"></el-option>
              <el-option label="副教授" value="副教授"></el-option>
              <el-option label="讲师" value="讲师"></el-option>
            </el-select>
          </el-form-item>

        </el-form>

        <div slot="footer" class="dialog-footer">
          <el-button @click="editFormVisible = false; clearForm()">取 消</el-button>
          <el-button type="primary" @click="editForTeacher()">确 定</el-button>
        </div>

      </el-dialog>


    </div>

  </div>
</template>
<script>
import axios from 'axios';

export default {
    name:'teacher',
    data() {
      return{
        tableData: null,
        dialogFormVisible: false,
        editFormVisible: false,
        form:{
          department: '',
          name: '',
          title: '',
          course:[]
        },
        formLabelWidth: '150px',
        editTeacherId: 0,
      };
    },
    created() {
      this.fetchData();
    },
    watch: {
    // 如果路由有变化，会再次执行该方法
      '$route': 'fetchData'
    },
    computed: {
      
    },
    methods: {
      fetchData() {
        axios.get('/teacher/get')
        .then(res => {
          this.tableData = res.data;
        })
      },
      addForTeacher(){
        axios.post('/teacher/add',{
          department: this.form.department,
          name: this.form.name,
          title: this.form.title,
        }).then(res => {
          this.clearForm();
          this.fetchData();
        })
      },
      editParams(teacher){
        this.editTeacherId = teacher.id;
        this.form.department = teacher.department;
        this.form.name = teacher.name;
        this.form.title = teacher.title;
      },
      editForTeacher(teacher){
        axios.post('/teacher/update',{
          id: this.editTeacherId,
          department: this.form.department,
          name: this.form.name,
          title: this.form.title,
        }).then(res => {
          this.clearForm();
          this.fetchData();
        })
      },
      deleteForTeacher(teacher){
        this.$confirm('此操作将永久删除该教师信息，是否继续？','删除确认',{
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(()=> {
        
          axios.post('/teacher/delete',teacher)
          .then(res => {
            this.fetchData();
          });
          this.$message({
            type: 'success',
            message: '删除成功！'
          });

        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          }); 
        });
      },
      clearForm(){
        this.editTeacherId = 0;
        this.form.department = '';
        this.form.name = '';
        this.form.title = '';
        this.dialogFormVisible = false;
        this.editFormVisible = false;
      }
    },
}
</script>

<style scoped>

.el-table{
  font-size: 20px;
}

.demo-table-expand .el-form-item{
  font-size: 20px;
}
.demo-table-expand label {
  width: 90px;
  color: #99a9bf;
  font-size: 20px;
}
.demo-table-expand .el-form-item span{
  margin-right: 0;
  margin-bottom: 0;
  width: 50%;
  font-size: 20px;
}
</style>

