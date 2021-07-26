package com.test.demo.template.controller;

import com.test.demo.template.common.ResultVO;
import com.test.demo.template.entity.User;
import com.test.demo.template.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/template")
public class HelloController {
    @Autowired
    UserService userService;

    @PostMapping("saveUser")
    public ResultVO saveUser(User user){
        return userService.dealRequest(user);
    }

}
