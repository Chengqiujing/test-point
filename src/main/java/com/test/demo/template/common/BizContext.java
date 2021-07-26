package com.test.demo.template.common;

import lombok.Data;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;


@Data
public class BizContext {
    //返回结果
    private ResultVO resultVO;
    // 配置对象
    private OpertaionConfig config;
    // 传递对象
    private Map<String,Object> tranferObj;
    // HttpServletRequest
    private HttpServletRequest request;
    // HttpServletResponse
    private HttpServletResponse response;
    // HttpSession
    private HttpSession session;


    public boolean back(){
        return resultVO != null;
    }

}
