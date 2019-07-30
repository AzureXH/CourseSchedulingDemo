package com.example.demo.controller;

import com.example.demo.bl.ClassroomService;
import com.example.demo.po.Classroom;
import com.example.demo.vo.ClassroomVO;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by AzureXH on 2019/7/22
 */
@RestController
@RequestMapping(value="/classroom")
public class ClassroomController {
    @Autowired
    ClassroomService classroomService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Boolean addClassroom(@RequestBody ClassroomVO classroomVO){
        return classroomService.addClassroom(classroomVO);
    }

    @RequestMapping(value="/get/all", method = RequestMethod.GET)
    public List<ClassroomVO> getAllClassroom(){
        return classroomService.getAllClassroom();
    }

    @RequestMapping(value="/get/free/{teaching}", method = RequestMethod.GET)
    public List<ClassroomVO> getFreeClassroom(@PathVariable("teaching") String teaching){
        return classroomService.getFreeClassroom(teaching);
    }


    @RequestMapping(value="/delete", method = RequestMethod.POST)
    public Boolean deleteClassroom(@RequestBody ClassroomVO classroomVO){
        return classroomService.deleteClassroom(classroomVO);
    }

    @RequestMapping(value="/update", method = RequestMethod.POST)
    public Boolean updateClassroom(@RequestBody ClassroomVO classroomVO){
        return classroomService.updateClassroom(classroomVO);
    }
}
