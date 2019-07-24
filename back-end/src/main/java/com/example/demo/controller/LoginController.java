package com.example.demo.controller;

import com.example.demo.bl.LoginService;
import com.example.demo.vo.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by AzureXH on 2019/7/20
 */
@RestController
public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public Boolean login(@RequestBody LoginForm loginForm){
        return loginService.Login(loginForm);
    }
}
