package com.test.demo.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * *************************************************************************
 * 用aop去处理传入参数
 *
 * @author：chengqj
 * @创建时间：2021/11/18 13:58
 */
@Controller
public class DemoController {

    @Autowired
    AopService aopService;

    @RequestMapping("/getOne")
    @ResponseBody
    public Student getOne(@RequestBody Param param){
        System.out.println(param);
        Student one = aopService.getOne(param);
        return one;
    }

}
