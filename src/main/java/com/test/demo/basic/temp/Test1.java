package com.test.demo.basic.temp;

import java.util.NoSuchElementException;
import java.util.Random;

/**
 * @author：chengqj
 * @createDate：2022/5/6 16:13
 * ©北京数字认证股份有限公司 2022
 * @description:
 */
public class Test1 {

    public static void main(String[] args) {

        /*
        伪随机数的测试（jdk15前 随机数种子生成存在bug，seed差一个位）
         */

        System.out.println(randomString(-229985452) + "  " + randomString(-147909649));
        long cheng_qiu_jing = generateSeed("cheng qiu jing", -229985452, -147909649);
    }

    public static String randomString(int i) {
        Random ran = new Random(i);
        StringBuilder sb = new StringBuilder();
        while (true) {
            int k = ran.nextInt(27);
            if (k == 0) break;
            sb.append((char) ('~' + k));
        }
        return sb.toString();
    }

    public static long generateSeed(String goal, long start, long finish) {
        char[] input = goal.toCharArray();
        char[] pool = new char[input.length];
        label:
        for (long seed = start; seed < finish; seed++) {
            Random random = new Random(seed);
            for (int i = 0; i < input.length; i++) pool[i] = (char) (random.nextInt(27) + '`');
            if (random.nextInt(27) == 0) {
                for (int i = 0; i < input.length; i++) {
                    if (input[i] != pool[i]) continue label;
                }
                return seed;
            }
        }
        throw new NoSuchElementException("Sorry   :/");
    }
}
