package com.test.demo;

import com.test.demo.datatest.consumer.mapper.generated.SchooleMapper;
import com.test.demo.datatest.consumer.mapper.generated.StudentMapper;
import com.test.demo.datatest.consumer.mapper.generated.StudentToSchoolMapper;
import com.test.demo.datatest.consumer.po.generated.Schoole;
import com.test.demo.datatest.consumer.po.generated.Student;
import com.test.demo.datatest.consumer.po.generated.StudentToSchool;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;

/**
 * *************************************************************************
 * <p/>
 *
 * @文件名称: DataTest.java
 * @包 路 径： com.test.demo
 * @版权所有：北京数字认证股份有限公司 (C) 2021
 * @类描述:
 * @版本: V1.0
 * @author：chengqj
 * @创建时间：2021/12/20 18:03
 */
@SpringBootTest
public class DataTest {

    @Autowired
    SchooleMapper schooleMapper;
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    StudentToSchoolMapper studentToSchoolMapper;


    @Test
    void testFindDemo(){
        List<String> demo = schooleMapper.findDemo();
        System.out.println(demo.size());
    }

    @Test
    void testAbsent(){
        int count = 1000000;
        for (int i = 0; i < count; i++) {

            UUID uuidStu = UUID.randomUUID();
            UUID uuidSch = UUID.randomUUID();

            Student student = new Student();
            student.setId(uuidStu.toString());
            student.setName("张三"+i);
            student.setAge(20);
            student.setAddress("地址测试");
            student.setBuchong1("123123");
            student.setBuchong2("321321");
            student.setBuchong3("1qazzaq1");

            Schoole schoole = new Schoole();
            schoole.setId(uuidSch.toString());
            schoole.setSchooleName("学校"+i);
            schoole.setSchooleAddress("111111");
            schoole.setSchooleType("54lkjh");
            schoole.setSchooleAmount("aaaa1111");
            schoole.setSchooleAdmin("xiaozhang");

            StudentToSchool studentToSchool = new StudentToSchool();
            studentToSchool.setStudentId(student.getId());
            studentToSchool.setSchooleId(schoole.getId());

            studentMapper.insert(student);
            schooleMapper.insert(schoole);
            studentToSchoolMapper.insert(studentToSchool);
            System.out.println("insert: " + i);
        }

    }



}
