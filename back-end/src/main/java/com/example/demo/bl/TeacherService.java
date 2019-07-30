package com.example.demo.bl;

import com.example.demo.po.Teacher;
import com.example.demo.vo.TeacherVO;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;

/**
 * Created by AzureXH on 2019/7/22
 */
public interface TeacherService {

    List<TeacherVO> getAllTeacher();

    List<TeacherVO> getFreeTeacher(String teachingPattern, String department);

    Boolean addTeacher(TeacherVO teacherVO);

    Boolean deleteTeacher(TeacherVO teacherVO);

    Boolean updateTeacher(TeacherVO teacherVO);
}
