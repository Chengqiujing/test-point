package com.test.demo.aop;

import org.springframework.stereotype.Service;

/**
 * *************************************************************************
 * <p/>
 *
 * @文件名称: AopService.java
 * @包 路 径： com.test.demo.aop
 * @版权所有：北京数字认证股份有限公司 (C) 2021
 * @类描述:
 * @版本: V1.0
 * @author：chengqj
 * @创建时间：2021/11/18 14:42
 */
@Service
public class AopService {

    @AttrDatePreProcesser(type=Param.class)
    @AttrDatePostProcesser(type=Student.class)
    public Student getOne(Param param){
        Student student = new Student();
        student.setName(param.getData());
        return student;
    }

}
