<template>
  <div class="main-container">
    <div v-if="tableData" class="table-container">
      <el-table
        :data="tableData"
        style="width: 100%"
        :default-sort = "{prop: 'building', order: 'descending'}">

        <el-table-column type="expand">
          <template slot-scope="props">
            <el-form label-position="left" class="demo-table-expand">
              <el-form-item>
                <label>教学楼名 </label>
                <span>{{ props.row.building }}</span>
              </el-form-item>
              <el-form-item>
                <label>上课时间 </label>
                <span>{{ props.row.building }}</span>
              </el-form-item>
            </el-form>
          </template>
        </el-table-column>

        <el-table-column
          prop="building"
          label="教学楼名"
          width="400"
          sortable>
        </el-table-column>
        <el-table-column
          prop="room"
          label="教室号"
          width="400">
        </el-table-column>
        <el-table-column
          prop="available"
          label="可容纳人数"
          width="400"
          sortable>
        </el-table-column>
        <el-table-column
          prop="size_level"
          label="教室大小等级"
          width="400">
        </el-table-column>
        <el-table-column
          fixed="right"
          label="操作"
          width="200">
          <template slot-scope="scope">
            <el-button @click="editFormVisible = true; editParams(scope.row)" type="primary" icon="el-icon-edit">编辑</el-button>
            <el-button @click="deleteForClassroom(scope.row)" type="danger" icon="el-icon-delete">删除</el-button>
          </template>
        </el-table-column>
      </el-table>


      <el-button @click="dialogFormVisible = true" type="primary" icon="el-icon-plus">添加</el-button>

      <el-dialog title="添加教室" :visible.sync="dialogFormVisible" width="30%">

        <el-form :model="form">

          <el-form-item label="教学楼名" :label-width="formLabelWidth">
            <el-select v-model="form.building" placeholder="请选择教学楼名">
              <el-option label="仙一" value="仙一"></el-option>
              <el-option label="仙二" value="仙二"></el-option>
              <el-option label="逸夫楼" value="逸夫楼"></el-option>
            </el-select>
          </el-form-item>

          <el-form-item label="教室名" :label-width="formLabelWidth">
            <el-input v-model="form.room" placeholder="请输入教室名称"></el-input>
          </el-form-item>

          <el-form-item label="可容纳人数" :label-width="formLabelWidth">
            <el-input v-model="form.available" placeholder="请输入教室的可容纳人数"></el-input>
          </el-form-item>

          <el-form-item label="教室大小等级" :label-width="formLabelWidth">
            <el-input v-model="form.size_level" :disabled="true">{{ size }}</el-input>
          </el-form-item>

        </el-form>

        <div slot="footer" class="dialog-footer">
          <el-button @click="dialogFormVisible = false">取 消</el-button>
          <el-button type="primary" @click="addForClassroom">确 定</el-button>
        </div>

      </el-dialog>

      <el-dialog title="修改教室" :visible.sync="editFormVisible" width="30%" :before-close="clearForm">

        <el-form :model="form">

          <el-form-item label="教学楼名" :label-width="formLabelWidth">
            <el-select v-model="form.building" placeholder="请选择教学楼名">
              <el-option label="仙一" value="仙一"></el-option>
              <el-option label="仙二" value="仙二"></el-option>
              <el-option label="逸夫楼" value="逸夫楼"></el-option>
            </el-select>
          </el-form-item>

          <el-form-item label="教室名" :label-width="formLabelWidth">
            <el-input v-model="form.room" placeholder="请输入教室名称"></el-input>
          </el-form-item>

          <el-form-item label="可容纳人数" :label-width="formLabelWidth">
            <el-input v-model="form.available" placeholder="请输入教室的可容纳人数"></el-input>
          </el-form-item>

          <el-form-item label="教室大小等级" :label-width="formLabelWidth">
            <el-input v-model="form.size_level" :disabled="true">{{ size }}</el-input>
          </el-form-item>

        </el-form>

        <div slot="footer" class="dialog-footer">
          <el-button @click="clearForm()">取 消</el-button>
          <el-button type="primary" @click="editForClassroom()">确 定</el-button>
        </div>

      </el-dialog>


    </div>

  </div>
</template>
<script>
import axios from 'axios';

export default {
    name:'classroom',
    data() {
      return{
        tableData: null,
        dialogFormVisible: false,
        editFormVisible: false,
        form:{
          building: '',
          room: '',
          available: '',
          size_level:0
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
    computed: {
      size: function(){
        var availableList = [0,30,60,90,120,150];
        if(this.form.available > availableList[availableList.length-1]){
          this.form.size_level = availableList.length-1;
          this.form.available = availableList[availableList.length-1];
          return this.form.size_level;
        }
        for(let i = 1; i < availableList.length; i++){
          if(availableList[i-1] <= this.form.available && this.form.available < availableList[i]){
            this.form.size_level = i;
            return this.form.size_level;
          }
        }

      }
    },
    methods: {
      fetchData() {
        axios.get('/classroom/get/all')
        .then(res => {
          this.tableData = res.data;
        })
      },
      clearForm(){
        this.form.building = '';
        this.form.room = '';
        this.form.available = '';
        this.form.size_level = 1;
        this.editFormVisible = false;
        this.dialogFormVisible = false;
      },
      addForClassroom(){
        axios.post('/classroom/add',{
          building: this.form.building,
          room: this.form.room,
          available: this.form.available,
          size_level: this.form.size_level
        }).then(res => {
          this.clearForm();

          this.fetchData();
        })
      },
      editParams(classroom){
        this.editFormVisible = true;
        this.form.building = classroom.building;
        this.form.room = classroom.room;
        this.form.available = classroom.available;
        this.form.size_level = classroom.size_level;
        this.editCourseId = classroom.id;
      },
      editForClassroom(){
        axios.post('/classroom/update',{
          id: this.editCourseId,
          building: this.form.building,
          room: this.form.room,
          available: this.form.available,
          size_level: this.form.size_level
        }).then(res => {
          this.clearForm();
          this.editCourseId = 0;

          this.fetchData();
        })
      },
      deleteForClassroom(classroom){
        this.$confirm('此操作将永久删除该教室信息，是否继续？','删除确认',{
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(()=> {
          
          axios.post('/classroom/delete',classroom)
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

