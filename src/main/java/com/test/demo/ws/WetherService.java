package com.test.demo.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * *************************************************************************
 * <p/>
 *
 * @文件名称: WetherService.java
 * @包 路 径： com.test.demo.ws
 * @版权所有：北京数字认证股份有限公司 (C) 2022
 * @类描述:
 * @版本: V1.0
 * @author：chengqj
 * @创建时间：2022/1/6 17:37
 */
@WebService
public class WetherService {

    @WebMethod
    public String getTemperature(@WebParam(name = "address", mode = WebParam.Mode.IN) String address){

        if("湖北".equals(address)){
            return "36℃";
        }

        return "未获取温度信息";
    }


    @WebMethod
    public String getTemperature2(@WebParam(name = "address", mode = WebParam.Mode.IN) String address){

        if("湖北".equals(address)){
            return "36℃";
        }

        return "未获取温度信息";
    }

}
