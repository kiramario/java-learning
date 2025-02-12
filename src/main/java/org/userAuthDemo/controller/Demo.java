package org.userAuthDemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import org.springframework.web.bind.annotation.*;
import org.userAuthDemo.aspect.ApiLog;

import java.util.HashMap;
import java.util.Map;


@RestController
public class Demo {
    Logger logger = LoggerFactory.getLogger(Demo.class);

    @GetMapping("/auth/login")
    @ApiLog
    public Map<String, String> login(@RequestParam Map<String, String> map) {
        String username = map.getOrDefault("username", "");
        String password = map.getOrDefault("password", "");

        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        Subject subject = SecurityUtils.getSubject();

        int a = 1 / 0;

        try{
            //重点！！！！！！
            //getAuthenticationInfo 执行时机
            subject.login(token);
        } catch (Exception e){
            e.printStackTrace();
        }

        Map<String, String> get_res = new HashMap<>();

        //重点！！！！！！
        //getAuthorizationInfo  执行时机 -- subject.hasRole()
        if (subject.hasRole("admin")) {
            get_res.put("result", "admin");
            get_res.put("code", "201");
        } else if (!subject.hasRole("admin")) {
            get_res.put("result", "not admin");
            get_res.put("code", "201");
        } else {
            get_res.put("result", "invalid authentication");
            get_res.put("code", "201");
        }

        return get_res;
    }

    @GetMapping("/auth/test")
    @ApiLog
    public Map<String, String> authTest() {
        Map<String, String> get_res = new HashMap<>();
        get_res.put("result", "ok");
        get_res.put("code", "201");
        return get_res;
    }
}
