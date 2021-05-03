package com.test.demo.template.controller;

import com.test.demo.template.common.ResultVO;
import com.test.demo.template.entity.User;
import com.test.demo.template.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * *************************************************************************
 * <p/>
 *
 * @文件名称: HelloController.java
 * @包 路 径： com.test.demo.template.controller
 * @版权所有：北京数字认证股份有限公司 (C) 2021
 * @类描述:
 * @版本: V1.0
 * @author：chengqj
 * @创建时间：2021/4/23 10:43
 */
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
