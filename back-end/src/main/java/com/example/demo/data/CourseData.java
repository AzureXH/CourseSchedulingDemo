package com.example.demo.data;

import com.example.demo.po.Course;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by AzureXH on 2019/7/22
 */
public interface CourseData extends MongoRepository<Course,String> {
}
