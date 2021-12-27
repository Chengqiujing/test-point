package com.test.demo.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * *************************************************************************
 * <p/>
 *
 * @文件名称: AlgorithmTest.java
 * @包 路 径： com.test.demo.algorithm
 * @版权所有：北京数字认证股份有限公司 (C) 2021
 * @类描述:
 * @版本: V1.0
 * @author：chengqj
 * @创建时间：2021/12/27 9:17
 */
public class AlgorithmTest {


    /**
     * 算法学习
     * @param args
     */
    public static void main(String[] args) {
        AlgorithmTest algorithmTest = new AlgorithmTest();
        algorithmTest.test1();


    }



    public void test1(){
        /**
         * 第350题：两个数组的交集
         * 给定两个数组，编写一个函数来计算它们的交集
         *
         * 示例1
         * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
         *
         * 输出: [2,2]
         *
         * 示例2
         * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
         *
         * 输出: [4,9]
         */

        int[] nums1 = {1,2,2,3,1}, nums2 = {2,2,3,3};
        Map<Integer,Integer> map = new HashMap<>();
        for (int i : nums1) {
            if (map.containsKey(i)) {
                map.put(i,map.get(i)+1);
            }else{
                map.put(i,1);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i : nums2) {
            if(map.containsKey(i)){
                int a = map.get(i);
                if(a>0){
                    map.put(i,a-1);
                    result.add(i);
                }
            }
        }

        System.out.println(result);


    }
}
