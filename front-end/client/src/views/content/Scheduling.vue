<template>
   <div>

      <div v-if="tableData" class="table-container">
          <el-table
            :data="tableData"
            style="width: 100%">

            <el-table-column
              prop="department"
              label="开课院系"
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
      </div>
      <!-- 手动排课 -->
      <el-button type="primary" @click="addFormVisible = true" icon="el-icon-plus">手动排课</el-button>


      <!-- 自动排课 -->
      <el-button type="primary" @click="autoFormVisible = true" icon="el-icon-s-tools">自动排课</el-button>

      <el-dialog
        title="手动排课"
        :visible.sync="addFormVisible"
        width="30%"
        >
        
        <el-form :model="form" ref="form" label-width="80px">
          <el-form-item label="上课日期">
            <el-select v-model="form.teachDay" placeholder="请选择上课日期">
              <el-option label="周一" value="周一"></el-option>
              <el-option label="周二" value="周二"></el-option>
              <el-option label="周三" value="周三"></el-option>
              <el-option label="周四" value="周四"></el-option>
              <el-option label="周五" value="周五"></el-option>
            </el-select>
          </el-form-item>
          
          <el-form-item label="上课时段">
            <el-select v-model="form.teachPeriod" placeholder="请选择上课时段" @change="clearTime">
              <el-option label="上午" value="上午"></el-option>
              <el-option label="下午" value="下午"></el-option>
              <el-option label="晚上" value="晚上"></el-option>
            </el-select>
          </el-form-item>

          <el-form-item label="上课时间">
            <el-select v-model="form.teachTime" placeholder="请选择上课时间" @change="getFreeClassroom">
              <el-option v-if="form.teachPeriod=='上午'" label="8:00-9:50" value="0011"></el-option>
              <el-option v-if="form.teachPeriod=='上午'" label="9:00-12:00" value="1000"></el-option>
              <el-option v-if="form.teachPeriod=='上午'" label="10:10-12:00" value="1100"></el-option>
              <el-option v-if="form.teachPeriod=='下午'" label="14:00-15:50" value="0011"></el-option>
              <el-option v-if="form.teachPeriod=='下午'" label="14:00-16:50" value="1000"></el-option> 
              <el-option v-if="form.teachPeriod=='下午'" label="16:00-18:00" value="1100"></el-option>             
              <el-option v-if="form.teachPeriod=='晚上'" label="18:30-20:20" value="001"></el-option>
              <el-option v-if="form.teachPeriod=='晚上'" label="18:30-21:20" value="000"></el-option>    
            </el-select>
          </el-form-item>

          <el-form-item label="空闲教室">
            <el-select v-model="selectedCalssroom" placeholder="请选择空闲教室">
              <el-option v-for="item in freeClassroom"
                :key="item.id"
                :label="item.building+item.room"
                :value="item">
              </el-option>
            </el-select>
          </el-form-item>
          
          <el-form-item label="授课院系" >
            <el-select 
            v-model="teachingDepartment" 
            placeholder="请选择教授课程的老师所属的院系" 
            @change="getFreeTeacher">
              <el-option label="工程管理学院" value="工程管理学院"></el-option>
              <el-option label="计算机科学与技术系" value="计算机科学与技术系"></el-option>
              <el-option label="软件学院" value="软件学院"></el-option>
              <el-option label="外国语学院" value="外国语学院"></el-option>
              <el-option label="数学系" value="数学系"></el-option>
            </el-select>
          </el-form-item>

          <el-form-item label="授课教师">
            <el-select v-model="selectedTeacher" placeholder="请选择授课教师" >
              <el-option v-for="teacher in freeTeacher"
                :key="teacher.id"
                :label="teacher.name"
                :value="teacher">
              </el-option>
            </el-select>
          </el-form-item>
          
          <el-form-item label="教授课程">
            <el-select v-model="selectedCourse" placeholder="请选择教授课程">
              <el-option v-for="course in freeCourse"
                :key="course.id"
                :label="course.name"
                :value="course">
              </el-option>
            </el-select>
            
            
          </el-form-item>
        </el-form>
          

        <span slot="footer">
          <el-button @click=" addFormVisible = false">取 消</el-button>
          <el-button type="primary" @click=" addFormVisible = true">确 定</el-button>
        </span>
      </el-dialog>

      <el-dialog
        title="自动排课"
        :visible.sync="autoFormVisible"
        width="30%"
        >
        
        <el-form :model="form" ref="form" label-width="80px">
          <el-form-item label="每日教室空余百分比">
            
          </el-form-item>
        </el-form>
        
        

        <span slot="footer">
          <el-button @click=" autoFormVisible = false">取 消</el-button>
          <el-button type="primary" @click="">确 定</el-button>
        </span>
      </el-dialog>
      

      
    </div> 
</template>
<script>
import axios from 'axios'

export default {
    name:'scheduling',
    data(){
      return {
        tableData:null,
        addFormVisible: false,
        autoFormVisible: false,
        form:{
          department: '',
          teachDay: '',
          teachPeriod: '',
          teachTime: '',
        },
        freeClassroom: null,
        selectedCalssroom: null,

        teachingDepartment: '',
        
        freeTeacher: null,
        selectedTeacher: null,
        teaching: null,

        freeCourse: null,
        selectedCourse: null,
      }
    },
    created() {
      this.fetchData();
    },
    watch: {
    // 如果路由有变化，会再次执行该方法
      '$route': 'fetchData'
    },
    methods: {
      fetchData(){
        axios.get('/course/get')
        .then(res => {
          this.tableData = res.data
        })
        .catch(err => {
          console.error(err); 
        })
      },
      clearTime(){
        this.form.teachTime = "";
      },
      getFreeClassroom(){
        this.selectedCalssroom = null;
        this.freeClassroom = null;
        this.freeTeacher = null;
        this.selectedTeacher = null;
        this.teachingDepartment = '';
        this.teaching = this.form.teachDay+this.form.teachPeriod+this.form.teachTime;
        axios.get(`/classroom/get/free/${this.teaching}`
        )
        .then(res => {
          this.freeClassroom = res.data;
        })
        .catch(err => {
          console.error(err); 
        })
      },
      getFreeTeacher(){
        this.selectedTeacher = null;
        axios.get(`/teacher/get/free/${this.teaching}/${this.teachingDepartment}`
        )
        .then(res => {
          this.freeTeacher = res.data;
        })
        .catch(err => {
          console.error(err); 
        });
        this.getFreeCourse();
        
      },
      getFreeCourse(){
        axios.get(`/course/get/free/${this.teaching}/${this.teachingDepartment}`)
        .then(res => {
          this.freeCourse = res.data;
        })
        .catch(err => {
          console.error(err); 
        })
      }
    },
    
}
</script>

