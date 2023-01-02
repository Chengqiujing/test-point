package com.test.demo.template.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <p>
 *
 * </p>
 *
 * @description:
 * @author: chengqj
 * @date: Created in 2021/12/23 22:00
 * @version: V1.0
 */
@Controller
public class TestController {

    @GetMapping("hello")
    public String sayHello() {
        return "hello";
    }


}
