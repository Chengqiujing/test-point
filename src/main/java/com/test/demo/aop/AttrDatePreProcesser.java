package com.test.demo.aop;

import java.lang.annotation.*;

/**
 * *************************************************************************
 * <p/>
 *
 * @文件名称: ParamPreDo.java
 * @包 路 径： com.test.demo.aop
 * @版权所有：北京数字认证股份有限公司 (C) 2021
 * @类描述:
 * @版本: V1.0
 * @author：chengqj
 * @创建时间：2021/11/18 14:10
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AttrDatePreProcesser {
    Class type();
}
