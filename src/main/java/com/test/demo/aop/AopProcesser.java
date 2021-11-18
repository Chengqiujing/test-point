package com.test.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * *************************************************************************
 * <p/>
 *
 * @文件名称: AopProcess.java
 * @包 路 径： com.test.demo.aop
 * @版权所有：北京数字认证股份有限公司 (C) 2021
 * @类描述:
 * @版本: V1.0
 * @author：chengqj
 * @创建时间：2021/11/18 14:07
 */
@Component
@Aspect
public class AopProcesser {

    @Before("@annotation(preProcesser)")
    public void annotationPoinCut(JoinPoint joinPoint, AttrDatePreProcesser  preProcesser){
//        System.out.println(preProcesser.name());
        System.out.println(preProcesser.type());
        Object[] args = joinPoint.getArgs();
        System.out.println(Arrays.toString(args));
    }


    @AfterReturning(pointcut="@annotation(postProcesser)",returning="retVal")
    public void annotationPoinCut2(JoinPoint joinPoint, AttrDatePostProcesser postProcesser,Object retVal){
//        retVal.getClass().get
    }

}
