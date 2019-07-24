package com.example.demo.po;


import com.example.demo.vo.CourseVO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by AzureXH on 2019/7/22
 */
@Document(collection = "course")
public class Course {

    @Id
    private String id;

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

    public Course v2p(CourseVO courseVO){
        Course course = new Course();
        course.setId(courseVO.getId());
        course.setDepartment(courseVO.getDepartment());
        course.setTeacherDepartment(courseVO.getTeacherDepartment());
        course.setName(courseVO.getName());
        course.setTerm(courseVO.getTerm());
        course.setCredits(courseVO.getCredits());
        course.setExtra(courseVO.getExtra());
        return course;
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
