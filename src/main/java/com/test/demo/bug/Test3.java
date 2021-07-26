package com.test.demo.bug;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Test3 {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Calendar endCal = Calendar.getInstance();
        endCal.add(Calendar.DAY_OF_MONTH, 1);

        System.out.println(sdf.format(calendar.getTime()) + "--" + sdf.format(endCal.getTime()));

    }
}
