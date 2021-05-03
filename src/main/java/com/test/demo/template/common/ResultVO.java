package com.test.demo.template.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * *************************************************************************
 * <p/>
 *
 * @文件名称: ResultVO.java
 * @包 路 径： com.test.demo.template.common
 * @版权所有：北京数字认证股份有限公司 (C) 2021
 * @类描述:
 * @版本: V1.0
 * @author：chengqj
 * @创建时间：2021/4/23 10:58
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultVO {
    private Integer state;
    private String msg;
    private Object data;



    public static ResultVO success(Object data){
        return new ResultVO(0,"成功",data);
    }

    public static ResultVO fail(){
        return new ResultVO(-1,"失败",null);
    }

    public static ResultVO fail(String msg){
        return new ResultVO(-1,msg,null);
    }
}
