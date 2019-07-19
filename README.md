# CourseSchedulingDemo

## 2019.7.14

- README还没想好要写什么
- 登录界面 https://www.youtube.com/watch?v=mUdo6w87rh4&t=1289s

- 之后弄一下菜单的路由吧

## 2019.7.19

### 菜单的路由跳转的实现

#### 第一步：el-menu标签中设置router属性

``` js
<el-menu default-active="1" router="true"></el-menu>
```

#### 第二步：el-menu-item标签中设置index或:route属性

``` js
<el-menu-item index="/home/course">
</el-menu-item>
```

或

``` js
<el-menu-item index="1" :route="{path:'/home/course'}">
</el-menu-item>
```

但是为了让index作为索引，语义化一点选择了第二种。

#### 第三步：在要显示的位置写上router-view标签

```js
<el-main>
    <keep-alive>
      <router-view></router-view>
    </keep-alive>
</el-main>
```

- keep-alive的作用不清楚，最好看下vue-router的文档
- <https://router.vuejs.org/zh/api/#exact-active-class>

#### 第四步：在router.js中的主页面路由中设置children属性

- 关键的一步
- children属性会渲染到主页面的router-view中去，也就是嵌套路由
- <https://router.vuejs.org/zh/guide/essentials/nested-routes.html>

``` js
{
  // 主页面
  path: '/home',
  name: 'home',
  component: Home,
  
  //你要跳转的页面写在children中
  children: [
    {
      path: '/home/course',
      name: 'course',
      component: () => import('./views/content/Course.vue')
    },
    {
      path: '/home/teacher',
      name: 'teacher',
      component: () => import('./views/content/Teacher.vue')  
    }
  ]
}
```