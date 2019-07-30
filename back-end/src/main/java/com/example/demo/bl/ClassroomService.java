package com.example.demo.bl;

import com.example.demo.po.Classroom;
import com.example.demo.vo.ClassroomVO;

import java.util.List;

/**
 * Created by AzureXH on 2019/7/22
 */
public interface ClassroomService {

    Boolean addClassroom(ClassroomVO classroomVO);

    List<ClassroomVO> getAllClassroom();

    List<ClassroomVO> getFreeClassroom(String teachingPattern);

    Boolean deleteClassroom(ClassroomVO classroomVO);

    Boolean updateClassroom(ClassroomVO classroomVO);
}
