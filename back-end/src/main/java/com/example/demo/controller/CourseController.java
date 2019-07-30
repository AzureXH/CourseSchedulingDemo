package com.example.demo.controller;

import com.example.demo.bl.CourseService;
import com.example.demo.po.Course;
import com.example.demo.vo.CourseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by AzureXH on 2019/7/22
 */
@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    CourseService courseService;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public List<CourseVO> getAllCourse(){
        return courseService.getAllCourse();
    }

    @RequestMapping(value = "/get/free/{teaching}/{department}", method = RequestMethod.GET)
    public List<CourseVO> getFreeCourse(@PathVariable("teaching") String teaching, @PathVariable("department") String department){
        return courseService.getFreeCourse(teaching,department);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Boolean addCourse(@RequestBody CourseVO courseVO){
        return courseService.addCourse(courseVO);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Boolean deleteCourse(@RequestBody CourseVO courseVO){
        return courseService.deleteCourse(courseVO);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Boolean updateCourse(@RequestBody CourseVO courseVO){
        return courseService.updateCourse(courseVO);
    }

}
