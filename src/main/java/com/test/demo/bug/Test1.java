package com.test.demo.bug;


import lombok.extern.slf4j.Slf4j;
import org.junit.platform.commons.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;


@Slf4j
public class Test1 {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    public static void main(String[] args) throws Exception {
        Test1 test1 = new Test1();
//        test1.checkRefer("http://dev.genesis.orientsec.com.cn/");
//        test1.checkRefer("http://www.baidu.com");
        Random random = new Random(System.currentTimeMillis());
        int i = random.nextInt(1000);
        System.out.println(i);

        System.out.println(Math.ceil(23.098));
    }




    public boolean checkRefer( String referer) throws MalformedURLException {

        Set urlSets = new HashSet();
        urlSets.add("http://genesis.orientsec.com.cn;http://dev.genesis.1orientsec.com.cn;http://qa.genesis.orientsec.com.cn");
        urlSets.add("http://genesis.orientsec.com.cn/gateway/bjca/sso_callback;http://dev.1genesis.orientsec.com.cn/gateway/bjca/sso_callback;http://qa.genesis.orientsec.com.cn/gateway/bjca/sso_callback");

        URL refer = new URL(referer);
        for (Object url : urlSets) {
            String u = (String) url;
            // host相等,返回true
            if (StringUtils.isNotBlank(u) && org.thymeleaf.util.StringUtils.contains(u,refer.getHost())) {
                logger.debug("referer匹配成功,referer=[" + refer.getHost() + "],url=[" + u + "]");
                return true;
            }
        }

        logger.debug("refer[" + refer.getHost() + "]未在应用列表中找到匹配,跳转失败");
        logger.debug("应用列表:" + urlSets + "]");
        return false;
    }
}
