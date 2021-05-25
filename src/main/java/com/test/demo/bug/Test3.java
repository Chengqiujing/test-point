package com.test.demo.bug;

import java.util.Calendar;
import java.util.Date;

/**
 * *************************************************************************
 * <p/>
 *
 * @文件名称: Test3.java
 * @包 路 径： com.test.demo.bug
 * @版权所有：北京数字认证股份有限公司 (C) 2021
 * @类描述:
 * @版本: V1.0
 * @author：chengqj
 * @创建时间：2021/5/25 13:38
 */
public class Test3 {
    public static void main(String[] args) {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Calendar endCal = Calendar.getInstance();
        endCal.add(Calendar.DAY_OF_MONTH, 1);

        System.out.println(calendar.getTime() + "--" + endCal.getTime());

    }
}
