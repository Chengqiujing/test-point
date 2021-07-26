package com.test.demo.template.config;

import com.test.demo.template.common.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

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
