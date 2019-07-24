<template>
    <div id="login-box">
        <img src="../assets/logo.png">
        <el-form ref="form" :model="form" label-width="80px">

                    <el-form-item label="用户名">
                        <el-input v-model="form.username" placeholder="请输入用户名"></el-input>
                    </el-form-item>

                    <el-form-item label="密码">
                        <el-input v-model="form.password" placeholder="请输入密码" show-password></el-input>
                    </el-form-item>

            <el-form-item>
                <el-button type="primary" @click="onSubmit">登录</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
import axios from 'axios'

export default {
    name:'login',
    data(){
        return{
            form:{
                username: 'teacher',
                password: 'teacher123'
            }
        }
    },
    methods:{
        onSubmit(){
            axios.post('/login',{
                username:this.form.username,
                password:this.form.password
            })
            .then(res => {
                if(res.data == true){
                    this.$router.push({path:'/home/course'});
                }else{
                    this.$message('用户名或密码错误');
                }
            }).catch(reject => {
                //暂时没有reject 因为后端没有设置返回体
            })
        }
    }
}
</script>

<style scoped>
#login-box{
    position: absolute;
    top:50%;
    left: 50%;
    transform: translate(-50%,-50%);
    margin: 0;
    padding: 20px;
    border: 10px;
    box-shadow: 0 14px 28px rgba(0, 0, 0, 0.25),0 10px 10px rgba(0, 0, 0, 0.22);
    border-radius: 5px;
    background: #ffffff;
    min-width: 315px;
}
img{
    margin: 25px 0 25px 0;
    height: 150px;
}
.el-form-item{
    color: aqua;
}
.el-button{
    font-size: 12px;
    font-weight: bold;
}
</style>
