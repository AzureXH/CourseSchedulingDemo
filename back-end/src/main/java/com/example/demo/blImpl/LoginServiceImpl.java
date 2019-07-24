package com.example.demo.blImpl;

import com.example.demo.bl.LoginService;
import com.example.demo.data.UserData;
import com.example.demo.po.User;
import com.example.demo.vo.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by AzureXH on 2019/7/21
 */
@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    UserData userData;

    @Override
    public Boolean Login(LoginForm loginForm) {
        User user = userData.findByUsername(loginForm.getUsername());
        if (user != null){
            return true;
        }else{
            return false;
        }
    }
}
