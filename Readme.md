# 排课系统设计报告

<!-- - 本报告由markdown语法写成，为了获得更好的阅读体验，请点击[github链接](https://github.com/AzureXH/CourseSchedulingDemo) -->

## 目录

<!-- TOC -->

- [排课系统设计报告](#排课系统设计报告)
    - [目录](#目录)
    - [文档修改历史](#文档修改历史)
    - [设计背景](#设计背景)
    - [技术栈](#技术栈)
    - [主要](#主要)
        - [前端](#前端)
        - [后端](#后端)
    - [技术栈介绍](#技术栈介绍)
        - [vue](#vue)
        - [vue-router](#vue-router)
        - [element-ui](#element-ui)
        - [axios](#axios)
        - [Springboot](#springboot)
        - [MongoDB](#mongodb)
    - [使用这套技术栈的原因](#使用这套技术栈的原因)
    - [开发工具](#开发工具)
    - [开发流程](#开发流程)
        - [模块设计](#模块设计)
        - [体系结构设计](#体系结构设计)
        - [功能设计](#功能设计)
            - [Course模块](#course模块)
            - [Classroom模块](#classroom模块)
            - [Teacher模块](#teacher模块)

<!-- /TOC -->

## 文档修改历史

| 修改日期  |               修改原因               | 版本号 |
| :-------: | :----------------------------------: | :----: |
| 2019.7.24 | 完成报告的初版，达到与代码设计的同步 |  v1.0  |

## 设计背景

1. 自学web项目开发所做的一个项目
2. 管理信息系统作业

<!-- ## 必要说明

- 首先这只是一个用于学习的项目
  - 其次由于我的css基础比较差，而且为了赶时间
    - 所以这个项目只实现基本的功能，不考虑界面是否好看
- 因为非关系型数据库的数据结构可以嵌套
  - 而且数据量不大
    - 所以我并不打算对数据库进行优化，只求功能实现
- 这个报告注重的是实现而不是设计，毕竟设计一个系统从来就不是一个人的事，但是不会写代码就连设计的资格都没有 -->

## 技术栈

## 主要

- vue + Springboot + MongoDB

### 前端

- vue
- vue-router
- element-ui
- axios

### 后端

- Springboot
- MongoDB

## 技术栈介绍

### vue

- 一种网页的开发框架
- 使用组件化开发的理念，将每个页面当做组件，每个页面中还可以放入小的组件，这样可以减少重复代码

### vue-router

- 网页开发的路由管理器，具体就是将**每个组件**与**用户浏览网页时的地址**进行映射
- 通过vue-router可以实现嵌套路由，在一个主路由下，增加子路由，实现上文所说的减少重复代码

### element-ui

- 由饿了么开发团队所开发的一套基于vue的网页组件库
- 作为一个初学者，直接使用这样的组件库可以减少很多开发时间

### axios

- 一种基于promise(不懂)的HTTP库，用于客户端(即浏览器)向服务器发送请求，并得到服务器响应后对页面进行处理

### Springboot

- 一个后端的开发框架，将服务器处理请求的逻辑封装
- 只需要在该框架中定义控制器，将客户端发出的请求中的地址(即url)写在控制器的映射中，就可以找到相对应的方法。

### MongoDB

- 一种NoSql数据库
- NoSql的意思是(Not Only Sql)
- 它是一种非关系型的数据库，存储数据的方式是文档类型的
- 例如

``` json
{
    "username": "teacher",
    "password": "teacher123",
    "address":{
        "province": "广东省",
        "city": "珠海市"
    }
}
```

- 可以看到，这种类型的数据库不像关系型数据库只有固定的变量
- NoSQL的变量是可以嵌套的
- 相对应的

    |        SQL         |      NoSQL       |
    | :----------------: | :--------------: |
    |   数据表(Table)    | 集合(Collection) |
    | 记录(表中的某一行) |  文档(Document)  |
    | 字段(表中的某一列) |    域(Field)     |
- 相比关系型数据库，NoSQL这类数据库存储数据更加的灵活
  - 关系型数据库的结构是定死的
  - 但是非关系型数据库没有那么多的规定，NoSQL中的每一个记录都可以不一样
  - 例如

  ```json
  {
    "name": "Foo"
  },
  {
    "name": "Bar",
    "age": 15
  }
  ```

  - 可以看到两个记录有着不一样的数据格式，这样便增加了更多的灵活性。

## 使用这套技术栈的原因

1. 这学期软工大作业的前端用的是bootstrap+jquery，可能是自己弱，感觉十分的麻烦，所以打算学习一套比较新的前端框架
2. Springboot作为后端框架比较好用，而且这个学期一直在用
3. 一直学关系型数据库感觉比较脱离实际，所以想要学一下非关系型数据库，于是就从MongoDB入手了

## 开发工具

- VSCode
  - VSCode作为一个编辑器，有着丰富的插件，内置终端(也就是控制台)，用于开发前端非常的方便
- IntelliJ IDEA
  - 一个JAVA的IDE

## 开发流程

### 模块设计

- 本项目的排课系统的主要模块主要分为四个
  - 课程大纲
  - 教师安排
  - 教室管理
  - 排课管理

- 每个模块对应一个数据表，也就是文档
  - course文档
  - teacher文档
  - classroom文档
  - scheduling文档
- 其中在初期开发中为了测试前后端接口以及数据库接口，增加了一个登录的小模块并且设置了一个user文档，但这个模块主要是为了测试接口，所以不是很重要。

### 体系结构设计

- 有了模块之后开始搭建项目的体系结构
- 整个项目用的是分层的架构
  - 分层架构优点：
    - 在于只需要确定层与层之间的接口
    - 各个层之间的代码互不干扰
    - 负责某一层的程序员只需要写好自己那一层的代码就可以自行开发
    - 如果出现其它层代码写的过慢的情况，由于接口和传输的数据格式都是定死的，只需要自己写假代码就可以确认自己的代码是否有bug，也就是Mocker
- 客户端发出请求由最上层开始调用至最底层
- 服务器响应请求由最底层返回给最上层
- 前端
  - vue框架下的**展示层**界面
  - axios库发送请求给后端控制器层(Controller)
  - axios发送请求时所带的请求体称为VO(View Object)
    - VO即为展示层的对象
- 后端
  - **控制器层**(Controller)
  - **业务逻辑层**(BusinessLogic)
    - 业务逻辑层接口(Service)
    - 业务逻辑的具体实现(ServiceImpl)
  - **数据层**(Data)
  - 业务逻辑层和数据层之间传输的数据为PO(Persistent Object)
    - PO称为持久化对象，存储于数据层中，对应的就是数据库中的表格
- 体系结构图如图所示

![体系结构](https://github.com/AzureXH/CourseSchedulingDemo/blob/master/%E4%BD%93%E7%B3%BB%E7%BB%93%E6%9E%84%E5%9B%BE.jpg?raw=true)

### 功能设计

- 整个项目的体系结构搭建好后，就可以开始设计具体功能了。
- 由于分好了四个模块，我们只需要在各自的模块中设计功能。
- 为了节省时间这里的功能设计我只写了每个模块的业务逻辑层的Service接口

#### Course模块

|   功能   |                 函数名称                 |                 网页请求说明                 | 数据库相关说明                       |
| :------: | :--------------------------------------: | :------------------------------------------: | ------------------------------------ |
| 增加课程 |  Boolean addCourse(CourseVO courseVO);   |             网页请求添加新的课程             | 在course集合中添加一个新的Course文档 |
| 删除课程 | Boolean deleteCourse(CourseVO courseVO); |             网页请求删除某个课程             | 将course集合中对应的Course文档删除   |
| 修改课程 | Boolean updateCourse(CourseVO courseVO); |             网页请求修改某个课程             | 将course集合中对应的Course文档修改   |
| 获取课程 |      List<CourseVO> getAllCourse();      | 网页请求获取数据库中的所有课程，用于填充表格 | 返回course集合中全部的Course文档     |

#### Classroom模块

|   功能   |                     函数名称                      |                 网页请求说明                 | 数据库相关说明                             |
| :------: | :-----------------------------------------------: | :------------------------------------------: | ------------------------------------------ |
| 增加教室 |  Boolean addClassroom(ClassroomVO classroomVO);   |             网页请求添加新的教室             | 在classroom集合中添加一个新的Classroom文档 |
| 删除教室 | Boolean deleteClassroom(ClassroomVO classroomVO); |             网页请求删除某个教室             | 将classroom集合中对应的Classroom文档删除   |
| 修改教室 | Boolean updateClassroom(ClassroomVO classroomVO); |             网页请求修改某个教室             | 将classroom集合中对应的Classroom文档修改   |
| 获取教室 |       List<ClassroomVO> getAllClassroom();        | 网页请求获取数据库中的所有教室，用于填充表格 | 返回classroom集合中全部的Classroom文档     |

#### Teacher模块

|   功能   |                  函数名称                   |                 网页请求说明                 | 数据库相关说明                         |
| :------: | :-----------------------------------------: | :------------------------------------------: | -------------------------------------- |
| 增加教师 |  Boolean addTeacher(TeacherVO teacherVO);   |             网页请求添加新的教师             | 在teacher集合中添加一个新的Teacher文档 |
| 删除教师 | Boolean deleteTeacher(TeacherVO teacherVO); |             网页请求删除某个教师             | 将teacher集合中对应的Teacher文档删除   |
| 修改教师 | Boolean updateTeacher(TeacherVO teacherVO); |             网页请求修改某个教师             | 将teacher集合中对应的Teacher文档修改   |
| 获取教师 |      List<TeacherVO> getAllTeacher();       | 网页请求获取数据库中的所有教师，用于填充表格 | 返回teacher集合中全部的Teacher文档     |
