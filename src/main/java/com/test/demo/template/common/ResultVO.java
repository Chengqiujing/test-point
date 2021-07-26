package com.test.demo.template.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


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
