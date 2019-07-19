import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home.vue'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'login',
      component: () =>import('./views/Login.vue')
    },
    {
      path: '/home',
      name: 'home',
      component: Home,
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
        },
        {
          path: '/home/classroom',
          name: 'classroom',
          component: () => import('./views/content/Classroom.vue')
        },
        {
          path: '/home/scheduling',
          name: 'scheduling',
          component: () => import('./views/content/Scheduling.vue')
        }
      ]
    },
    {
      path: '/about',
      name: 'about',
      component: () => import('./views/About.vue')
    },

  ]
})
