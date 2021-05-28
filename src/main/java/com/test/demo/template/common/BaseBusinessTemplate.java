package com.test.demo.template.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * *************************************************************************
 * <p/>
 *
 * @文件名称: BaseBusiness.java
 * @包 路 径： cn.org.bjca.idm.business.certification
 * @版权所有：北京数字认证股份有限公司 (C) 2021
 * @类描述: 顶级业务抽象类
 * @版本: V1.0
 * @author：chengqiujing
 * @创建时间：2021/2/3 10:26
 */
public abstract class BaseBusinessTemplate<T,R>{
    private final Logger logger = LoggerFactory.getLogger(BaseBusinessTemplate.class);
//    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("stringMessages");

    private BizContext bizContext;

    public ResultVO dealRequest(T o){
        return dealRequest(o,new HashMap<>(),null,null,null);
    }

    public ResultVO dealRequest(T o,HttpSession session){
        return dealRequest(o,new HashMap<>(),null,null,session);
    }

    public ResultVO dealRequest(T o,HttpServletRequest request, HttpServletResponse response, HttpSession session){
        return dealRequest(o,new HashMap<>(),request,response,session);
    }

    public ResultVO dealRequest(T o, Map<String,Object> tranferObj, HttpServletRequest request, HttpServletResponse response, HttpSession session){
        BizContext bizContext = new BizContext();
        bizContext.setResultVO(null);
        bizContext.setConfig(new OpertaionConfig());
        bizContext.setTranferObj(new HashMap<>());
        bizContext.setRequest(request);
        bizContext.setResponse(response);
        bizContext.setSession(session);

        try {
            // 封装数据
            R r = packageDO(o,tranferObj);
            if(bizContext.back()){
                return bizContext.getResultVO();
            }
            // 1. 检查权限
            checkRight(r, tranferObj);
            if(bizContext.back()){
                return bizContext.getResultVO();
            }
            // 2. 校验数据
            validateData(r, tranferObj);
            if(bizContext.back()){
                return bizContext.getResultVO();
            }
            // 3. 检查业务依赖关系
            dealBizRelationShip(r, tranferObj);
            if(bizContext.back()){
                return bizContext.getResultVO();
            }
            // 4. 业务处理
            dealBiz(r, tranferObj);
            if(bizContext.back()){
                return bizContext.getResultVO();
            }
            // 5. 日志记录
            doLog(r, tranferObj);
            if(bizContext.back()){
                return bizContext.getResultVO();
            }
            // 6. 发布
            doPublish(r, tranferObj);
            if(bizContext.back()){
                return bizContext.getResultVO();
            }
        } catch (Exception e) {

            logger.error("业务操作发生错误", e);

//            BizLog bizLog = new BizLog();
//            bizLog.setOperateDescribe(e.getMessage());
//            bizLog.setOperateResult(Response.FAIL);
//            processError(request, bizLog, e);

            throw new RuntimeException("业务操作发生错误", e);
        }
        return bizContext.getResultVO();
    }

    //-----------------------------------待实现方法--------------------------------

    // 封装对象
    public abstract R packageDO(T t, Map<String, Object> tranferObj);
    //

    // 检查权限
    public abstract void checkRight(R r, Map<String, Object> tranferObj);

    // 校验数据
    public abstract void validateData(R r, Map<String, Object> tranferObj);

    // 外部数据补全

    // 检查业务依赖关系
    public abstract void dealBizRelationShip(R r, Map<String, Object> tranferObj);

    // 业务处理(数据持久)
    public abstract void dealBiz(R r, Map<String, Object> tranferObj);

    // 记录日志
    public abstract void doLog(R r, Map<String, Object> tranferObj);

    // 发布
    public abstract void doPublish(R r, Map<String, Object> tranferObj);


    //---------------------------默认方法-----------------------------

    /**
     * 默认发布
     *
     * @param publishContent
     */
//    public void publish(PublishContent publishContent) {
//        IssueTypeEntry issueTypeEntry = new IssueTypeEntry();
//        issueTypeEntry.setUtaFolowno(publishContent.getFlowNo());
//        issueTypeEntry.setIssueType(DEPUTYACCOUNTTYPE.getValue());
//        issueTypeEntry.setLoginName(publishContent.getLoginName());
//        issueProducer.issueExecute(issueTypeEntry);
//    }

    /**
     * 记录日志
     *
     * @param operator
     * @param logInfo
     */
//    public void doBizLog(Operator operator, BizLog logInfo) {
//        try {
//            logInfo.setOperateIp(operator.getOperatorIP());
//            AdminToRole adminToRole = new AdminToRole();
//            adminToRole.setUniqueid(operator.getOperatorId());
//            AdminRole adminRole = roleDAO.queryAdminRoleForUid(adminToRole);
//            if (adminRole.getRoleCode() == 6) {
//                // 操作者名称
//                logInfo.setOperatorName(operator.getOperatorName());
//            } else {
//                // 操作者名称
//                logInfo.setOperatorName("用户管理员");
//            }
//            logInfo.setOperatorUniqueid(operator.getOperatorId());
//            //操作时间
//            logInfo.setOperateTime(new Date());
//            //使用mq记录日志
//            doLogProducer.doBizLog(logInfo);
//        } catch (Exception e) {
//            logger.error(resourceBundle.getString("CONFIG_LOG_ERROR"), e);
//        }
//    }

    /**
     * 处理异常：记录日志文件，记录业务日志，封装IDMException
     *
     * @param prRequest
     * @param e
     * @return
     */
//    public IDMException processError(Request prRequest, BizLog bizLog, Throwable e) {
//        Response response = new Response();
//        if (e instanceof IDMException) {
//            IDMException idmEx = (IDMException) e;
//            logger.error(MessageFormat.format("{0}({1}), {2}", prRequest.getBusinessDescribe(), prRequest.getBusinessType(), idmEx.getL10NMessage()));
//            if (idmEx.getOriginalException() != null) {
//                logger.error("", idmEx.getOriginalException());
//            }
//            logger.error("", idmEx);
//            response.setErrorCode(idmEx.getMessageKey());
//            response.setErrorMsg(idmEx.getL10NMessage());
//        } else {
//            logger.error(MessageFormat.format(resourceBundle.getString("0.1.ERROR"), prRequest.getBusinessDescribe(), prRequest.getBusinessType()), e);
//        }
//        // 记录业务日志
//        doBizLog(prRequest.getOperator(), bizLog);
//        // 构造IDMException
//        if (e instanceof IDMException) {
//            return (IDMException) e;
//        } else {
//            return new IDMException(IDMException.SYSTEM_ERROR, null, e);
//        }
//    }

}
