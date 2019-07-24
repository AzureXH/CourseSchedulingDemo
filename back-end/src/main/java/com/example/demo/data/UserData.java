package com.example.demo.data;

import com.example.demo.po.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by AzureXH on 2019/7/21
 */
public interface UserData extends MongoRepository<User, String> {

    User findByUsername(String username);

}
