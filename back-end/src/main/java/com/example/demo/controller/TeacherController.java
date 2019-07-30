package com.example.demo.controller;

import com.example.demo.bl.TeacherService;
import com.example.demo.vo.TeacherVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.awt.image.PixelConverter;

import java.util.List;

/**
 * Created by AzureXH on 2019/7/22
 */
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public List<TeacherVO> getAllTeacher(){
        return teacherService.getAllTeacher();
    }

    @RequestMapping(value = "/get/free/{teaching}/{department}", method = RequestMethod.GET)
    public List<TeacherVO> getFreeeacher(@PathVariable("teaching") String teaching, @PathVariable("department") String department){
        return teacherService.getFreeTeacher(teaching, department);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Boolean addTeacher(@RequestBody TeacherVO teacherVO){
        return teacherService.addTeacher(teacherVO);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Boolean deleteTeacher(@RequestBody TeacherVO teacherVO){
        return teacherService.deleteTeacher(teacherVO);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Boolean updateTeacher(@RequestBody TeacherVO teacherVO){
        return teacherService.updateTeacher(teacherVO);
    }

}
