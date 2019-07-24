package com.example.demo.po;

import com.example.demo.vo.TeacherVO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by AzureXH on 2019/7/22
 */
@Document(collection = "teacher")
public class Teacher {
    @Id
    private String id;
    private String department;
    private String name;
    private String title;

    public Teacher v2p(TeacherVO teacherVO){
        Teacher teacher = new Teacher();
        teacher.setId(teacherVO.getId());
        teacher.setDepartment(teacherVO.getDepartment());
        teacher.setName(teacherVO.getName());
        teacher.setTitle(teacherVO.getTitle());
        return teacher;
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
