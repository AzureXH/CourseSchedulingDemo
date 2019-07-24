package com.example.demo.vo;

import com.example.demo.po.Teacher;

/**
 * Created by AzureXH on 2019/7/22
 */
public class TeacherVO {
    private String id;
    private String department;
    private String name;
    private String title;

    public TeacherVO p2v(Teacher teacher){
        TeacherVO teacherVO = new TeacherVO();
        teacherVO.setId(teacher.getId());
        teacherVO.setDepartment(teacher.getDepartment());
        teacherVO.setName(teacher.getName());
        teacherVO.setTitle(teacher.getTitle());
        return teacherVO;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
