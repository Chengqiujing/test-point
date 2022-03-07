package com.test.demo;

import com.alibaba.fastjson.JSONObject;
import com.test.demo.encryp.HmacSHA256Util;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * *************************************************************************
 * <p/>
 *
 * @文件名称: TestP10.java
 * @包 路 径： com.test.demo
 * @版权所有：北京数字认证股份有限公司 (C) 2022
 * @类描述:
 * @版本: V1.0
 * @author：chengqj
 * @创建时间：2022/1/21 15:48
 */
@SpringBootTest
public class TestP10 {


    @Test
    public void test() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://192.168.136.66:18000/am/zerotrust/getCert.do";
        String time = String.valueOf(System.currentTimeMillis());
        P10 p10 = new P10();
        p10.setP10("MIHJMHACAQAwEDEOMAwGA1UEBhMFQ047Q04wWTATBgcqhkjOPQIBBggqgRzPVQGCLQNCAASXk3icqJa6y7Qo+D3bbylHB0DUkhumNtZjdLebQGZotCXrUrJG5ezIDc3sjl6zstPFQrchxjJhjDv+YnadgbfYMAoGCCqBHM9VAYN1A0kAMEYCIQD56v73aRL9rl8SCUNKbB6wD77UyCqaCIAje4YjYlZ3gwIhAPIMtknL2/KYZkQ89qMvuD3bk45GDHH084vNh8Gnzd3v");

        String data = "post&/am/zerotrust/getCert.do&"+JSONObject.toJSONString(p10)+"&"+time;
        String bcd0188907870108 = HmacSHA256Util.hmacSHA256("bcd0188907870108", data);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Uams-rpc-sign",  bcd0188907870108);
        headers.set("Uams-rpc-client",  "b5ab0e9f7ce94c2d" );
        headers.set("Uams-rpc-timestamp", time);
        ResponseEntity<Map> exchange = restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(p10, headers), Map.class);
        System.out.println(exchange.getBody());
//        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.setInterceptors(Arrays.<ClientHttpRequestInterceptor>asList(new RpcSafeRestTemplateHttpRequestInterceptor("b5ab0e9f7ce94c2d","bcd0188907870108")));
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        HttpEntity<String> entity = new HttpEntity<String>(JSONObject.toJSONString(p10), headers);
//        String s = restTemplate.postForObject(url, entity, String.class);
//        System.out.println(s);

    }


    class P10 {
        private String p10;

        public String getP10() {
            return p10;
        }

        public void setP10(String p10) {
            this.p10 = p10;
        }
    }
}
