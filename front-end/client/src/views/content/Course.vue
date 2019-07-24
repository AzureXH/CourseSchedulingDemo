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
                <label>上课方式 </label>
                <span>{{ props.row.extra }}</span>
              </el-form-item>
            </el-form>
          </template>
        </el-table-column>

        <el-table-column
          prop="department"
          label="开课院系"
          width="400"
          sortable>
        </el-table-column>
        <el-table-column
          prop="teacherDepartment"
          label="教课院系"
          width="400"
          sortable>
        </el-table-column>
        <el-table-column
          prop="name"
          label="课程名称"
          width="400"
          sortable>
        </el-table-column>
        <el-table-column
          prop="term"
          label="开课学期"
          width="400"
          sortable>
        </el-table-column>
        <el-table-column
          prop="credits"
          label="每周学时"
          width="400"
          sortable>
        </el-table-column>
        <el-table-column
          fixed="right"
          label="操作"
          width="200">
          <template slot-scope="scope">
            <el-button @click="editFormVisible = true; editParams(scope.row)" type="primary" icon="el-icon-edit">编辑</el-button>
            <el-button @click="deleteForCourse(scope.row)" type="danger" icon="el-icon-delete">删除</el-button>
          </template>
        </el-table-column>
      </el-table>

      <div class="addContainer" style="margin-top: 20px">

        <el-button @click="dialogFormVisible = true;" type="primary" icon="el-icon-plus">添加</el-button>
        
        <el-dialog title="添加课程" :visible.sync="dialogFormVisible">

          <el-form :model="form">

            <el-form-item label="开课院系" :label-width="formLabelWidth">
              <el-select v-model="form.department" placeholder="请选择开课院系">
                <el-option label="工程管理学院" value="工程管理学院"></el-option>
                <el-option label="计算机科学与技术系" value="计算机科学与技术系"></el-option>
                <el-option label="软件学院" value="软件学院"></el-option>
                <el-option label="外国语学院" value="外国语学院"></el-option>
                <el-option label="数学系" value="数学系"></el-option>
              </el-select>
            </el-form-item>

            <el-form-item label="教课院系" :label-width="formLabelWidth">
              <el-select v-model="form.teacherDepartment" placeholder="请选择教授课程的老师所属的院系">
                <el-option label="工程管理学院" value="工程管理学院"></el-option>
                <el-option label="计算机科学与技术系" value="计算机科学与技术系"></el-option>
                <el-option label="软件学院" value="软件学院"></el-option>
                <el-option label="外国语学院" value="外国语学院"></el-option>
                <el-option label="数学系" value="数学系"></el-option>
              </el-select>
            </el-form-item>

            <el-form-item label="课程名称" :label-width="formLabelWidth" >
              <el-input v-model="form.name" placeholder="请输入课程名称" ></el-input>
            </el-form-item>

            <el-form-item label="开课学期" :label-width="formLabelWidth">
              <el-select v-model="form.term" placeholder="请输入开课学期（请输入奇数）">
                <el-option label="1" value="1"></el-option>
                <el-option label="3" value="3"></el-option>
                <el-option label="5" value="5"></el-option>
                <el-option label="7" value="7"></el-option>
              </el-select>
            </el-form-item>

            <el-form-item label="每周学时" :label-width="formLabelWidth">
              <el-select v-model="form.credits" placeholder="请选择每周学时">
                <el-option label="2" value="2"></el-option>
                <el-option label="3" value="3"></el-option>
                <el-option label="4" value="4"></el-option>
                <el-option label="5" value="5"></el-option>
                <el-option label="6" value="6"></el-option>
              </el-select>
            </el-form-item>

            <el-form-item label="奇数学时课程的上课方式" v-if="form.credits%2 == 1">
              <el-select v-model="form.extra" placeholder="请选择上课方式">
                <el-option label="每周 上一次 三小时 连堂课" value="0"></el-option>
                <el-option label="单周 上一次 两小时 连堂课" value="1"></el-option>
                <el-option label="双周 上一次 两小时 连堂课" value="2"></el-option>
              </el-select>

            </el-form-item>

          </el-form>

          <div slot="footer" class="dialog-footer">
            <el-button @click="dialogFormVisible = false">取 消</el-button>
            <el-button type="primary" @click="addForCourse">确 定</el-button>
          </div>

        </el-dialog>

      </div>

      <!-- :before-close里的方法不可以加括号 NB -->
      <el-dialog title="修改课程" :visible.sync="editFormVisible" :before-close="clearForm">

        <el-form :model="form">

          <el-form-item label="开课院系" :label-width="formLabelWidth">
            <el-select v-model="form.department" placeholder="请选择开课院系">
              <el-option label="工程管理学院" value="工程管理学院"></el-option>
              <el-option label="计算机科学与技术系" value="计算机科学与技术系"></el-option>
              <el-option label="软件学院" value="软件学院"></el-option>
              <el-option label="外国语学院" value="外国语学院"></el-option>
              <el-option label="数学系" value="数学系"></el-option>
            </el-select>
          </el-form-item>

          <el-form-item label="教课院系" :label-width="formLabelWidth">
            <el-select v-model="form.teacherDepartment" placeholder="请选择教授课程的老师所属的院系">
              <el-option label="工程管理学院" value="工程管理学院"></el-option>
              <el-option label="计算机科学与技术系" value="计算机科学与技术系"></el-option>
              <el-option label="软件学院" value="软件学院"></el-option>
              <el-option label="外国语学院" value="外国语学院"></el-option>
              <el-option label="数学系" value="数学系"></el-option>
            </el-select>
          </el-form-item>

          <el-form-item label="课程名称" :label-width="formLabelWidth" >
            <el-input v-model="form.name" placeholder="请输入课程名称" ></el-input>
          </el-form-item>

          <el-form-item label="开课学期" :label-width="formLabelWidth">
            <el-select v-model="form.term" placeholder="请输入开课学期（请输入奇数）">
              <el-option label="1" value="1"></el-option>
              <el-option label="3" value="3"></el-option>
              <el-option label="5" value="5"></el-option>
              <el-option label="7" value="7"></el-option>
            </el-select>
          </el-form-item>

          <el-form-item label="每周学时" :label-width="formLabelWidth">
            <el-select v-model="form.credits" placeholder="请选择每周学时">
              <el-option label="2" value="2"></el-option>
              <el-option label="3" value="3"></el-option>
              <el-option label="4" value="4"></el-option>
              <el-option label="5" value="5"></el-option>
              <el-option label="6" value="6"></el-option>
            </el-select>
          </el-form-item>

          <el-form-item label="奇数学时课程的上课方式" v-if="form.credits%2 == 1">
            <el-select v-model="form.extra" placeholder="请选择上课方式">
              <el-option label="每周 上一次 三小时 连堂课" value="0"></el-option>
              <el-option label="单周 上一次 两小时 连堂课" value="1"></el-option>
              <el-option label="双周 上一次 两小时 连堂课" value="2"></el-option>
            </el-select>

          </el-form-item>

        </el-form>

        <div slot="footer" class="dialog-footer">
          <el-button @click="clearForm">取 消</el-button>
          <el-button type="primary" @click="editForCourse">确 定</el-button>
        </div>

      </el-dialog>


    </div>

  </div>
</template>
<script>
import axios from 'axios';

export default {
    name:'course',
    data() {
      return{
        tableData: null,
        dialogFormVisible: false,
        editFormVisible: false,
        form:{
          department: '',
          teacherDepartment: '',
          name: '',
          term: '',
          credits: '',
          extra: '',
        },
        formLabelWidth: '150px',
        editCourseId: 0,
      };
    },
    created() {
      this.fetchData();
    },
    watch: {
    // 如果路由有变化，会再次执行该方法
      '$route': 'fetchData'
    },
    methods: {
      fetchData() {
        axios.get('/course/get')
        .then(res => {
          this.tableData = res.data;
        })
      },
      addForCourse(){
        axios.post('/course/add',{
          department: this.form.department,
          teacherDepartment: this.form.teacherDepartment,
          name: this.form.name,
          term: this.form.term,
          credits: this.form.credits,
          extra: this.form.extra
        }).then(res => {
          this.clearForm();
          this.fetchData();
        })
      },
      editParams(course){
        this.editCourseId = course.id;
        this.form.department = course.department;
        this.form.teacherDepartment = course.teacherDepartment;
        this.form.name = course.name;
        this.form.term = course.term;
        this.form.credits = course.credits;
        this.form.extra = course.extra;
      },
      editForCourse(){
        axios.post('/course/update',{
          id: this.editCourseId,
          department: this.form.department,
          teacherDepartment: this.form.teacherDepartment,
          name: this.form.name,
          term: this.form.term,
          credits: this.form.credits,
          extra: this.form.extra
        }).then(res => {
          this.clearForm();
          this.fetchData();

        })
        
      },
      deleteForCourse(course){
        this.$confirm('此操作将永久删除该课程信息，是否继续？','删除确认',{
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(()=> {
          axios.post('/course/delete',course)
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
        this.editCourseId = 0;
        this.form.department = '';
        this.form.teacherDepartment = '';
        this.form.name = '';
        this.form.term = '';
        this.form.credits = '';
        this.form.extra = '';
        this.editFormVisible = false;
        this.dialogFormVisible = false;
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

