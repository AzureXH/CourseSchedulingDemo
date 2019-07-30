package com.example.demo.vo;

import com.example.demo.po.Course;
import org.springframework.data.annotation.Id;

/**
 * Created by AzureXH on 2019/7/22
 */
public class CourseVO {
    @Id
    private String Id;

    private String department;
    private String teacherDepartment;
    private String name;
    /**
     * 开课的学期
     */
    private Integer term;

    /**
     * 每周学时
     */
    private Integer credits;

    private String teaching;


    public CourseVO p2v(Course course){
        CourseVO courseVO = new CourseVO();
        courseVO.setId(course.getId());
        courseVO.setDepartment(course.getDepartment());
        courseVO.setTeacherDepartment(course.getTeacherDepartment());
        courseVO.setName(course.getName());
        courseVO.setTerm(course.getTerm());
        courseVO.setCredits(course.getCredits());
        courseVO.setTeaching(course.getTeaching());
        return courseVO;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTeacherDepartment() {
        return teacherDepartment;
    }

    public void setTeacherDepartment(String teacherDepartment) {
        this.teacherDepartment = teacherDepartment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public String getTeaching() {
        return teaching;
    }

    public void setTeaching(String teaching) {
        this.teaching = teaching;
    }
}
