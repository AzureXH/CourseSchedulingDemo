package com.example.demo.blImpl;

import com.example.demo.bl.CourseService;
import com.example.demo.data.CourseData;
import com.example.demo.po.Course;
import com.example.demo.vo.CourseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AzureXH on 2019/7/22
 */
@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    CourseData courseData;

    @Override
    public List<CourseVO> getAllCourse() {
        List<CourseVO> courseVOList = new ArrayList<CourseVO>();
        List<Course> courseList = courseData.findAll();
        for (Course course:courseList
             ) {
            courseVOList.add(new CourseVO().p2v(course));
        }
        return courseVOList;
    }

    @Override
    public Boolean addCourse(CourseVO courseVO) {
        courseData.insert(new Course().v2p(courseVO));
        return true;
    }

    @Override
    public Boolean deleteCourse(CourseVO courseVO) {
        courseData.deleteById(courseVO.getId());
        return true;
    }

    @Override
    public Boolean updateCourse(CourseVO courseVO) {
        Course course = new Course().v2p(courseVO);
        courseData.save(course);
        return true;
    }
}
