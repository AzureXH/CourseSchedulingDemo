package com.example.demo.controller;

import com.example.demo.bl.ClassroomService;
import com.example.demo.po.Classroom;
import com.example.demo.vo.ClassroomVO;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by AzureXH on 2019/7/22
 */
@RestController
public class ClassroomController {
    @Autowired
    ClassroomService classroomService;

    @RequestMapping(value = "/classroom/add", method = RequestMethod.POST)
    public Boolean addClassroom(@RequestBody ClassroomVO classroomVO){
        return classroomService.addClassroom(classroomVO);
    }

    @RequestMapping(value="/classroom/get", method = RequestMethod.GET)
    public List<ClassroomVO> getAllClassroom(){
        return classroomService.getAllClassroom();
    }

    @RequestMapping(value="/classroom/delete", method = RequestMethod.POST)
    public Boolean deleteClassroom(@RequestBody ClassroomVO classroomVO){
        return classroomService.deleteClassroom(classroomVO);
    }

    @RequestMapping(value="/classroom/update", method = RequestMethod.POST)
    public Boolean updateClassroom(@RequestBody ClassroomVO classroomVO){
        return classroomService.updateClassroom(classroomVO);
    }
}
