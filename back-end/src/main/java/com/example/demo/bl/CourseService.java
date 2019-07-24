package com.example.demo.bl;

import com.example.demo.vo.CourseVO;

import java.util.List;

/**
 * Created by AzureXH on 2019/7/22
 */
public interface CourseService {

    List<CourseVO> getAllCourse();

    Boolean addCourse(CourseVO courseVO);

    Boolean deleteCourse(CourseVO courseVO);

    Boolean updateCourse(CourseVO courseVO);
}
