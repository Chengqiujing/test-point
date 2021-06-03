package com.test.demo.kafka.producer;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * *************************************************************************
 * <p/>
 *
 * @文件名称: LogService.java
 * @包 路 径： com.test.demo.kafka.producer
 * @版权所有：北京数字认证股份有限公司 (C) 2021
 * @类描述:
 * @版本: V1.0
 * @author：chengqj
 * @创建时间：2021/6/3 10:25
 */
@Service
public class LogService {
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;
    private Map<String,String> messageTypeMap=new HashMap<String, String>();
    private static final String KAFKA_TOPIC_AM_AUTHEN_LOG="KAFKA_TOPIC_AM_AUTHEN_LOG";
    private static final String KAFKA_TOPIC_AM_SSO_LOG="KAFKA_TOPIC_AM_SSO_LOG";
//    private static final String KAFKA_TOPIC_AM_RISK_LOG="KAFKA_TOPIC_AM_RISK_LOG";
    private Logger logger=LoggerFactory.getLogger(LogService.class);
    /**
     * 记录登录成功
     * @param logRecord 日志记录
     *                  @param type 日志类型 是记录成功日志 还是失败日志 0成功 1失败
     */
    public void logAuthenticationAcess(Map logMap, int type){
        Map<String,Object> messageMap=new HashMap<String, Object>();
        String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
        messageMap.put("id",uuid);
        String domain= (String) logMap.get("Domain");
        messageMap.put("loggedBy","cn=dsameuser,ou=DSAME Users,"+domain);
        String loginDN= (String) logMap.get("LoginID");
        messageMap.put("loginDn",loginDN);
        String userName= (String) logMap.get("UserName");
        messageMap.put("userName",userName);
        String nameId= (String) logMap.get("NameID");
        messageMap.put("nameId",nameId);
        String userId= (String) logMap.get("uniqueid");
        if(StringUtils.isEmpty(userId)){
            return; //如果没有用户信息无法记录
        }
        messageMap.put("userId",userId);
        String messageId= (String) logMap.get("MessageID");
        messageMap.put("message",messageTypeMap.get(messageId));
        String content= (String) logMap.get("Data");
        messageMap.put("content",content);
        String hostName= (String) logMap.get("HostName");
        messageMap.put("ipAddress",hostName);
        String orgId= (String) logMap.get("DepartID");
        messageMap.put("orgId",orgId);
        String orgName= (String) logMap.get("OrgName");
        messageMap.put("orgName",orgName);
        //IDM标准是 1是成功 0是失败 和AM 相反
        messageMap.put("logType",type==1?0:1);
        String clientType=(String) logMap.get("clienttype");
        messageMap.put("clientType",clientType);
        String optTime=(String) logMap.get("TIME");
        messageMap.put("optTime",optTime);
        String moduleName=(String) logMap.get("ModuleName");
        messageMap.put("moduleName",moduleName);
        sendAuthenLogMsg(messageMap);

    }

    /**
     * 发送消息认证消息
     * @param logMsgMap 使用map存储消息
     */
    private void sendAuthenLogMsg(Map<String,Object> logMsgMap){
        String jsonStr = JSONObject.toJSONString(logMsgMap);
        ListenableFuture<SendResult<String,String>> listenableFuture= kafkaTemplate.send(KAFKA_TOPIC_AM_AUTHEN_LOG,jsonStr);
        listenableFuture.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable ex) {
                logger.error("发送认证日志失败！",ex);
            }

            @Override
            public void onSuccess(SendResult<String, String> result) {
                logger.info("发送认证日志成功！"+jsonStr);
            }
        });
    }

    /**
     * 发送单点登录消息
     * @param logMsgMap 使用map存储消息
     */
    private void sendSSOLogMsg(Map<String,Object> logMsgMap){
        String jsonStr = JSONObject.toJSONString(logMsgMap);
        ListenableFuture<SendResult<String,String>> listenableFuture= kafkaTemplate.send(KAFKA_TOPIC_AM_SSO_LOG,jsonStr);
        listenableFuture.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable ex) {
                logger.error("发送认证日志失败！",ex);
            }

            @Override
            public void onSuccess(SendResult<String, String> result) {
//                logger.info("发送认证日志成功！"+jsonStr);
            }
        });
    }

//    /**
//     * 发送风险历史日志记录
//     * @param logMsgMap 使用map存储消息
//     */
//    private void sendRiskLogMsg(Map<String,Object> logMsgMap){
//        String jsonStr = JSONObject.toJSONString(logMsgMap);
//        ListenableFuture<SendResult<String,String>> listenableFuture= kafkaTemplate.send(KAFKA_TOPIC_AM_RISK_LOG,jsonStr);
//        listenableFuture.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
//            @Override
//            public void onFailure(Throwable ex) {
//                logger.error("发送风险历史日志失败！",ex);
//            }
//
//            @Override
//            public void onSuccess(SendResult<String, String> result) {
//                logger.info("发送风险历史日志成功！"+jsonStr);
//            }
//        });
//    }

    /**
     * 记录单点登录日志
     */
    public void logSSOlog(Map logMap,int type){
        Map<String,Object> messageMap=new HashMap<String, Object>();
        String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
        messageMap.put("id",uuid);
        String loginDN= (String) logMap.get("LoginID");
        messageMap.put("loginDn",loginDN);
        String appName= (String) logMap.get("NameID");
        messageMap.put("appName",appName);
        messageMap.put("loggedBy","cn=dsameuser,ou=DSAME Users,");
        String userId=  (String) logMap.get("uniqueid");
        messageMap.put("userId",userId);
        String messageId=  (String) logMap.get("MessageID");
        messageMap.put("message",messageTypeMap.get(messageId));
        String hostName=  (String) logMap.get("IPAddr");
        messageMap.put("ipAddress",hostName);
        String content=  (String) logMap.get("data");
        messageMap.put("content",content);
        String orgId=  (String) logMap.get("DepartID");
        messageMap.put("orgId",orgId);
        String orgName=  (String) logMap.get("OrgName");
        messageMap.put("orgName",orgName);
        messageMap.put("logType",1);
        String clientType=  (String) logMap.get("clienttype");
        messageMap.put("clientType",clientType);
        String optTime=  (String) logMap.get("TIME");
        messageMap.put("optTime",optTime);
        String appId=  (String) logMap.get("ModuleName");
        messageMap.put("appId",appId);
        String appOrgName=  (String) logMap.get("AppOrgName");
        messageMap.put("appOrgName",appOrgName);
        String appOrgId=  (String) logMap.get("AppOrgID");
        messageMap.put("appOrgId",appOrgId);
        String userName=  (String) logMap.get("UserName");
        messageMap.put("userName",userName);
        sendSSOLogMsg(messageMap);
    }

    /**
     * 记录风险历史日志
     */
//    public void logRisklog(LogRecord logRecord){
//        Map logMap = logRecord.getLogInfoMap();
//        Map<String,Object> messageMap=new HashMap<String, Object>();
//        messageMap.put("id",logMap.get(LogConstants.LOGIN_ID));
//        messageMap.put("userId",logMap.get("uniqueid"));
//        messageMap.put("riskType",logMap.get(LogConstants.MODULE_NAME));
//        messageMap.put("riskDesc",logMap.get(LogConstants.MESSAGE_ID));
//        messageMap.put("riskTime",logMap.get(LogConstants.TIME));
//        messageMap.put("credenceUniqueid",logMap.get(LogConstants.NAME_ID));
//        messageMap.put("clientType",logMap.get("clientType"));
//        messageMap.put("operateIp",logMap.get(LogConstants.IP_ADDR));
//        sendRiskLogMsg(messageMap);
//    }

    public LogService(){
        messageTypeMap.put("AUTHENTICATION-100","登录成功");
        messageTypeMap.put("AUTHENTICATION-103","登录成功");
        messageTypeMap.put("AUTHENTICATION-105","登录成功");
        messageTypeMap.put("AUTHENTICATION-300","登出成功");
        messageTypeMap.put("AUTHENTICATION-303","登出成功");
        messageTypeMap.put("AUTHENTICATION-305","登出成功");
        messageTypeMap.put("AUTHENTICATION-240","用户不存在");
        messageTypeMap.put("AUTHENTICATION-241","密码无效");

        messageTypeMap.put("AUTHENTICATION-205","账户被锁定");
        messageTypeMap.put("AUTHENTICATION-218","账户被锁定");
        messageTypeMap.put("AUTHENTICATION-231","账户被锁定");
        messageTypeMap.put("AUTHENTICATION-245","账户被锁定");
        messageTypeMap.put("AUTHENTICATION-272","账户被锁定");

        messageTypeMap.put("AUTHENTICATION-240","账户状态非法");
        messageTypeMap.put("AUTHENTICATION-268","账户状态非法");

        messageTypeMap.put("AUTHENTICATION-273","用户过期");
        messageTypeMap.put("AUTHENTICATION-206","用户过期");
        messageTypeMap.put("AUTHENTICATION-219","用户过期");
        messageTypeMap.put("AUTHENTICATION-232","用户过期");
        messageTypeMap.put("AUTHENTICATION-246","用户过期");
        messageTypeMap.put("AUTHENTICATION-260","用户过期");
        messageTypeMap.put("UAMS-100","单点登录");
    }
}
