package com.test.demo.template.common;

import lombok.Data;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * *************************************************************************
 * <p/>
 *
 * @文件名称: BizContext.java
 * @包 路 径： com.test.demo.template.common
 * @版权所有：北京数字认证股份有限公司 (C) 2021
 * @类描述:
 * @版本: V1.0
 * @author：chengqj
 * @创建时间：2021/4/23 14:52
 */
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
