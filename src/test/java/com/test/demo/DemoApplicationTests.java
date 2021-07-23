//package com.test.demo;
//
//import com.test.demo.speed.mybatistest.entity.AuthenticationAccessLog;
//import com.test.demo.speed.mybatistest.mapper.TestMapper;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;
//
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.Random;
//
//@SpringBootTest
//class DemoApplicationTests {
//
//    @Test
//    void contextLoads() {
//    }
//
//
//    @Autowired
//    TestMapper testMapper;
//
//    // 测试能不能返回行数
//    @Test
//    void sqlInsert1() {
//        // 获取10000条数据
//        List<String> test1 = toSqlValues(getData(10000, "test1"));
//        System.out.println("开始插入数据 ...");
//        long start = System.currentTimeMillis();
//        StringBuilder stringBuilder = new StringBuilder("INSERT INTO `tenant_insert`.`authentication_access_log` (\n" +
//                "\t`ID`,\n" +
//                "\t`LOGIN_DN`,\n" +
//                "\t`USER_NAME`,\n" +
//                "\t`NAME_ID`,\n" +
//                "\t`LOGGED_BY`,\n" +
//                "\t`USER_ID`,\n" +
//                "\t`MESSAGE`,\n" +
//                "\t`IP_ADDRESS`,\n" +
//                "\t`CONTENT`,\n" +
//                "\t`ORG_ID`,\n" +
//                "\t`ORG_NAME`,\n" +
//                "\t`LOG_TYPE`,\n" +
//                "\t`CLIENT_TYPE`,\n" +
//                "\t`OPT_TIME`,\n" +
//                "\t`MODULE_NAME`,\n" +
//                "\t`TENANT_ID`\n" +
//                ")\n" +
//                "VALUES\n" +
//                "\t(\n" +
//                "\t\t'10000091f2test1970f7fe801',\n" +
//                "\t\t'id=huhua2389,ou=user,o=ceshiqiye7hao,ou=services,dc=uconf,dc=com',\n" +
//                "\t\t'呼呼啊0',\n" +
//                "\t\t'huhua0',\n" +
//                "\t\t'cn=dsameuser,ou=DSAME Users,o=ceshiqiye7hao,ou=services,dc=uconf,dc=com',\n" +
//                "\t\t'bf9e058c276b41739a96180a4bcbd508',\n" +
//                "\t\t'登录成功',\n" +
//                "\t\t'192.168.126.125',\n" +
//                "\t\t'登录成功|service|initService',\n" +
//                "\t\t'4fce544749c34bc5b866c88f7907fcdf',\n" +
//                "\t\t'测试机构1',\n" +
//                "\t\t'1',\n" +
//                "\t\t'pc',\n" +
//                "\t\t'2021-05-24 23:34:13',\n" +
//                "\t\t'BjcaLDAP',\n" +
//                "\t\t'ceshiqiye1hao'\n" +
//                "\t),\n" +
//                "\n" +
//                "\t(\n" +
//                "\t\t'00000091f2test1970f7fe811',\n" +
//                "\t\t'id=huhua2389,ou=user,o=ceshiqiye7hao,ou=services,dc=uconf,dc=com',\n" +
//                "\t\t'呼呼啊1',\n" +
//                "\t\t'huhua1',\n" +
//                "\t\t'cn=dsameuser,ou=DSAME Users,o=ceshiqiye7hao,ou=services,dc=uconf,dc=com',\n" +
//                "\t\t'bf9e058c276b41739a96180a4bcbd508',\n" +
//                "\t\t'登录成功',\n" +
//                "\t\t'192.168.126.125',\n" +
//                "\t\t'登录成功|service|initService',\n" +
//                "\t\t'4fce544749c34bc5b866c88f7907fcdf',\n" +
//                "\t\t'测试机构1',\n" +
//                "\t\t'1',\n" +
//                "\t\t'pc',\n" +
//                "\t\t'2021-05-24 23:34:13',\n" +
//                "\t\t'BjcaLDAP',\n" +
//                "\t\t'ceshiqiye1hao'\n" +
//                "\t);\n");
//
//
//        int update = jdbcTemplate.update(stringBuilder.toString());
//        System.out.println(update);
//
//        long end = System.currentTimeMillis();
//        System.out.println("插入结束...");
//        System.out.println("总耗时: " + (end - start) / 1000.0);
//
//
//    }
//
//
//    @Test
//    void batchUpdateByMabatis() {
//        List<AuthenticationAccessLog> logList = getData(10000, "test1");
//        for (int i = 0; i < logList.size(); i++) {
//            if (i < 0) {
//                logList.get(i).setId("asd2222fasdf");
//                logList.get(i).setOrgName("111");
//            } else {
//                logList.get(i).setOrgName("1226662");
//            }
//        }
//
//        System.out.println("开始插入数据 ...");
//        long start = System.currentTimeMillis();
//        List<AuthenticationAccessLog> sqlList = new ArrayList<>();
//        int count = 0;
//        for (int i = 0; i < logList.size(); i++) {
//            sqlList.add(logList.get(i));
//            if ((i + 1) % 2000 == 0) {
//                testMapper.updateBatch(sqlList);
//                sqlList.clear();
//            }
//        }
//
//        long end = System.currentTimeMillis();
//        System.out.println("插入结束...");
//        System.out.println("总耗时: " + (end - start) / 1000.0);
//    }
//
//
//    @Autowired
//    JdbcTemplate jdbcTemplate;
//
//    @Test
//    void batchUpdatehalf() {
//        // 获取10000条数据
//
//        List<AuthenticationAccessLog> logList = getData(10000, "test1");
//        for (int i = 0; i < logList.size(); i++) {
//            if (i < 0) {
//                logList.get(i).setId("asdfasdf");
//                logList.get(i).setOrgName("111");
//            } else {
//                logList.get(i).setOrgName("226662");
//            }
//        }
//
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println("开始插入数据 ...");
//        long start = System.currentTimeMillis();
//
////        String sql = "update authentication_access_log set TENANT_ID=?,LOGIN_DN = ?,USER_NAME=?,NAME_ID=?,LOGGED_BY=?,"
////                +"USER_ID=?,MESSAGE=?,IP_ADDRESS=?,CONTENT=?, ORG_ID=?, ORG_NAME=? ," +
////                "LOG_TYPE =?, CLIENT_TYPE=?, OPT_TIME=?, MODULE_NAME=? where id = ?";
//
//        String sql = "update authentication_access_log set TENANT_ID=?" +
//                " where id = ?";
//
//        int[][] ints = jdbcTemplate.batchUpdate(sql, logList, 1000, new ParameterizedPreparedStatementSetter<AuthenticationAccessLog>() {
//            @Override
//            public void setValues(PreparedStatement preparedStatement, AuthenticationAccessLog authenticationAccessLog) throws SQLException {
////                preparedStatement.setString(1, authenticationAccessLog.getId());
////                preparedStatement.setString(2, authenticationAccessLog.getLoginDn());
////                preparedStatement.setString(3, authenticationAccessLog.getUserName());
////                preparedStatement.setString(4, authenticationAccessLog.getNameId());
////                preparedStatement.setString(5, authenticationAccessLog.getLoggedBy());
////                preparedStatement.setString(6, authenticationAccessLog.getUserId());
////                preparedStatement.setString(7, authenticationAccessLog.getMessage());
////                preparedStatement.setString(8, authenticationAccessLog.getIpAddress());
////                preparedStatement.setString(9, authenticationAccessLog.getContent());
////                preparedStatement.setString(10, authenticationAccessLog.getOrgId());
////                preparedStatement.setString(11, authenticationAccessLog.getOrgName());
////                preparedStatement.setString(12, String.valueOf(authenticationAccessLog.getLogType()));
////                preparedStatement.setString(13, authenticationAccessLog.getClientType());
////                preparedStatement.setString(14, sdf.format(authenticationAccessLog.getOptTime()));
////                preparedStatement.setString(15, authenticationAccessLog.getModuleName());
//                preparedStatement.setString(1, authenticationAccessLog.getTenantId());
//                preparedStatement.setString(2, authenticationAccessLog.getId());
//            }
//        });
////        for (int i1 = 0; i1 < ints.length; i1++) {
////            System.out.println(Arrays.toString(ints[i1]));
////        }
//
//        long end = System.currentTimeMillis();
//        System.out.println("插入结束...");
//        System.out.println("总耗时: " + (end - start) / 1000.0);
//
//
//    }
//
//    @Test
//    void batchUpdate() {
//        // 获取10000条数据
//
//        List<AuthenticationAccessLog> test11 = getData(10000, "test1");
//        test11.forEach(log -> log.setOrgName(log.getOrgName() + 3));
//        List<String> sqls = toUpdateSql(test11);
//        System.out.println("开始插入数据 ...");
//        long start = System.currentTimeMillis();
//        List<String> sqlList = new ArrayList<>();
//        int count = 0;
//        for (int i = 0; i < sqls.size(); i++) {
//            sqlList.add(sqls.get(i));
//            if ((i + 1) % 1000 == 0) {
//                int[] ints = jdbcTemplate.batchUpdate(sqlList.toArray(new String[]{}));
//                for (int anInt : ints) {
//                    count += anInt;
//                }
//                sqlList.clear();
//            }
//        }
//        if (!sqlList.isEmpty()) {
//            int[] ints = jdbcTemplate.batchUpdate(sqlList.toArray(new String[]{}));
//            for (int anInt : ints) {
//                count += anInt;
//            }
//        }
//        System.out.println("修改总条数：" + count);
//        long end = System.currentTimeMillis();
//        System.out.println("插入结束...");
//        System.out.println("总耗时: " + (end - start) / 1000.0);
//
//
//    }
//
//    @Test
//    void update() {
//        List<AuthenticationAccessLog> test11 = getData(10000, "test1");
//        test11.forEach(log -> log.setOrgName(log.getOrgName() + 1));
//        List<String> test1 = toUpdateSql(test11);
//        System.out.println("开始插入数据 ...");
//        long start = System.currentTimeMillis();
//        for (int i = 0; i < test1.size(); i++) {
//            jdbcTemplate.execute(test1.get(i));
////            System.out.println("插入"+i+"条");
//        }
//        long end = System.currentTimeMillis();
//        System.out.println("插入结束...");
//        System.out.println("总耗时: " + (end - start) / 1000.0);
//
//    }
//
//    @Test
//    void sqlInsert() {
//        // 获取10000条数据
//
//        List<String> test1 = toSqlValues(getData(500000, "test2"));
//        System.out.println("开始插入数据 ...");
//        long start = System.currentTimeMillis();
//        StringBuilder stringBuilder = new StringBuilder("insert into authentication_access_log values");
//        for (int i = 1; i <= test1.size(); i++) {
//            stringBuilder.append(test1.get(i - 1)).append(",");
//            if (i % 1000 == 0) {
//                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
//                jdbcTemplate.execute(stringBuilder.toString());
//                stringBuilder = new StringBuilder("insert into authentication_access_log values");
//            }
//        }
//        if (test1.size() % 1000 != 0) {
//            jdbcTemplate.execute(stringBuilder.toString());
//        }
//        long end = System.currentTimeMillis();
//        System.out.println("插入结束...");
//        System.out.println("总耗时: " + (end - start) / 1000.0);
//
//
//    }
//
//
//    @Test
//    void insert() {
//        // 获取10000条数据
//
//        List<String> test1 = toInsertSql(getData(10000, "test1"));
//        System.out.println("开始插入数据 ...");
//        long start = System.currentTimeMillis();
//        for (int i = 0; i < test1.size(); i++) {
//            jdbcTemplate.execute(test1.get(i));
////            System.out.println("插入"+i+"条");
//        }
//        long end = System.currentTimeMillis();
//        System.out.println("插入结束...");
//        System.out.println("总耗时: " + (end - start) / 1000.0);
//
//
//    }
//
//
//    List<String> toInsertSql(List<AuthenticationAccessLog> logs) {
//        List<String> sqls = new ArrayList<>();
//        for (AuthenticationAccessLog log : logs) {
//            sqls.add(log.toInsertSql());
//        }
//        return sqls;
//    }
//
//    List<String> toUpdateSql(List<AuthenticationAccessLog> logs) {
//        List<String> sqls = new ArrayList<>();
//        for (AuthenticationAccessLog log : logs) {
//            sqls.add(log.toUpdateSql());
//        }
//        return sqls;
//    }
//
//    List<String> toSqlValues(List<AuthenticationAccessLog> logs) {
//        List<String> sqls = new ArrayList<>();
//        for (AuthenticationAccessLog log : logs) {
//            sqls.add(log.sqlValues());
//        }
//        return sqls;
//    }
//
//    /**
//     * 获取1w条数据
//     *
//     * @return
//     */
//    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//    Random random = new Random(1);
//
//    List<AuthenticationAccessLog> getData(int num, String yizi) {
//        List<AuthenticationAccessLog> dataList = new ArrayList<>();
//
//        try {
//
//            for (int i = 0; i < num; i++) {
//                Date parse = sdf.parse("2021-06-01 00:12:01");
//                parse.setHours(random.nextInt(24));
//
//                AuthenticationAccessLog log = new AuthenticationAccessLog();
//                log.setId("0009f2" + yizi + "970f7fe8" + i);
//                log.setLoginDn("id=huhua2389,ou=user,o=ceshiqiye7hao,ou=services,dc=uconf,dc=com");
//                log.setUserName(yizi + "呼呼啊");
//                log.setNameId(yizi + "huhua");
//                log.setLoggedBy("cn=dsameuser,ou=DSAME Users,o=ceshiqiye7hao,ou=services,dc=uconf,dc=com");
//                log.setUserId("bf9e058c27" + yizi + "80a4bcbd508");
//                log.setMessage("登录成功");
//                log.setIpAddress("192.168.126.125");
//                log.setContent("登录成功|service|initService");
//                log.setOrgId("4fce544749c34bc5b866c88f7907fcdf");
//                log.setOrgName("测试机构");
//                log.setLogType(1);
//                log.setClientType("pc");
//                log.setOptTime(parse);
//                log.setModuleName("BjcaLDAP");
//                log.setTenantId("ceshiqiye1hao");
//                dataList.add(log);
//            }
//            return dataList;
//
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//
//}
