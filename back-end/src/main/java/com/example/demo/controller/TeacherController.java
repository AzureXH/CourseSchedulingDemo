package com.example.demo.controller;

import com.example.demo.bl.TeacherService;
import com.example.demo.vo.TeacherVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.awt.image.PixelConverter;

import java.util.List;

/**
 * Created by AzureXH on 2019/7/22
 */
@RestController
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @RequestMapping(value = "/teacher/get", method = RequestMethod.GET)
    public List<TeacherVO> getAllTeacher(){
        return teacherService.getAllTeacher();
    }

    @RequestMapping(value = "/teacher/add", method = RequestMethod.POST)
    public Boolean addTeacher(@RequestBody TeacherVO teacherVO){
        return teacherService.addTeacher(teacherVO);
    }

    @RequestMapping(value = "/teacher/delete", method = RequestMethod.POST)
    public Boolean deleteTeacher(@RequestBody TeacherVO teacherVO){
        return teacherService.deleteTeacher(teacherVO);
    }

    @RequestMapping(value = "/teacher/update", method = RequestMethod.POST)
    public Boolean updateTeacher(@RequestBody TeacherVO teacherVO){
        return teacherService.updateTeacher(teacherVO);
    }

}
