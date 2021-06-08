package com.test.demo;

import com.test.demo.kafka.producer.LogService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.*;

@SpringBootTest
class KafkaTests {

    @Test
    void contextLoads() {
    }


    @Autowired
    LogService logService;
    /**
     * 测试kafka插入数据
     */
    @Test
    public void inKafka(){

    }

    /**
     * SSO造数据
     */
    @Test
    public void testSsoBatchInsert(){
        Random random = new Random();
        String[] depart = {"org1","org2","org3"};
        String[] app = {"a1","a2","a3"};

        for (int i = 0; i < 30; i++) { // 用户数
            int i1 = random.nextInt(3);
            List<Map> test1 = getSso1wData(20,"test"+ i,"2021-06-06 00:12:01",depart[i1],app[i1],String.valueOf(i1)); // 每个用户登录多少次

            for (Map s : test1) {
                logService.logSSOlog(s,1);
            }
        }
        System.out.println("执行完毕");
    }

    private List<Map> getSso1wData(int num,String flag,String dateStr,String depart,String app,String appOrg){
        List<Map> list = new ArrayList<>();

        try {
            for (int i = 0; i < num; i++) {
                Date date = sdf.parse(dateStr);
                date.setHours(random.nextInt(24));

                Map<String,Object> messageMap=new HashMap<String, Object>();
                messageMap.put("LoginID","dc=uconf,dc=com");
                messageMap.put("NameID","appName"+app); // appname
                messageMap.put("uniqueid","bf9e058c27"+ flag +"80a4bcbd508");
                messageMap.put("MessageID","AUTHENTICATION-105");
                messageMap.put("IPAddr","192.168.126.125");
                messageMap.put("data","登录成功|service|initService");
                messageMap.put("DepartID","4fce544749c3"+depart+"8f7907fcdf");
                messageMap.put("OrgName","测试机构"+depart);
                messageMap.put("clienttype","pc");
                messageMap.put("TIME",sdf.format(date));
                messageMap.put("ModuleName","4fce256949c"+app+"88f79856fcdf");
                messageMap.put("AppOrgName","应用机构");
                messageMap.put("AppOrgID","147852"+appOrg);
                messageMap.put("Domain","dc=uconf,dc=com");
                messageMap.put("UserName",flag +"呼呼啊");
                //IDM标准是 1是成功 0是失败 和AM 相反
//                messageMap.put("logType",1);
//                String s = JSONObject.toJSONString(messageMap);
                list.add(messageMap);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return list;
    }


    // ------------------------------------------------------------------------------------------
    /**
     * Auth造数据
     */
    @Test
    public void testAuthBatchInsert(){
        for (int i = 0; i < 300000; i++) { // 用户数
            List<Map> test1 = get1wData(20,"test"+ i,"2021-06-02 00:12:01"); // 每个用户登录多少次

            for (Map s : test1) {
                logService.logAuthenticationAcess(s,1);
            }
        }
        System.out.println("执行完毕");
    }

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Random random = new Random(1);

    private List<Map> get1wData(int num,String flag,String dateStr){
        List<Map> list = new ArrayList<>();

        try {
            for (int i = 0; i < num; i++) {
                Date date = sdf.parse(dateStr);
                date.setHours(random.nextInt(24));

                Map<String,Object> messageMap=new HashMap<String, Object>();
//                messageMap.put("uniqueid","0000009f2" + flag + "970f7fe8" + i);
                messageMap.put("Domain","dc=uconf,dc=com");
                messageMap.put("LoginID","dc=uconf,dc=com");
                messageMap.put("UserName",flag +"呼呼啊");
                messageMap.put("NameID",flag + "huhua");
                messageMap.put("uniqueid","bf9e058c27"+ flag +"80a4bcbd508");
                messageMap.put("MessageID","AUTHENTICATION-105");
                messageMap.put("Data","登录成功|service|initService");
                messageMap.put("HostName","192.168.126.125");
                messageMap.put("DepartID","4fce544749c34bc5b866c88f7907fcdf");
                messageMap.put("OrgName","测试机构");
                //IDM标准是 1是成功 0是失败 和AM 相反
//                messageMap.put("logType",1);
                messageMap.put("clienttype","pc");
                messageMap.put("TIME",sdf.format(date));
                messageMap.put("ModuleName","BjcaLDAP");
//                String s = JSONObject.toJSONString(messageMap);
                list.add(messageMap);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return list;
    }








}
