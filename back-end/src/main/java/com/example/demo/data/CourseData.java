package com.example.demo.data;

import com.example.demo.po.Course;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by AzureXH on 2019/7/22
 */
public interface CourseData extends MongoRepository<Course,String> {

    List<Course> findCoursesByTeacherDepartmentLike(String teacherDepartment);
}
