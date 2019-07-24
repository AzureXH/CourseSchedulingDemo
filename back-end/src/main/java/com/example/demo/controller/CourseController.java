package com.example.demo.controller;

import com.example.demo.bl.CourseService;
import com.example.demo.po.Course;
import com.example.demo.vo.CourseVO;
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
public class CourseController {

    @Autowired
    CourseService courseService;

    @RequestMapping(value = "/course/get", method = RequestMethod.GET)
    public List<CourseVO> getAllCourse(){
        return courseService.getAllCourse();
    }

    @RequestMapping(value = "/course/add", method = RequestMethod.POST)
    public Boolean addCourse(@RequestBody CourseVO courseVO){
        return courseService.addCourse(courseVO);
    }

    @RequestMapping(value = "/course/delete", method = RequestMethod.POST)
    public Boolean deleteCourse(@RequestBody CourseVO courseVO){
        return courseService.deleteCourse(courseVO);
    }

    @RequestMapping(value = "/course/update", method = RequestMethod.POST)
    public Boolean updateCourse(@RequestBody CourseVO courseVO){
        return courseService.updateCourse(courseVO);
    }

}
