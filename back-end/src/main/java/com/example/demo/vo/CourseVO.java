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

    /**
     * 奇数学时是否要单双周上课 0：将有一次课上三个课时 1：单周上一次两个课时 2：双周上一次三个课时
     */
    private Integer extra;

    public CourseVO p2v(Course course){
        CourseVO courseVO = new CourseVO();
        courseVO.setId(course.getId());
        courseVO.setDepartment(course.getDepartment());
        courseVO.setTeacherDepartment(course.getTeacherDepartment());
        courseVO.setName(course.getName());
        courseVO.setTerm(course.getTerm());
        courseVO.setCredits(course.getCredits());
        courseVO.setExtra(course.getExtra());
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

    public Integer getExtra() {
        return extra;
    }

    public void setExtra(Integer extra) {
        this.extra = extra;
    }
}
