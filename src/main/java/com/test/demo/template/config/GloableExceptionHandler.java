package com.test.demo.template.config;

import com.test.demo.template.common.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * *************************************************************************
 * <p/>
 *
 * @文件名称: GloableExceptionHandler.java
 * @包 路 径： com.test.demo.template.config
 * @版权所有：北京数字认证股份有限公司 (C) 2021
 * @类描述:
 * @版本: V1.0
 * @author：chengqj
 * @创建时间：2021/4/23 17:54
 */
@ControllerAdvice
@Slf4j
public class GloableExceptionHandler {

    /**
     * 参数绑定异常
     *
     * @param e
     * @return result
     */
    @ExceptionHandler(Exception.class)
    public ResultVO handleHttpMessageNotReadableException(Exception e) {
        log.error("发生错误", e);
        return ResultVO.fail(e.getMessage());
    }

}
