package com.example.demo.data;

import com.example.demo.po.Teacher;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by AzureXH on 2019/7/22
 */
public interface TeacherData extends MongoRepository<Teacher, String> {

    List<Teacher> findTeachersByTeachingNotContainsAndDepartmentEquals(String teaching1, String department);
}
