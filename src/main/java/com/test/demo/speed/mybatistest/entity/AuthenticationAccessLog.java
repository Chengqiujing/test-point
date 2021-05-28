package com.test.demo.speed.mybatistest.entity;


import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AuthenticationAccessLog implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column authentication_access_log.ID
     *
     * @mbggenerated Fri Aug 24 17:41:23 CST 2018
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column authentication_access_log.LOGIN_DN
     *
     * @mbggenerated Fri Aug 24 17:41:23 CST 2018
     */
    private String loginDn;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column authentication_access_log.USER_NAME
     *
     * @mbggenerated Fri Aug 24 17:41:23 CST 2018
     */
    private String userName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column authentication_access_log.NAME_ID
     *
     * @mbggenerated Fri Aug 24 17:41:23 CST 2018
     */
    private String nameId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column authentication_access_log.LOGGED_BY
     *
     * @mbggenerated Fri Aug 24 17:41:23 CST 2018
     */
    private String loggedBy;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column authentication_access_log.USER_ID
     *
     * @mbggenerated Fri Aug 24 17:41:23 CST 2018
     */
    private String userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column authentication_access_log.MESSAGE
     *
     * @mbggenerated Fri Aug 24 17:41:23 CST 2018
     */
    private String message;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column authentication_access_log.IP_ADDRESS
     *
     * @mbggenerated Fri Aug 24 17:41:23 CST 2018
     */
    private String ipAddress;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column authentication_access_log.CONTENT
     *
     * @mbggenerated Fri Aug 24 17:41:23 CST 2018
     */
    private String content;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column authentication_access_log.ORG_ID
     *
     * @mbggenerated Fri Aug 24 17:41:23 CST 2018
     */
    private String orgId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column authentication_access_log.ORG_NAME
     *
     * @mbggenerated Fri Aug 24 17:41:23 CST 2018
     */
    private String orgName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column authentication_access_log.LOG_TYPE
     *
     * @mbggenerated Fri Aug 24 17:41:23 CST 2018
     */
    private Integer logType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column authentication_access_log.CLIENT_TYPE
     *
     * @mbggenerated Fri Aug 24 17:41:23 CST 2018
     */
    private String clientType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column authentication_access_log.OPT_TIME
     *
     * @mbggenerated Fri Aug 24 17:41:23 CST 2018
     */
//    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date optTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column authentication_access_log.MODULE_NAME
     *
     * @mbggenerated Fri Aug 24 17:41:23 CST 2018
     */
    private String moduleName;

    private String tenantId;

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table authentication_access_log
     *
     * @mbggenerated Fri Aug 24 17:41:23 CST 2018
     */
    private static final long serialVersionUID = 1L;


    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column authentication_access_log.ID
     *
     * @return the value of authentication_access_log.ID
     * @mbggenerated Fri Aug 24 17:41:23 CST 2018
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column authentication_access_log.ID
     *
     * @param id the value for authentication_access_log.ID
     * @mbggenerated Fri Aug 24 17:41:23 CST 2018
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column authentication_access_log.LOGIN_DN
     *
     * @return the value of authentication_access_log.LOGIN_DN
     * @mbggenerated Fri Aug 24 17:41:23 CST 2018
     */
    public String getLoginDn() {
        return loginDn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column authentication_access_log.LOGIN_DN
     *
     * @param loginDn the value for authentication_access_log.LOGIN_DN
     * @mbggenerated Fri Aug 24 17:41:23 CST 2018
     */
    public void setLoginDn(String loginDn) {
        this.loginDn = loginDn == null ? null : loginDn.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column authentication_access_log.USER_NAME
     *
     * @return the value of authentication_access_log.USER_NAME
     * @mbggenerated Fri Aug 24 17:41:23 CST 2018
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column authentication_access_log.USER_NAME
     *
     * @param userName the value for authentication_access_log.USER_NAME
     * @mbggenerated Fri Aug 24 17:41:23 CST 2018
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column authentication_access_log.NAME_ID
     *
     * @return the value of authentication_access_log.NAME_ID
     * @mbggenerated Fri Aug 24 17:41:23 CST 2018
     */
    public String getNameId() {
        return nameId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column authentication_access_log.NAME_ID
     *
     * @param nameId the value for authentication_access_log.NAME_ID
     * @mbggenerated Fri Aug 24 17:41:23 CST 2018
     */
    public void setNameId(String nameId) {
        this.nameId = nameId == null ? null : nameId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column authentication_access_log.LOGGED_BY
     *
     * @return the value of authentication_access_log.LOGGED_BY
     * @mbggenerated Fri Aug 24 17:41:23 CST 2018
     */
    public String getLoggedBy() {
        return loggedBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column authentication_access_log.LOGGED_BY
     *
     * @param loggedBy the value for authentication_access_log.LOGGED_BY
     * @mbggenerated Fri Aug 24 17:41:23 CST 2018
     */
    public void setLoggedBy(String loggedBy) {
        this.loggedBy = loggedBy == null ? null : loggedBy.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column authentication_access_log.USER_ID
     *
     * @return the value of authentication_access_log.USER_ID
     * @mbggenerated Fri Aug 24 17:41:23 CST 2018
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column authentication_access_log.USER_ID
     *
     * @param userId the value for authentication_access_log.USER_ID
     * @mbggenerated Fri Aug 24 17:41:23 CST 2018
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column authentication_access_log.MESSAGE
     *
     * @return the value of authentication_access_log.MESSAGE
     * @mbggenerated Fri Aug 24 17:41:23 CST 2018
     */
    public String getMessage() {
        return message;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column authentication_access_log.MESSAGE
     *
     * @param message the value for authentication_access_log.MESSAGE
     * @mbggenerated Fri Aug 24 17:41:23 CST 2018
     */
    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column authentication_access_log.IP_ADDRESS
     *
     * @return the value of authentication_access_log.IP_ADDRESS
     * @mbggenerated Fri Aug 24 17:41:23 CST 2018
     */
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column authentication_access_log.IP_ADDRESS
     *
     * @param ipAddress the value for authentication_access_log.IP_ADDRESS
     * @mbggenerated Fri Aug 24 17:41:23 CST 2018
     */
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress == null ? null : ipAddress.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column authentication_access_log.CONTENT
     *
     * @return the value of authentication_access_log.CONTENT
     * @mbggenerated Fri Aug 24 17:41:23 CST 2018
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column authentication_access_log.CONTENT
     *
     * @param content the value for authentication_access_log.CONTENT
     * @mbggenerated Fri Aug 24 17:41:23 CST 2018
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column authentication_access_log.ORG_ID
     *
     * @return the value of authentication_access_log.ORG_ID
     * @mbggenerated Fri Aug 24 17:41:23 CST 2018
     */
    public String getOrgId() {
        return orgId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column authentication_access_log.ORG_ID
     *
     * @param orgId the value for authentication_access_log.ORG_ID
     * @mbggenerated Fri Aug 24 17:41:23 CST 2018
     */
    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column authentication_access_log.ORG_NAME
     *
     * @return the value of authentication_access_log.ORG_NAME
     * @mbggenerated Fri Aug 24 17:41:23 CST 2018
     */
    public String getOrgName() {
        return orgName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column authentication_access_log.ORG_NAME
     *
     * @param orgName the value for authentication_access_log.ORG_NAME
     * @mbggenerated Fri Aug 24 17:41:23 CST 2018
     */
    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column authentication_access_log.LOG_TYPE
     *
     * @return the value of authentication_access_log.LOG_TYPE
     * @mbggenerated Fri Aug 24 17:41:23 CST 2018
     */
    public Integer getLogType() {
        return logType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column authentication_access_log.LOG_TYPE
     *
     * @param logType the value for authentication_access_log.LOG_TYPE
     * @mbggenerated Fri Aug 24 17:41:23 CST 2018
     */
    public void setLogType(Integer logType) {
        this.logType = logType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column authentication_access_log.CLIENT_TYPE
     *
     * @return the value of authentication_access_log.CLIENT_TYPE
     * @mbggenerated Fri Aug 24 17:41:23 CST 2018
     */
    public String getClientType() {
        return clientType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column authentication_access_log.CLIENT_TYPE
     *
     * @param clientType the value for authentication_access_log.CLIENT_TYPE
     * @mbggenerated Fri Aug 24 17:41:23 CST 2018
     */
    public void setClientType(String clientType) {
        this.clientType = clientType == null ? null : clientType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column authentication_access_log.OPT_TIME
     *
     * @return the value of authentication_access_log.OPT_TIME
     * @mbggenerated Fri Aug 24 17:41:23 CST 2018
     */
    public Date getOptTime() {
        return optTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column authentication_access_log.OPT_TIME
     *
     * @param optTime the value for authentication_access_log.OPT_TIME
     * @mbggenerated Fri Aug 24 17:41:23 CST 2018
     */
    public void setOptTime(Date optTime) {
        this.optTime = optTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column authentication_access_log.MODULE_NAME
     *
     * @return the value of authentication_access_log.MODULE_NAME
     * @mbggenerated Fri Aug 24 17:41:23 CST 2018
     */
    public String getModuleName() {
        return moduleName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column authentication_access_log.MODULE_NAME
     *
     * @param moduleName the value for authentication_access_log.MODULE_NAME
     * @mbggenerated Fri Aug 24 17:41:23 CST 2018
     */
    public void setModuleName(String moduleName) {
        this.moduleName = moduleName == null ? null : moduleName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table authentication_access_log
     *
     * @mbggenerated Fri Aug 24 17:41:23 CST 2018
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", loginDn=").append(loginDn);
        sb.append(", userName=").append(userName);
        sb.append(", nameId=").append(nameId);
        sb.append(", loggedBy=").append(loggedBy);
        sb.append(", userId=").append(userId);
        sb.append(", message=").append(message);
        sb.append(", ipAddress=").append(ipAddress);
        sb.append(", content=").append(content);
        sb.append(", orgId=").append(orgId);
        sb.append(", orgName=").append(orgName);
        sb.append(", logType=").append(logType);
        sb.append(", clientType=").append(clientType);
        sb.append(", optTime=").append(optTime);
        sb.append(", moduleName=").append(moduleName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", tenantId=").append(tenantId);
        sb.append("]");
        return sb.toString();
    }

    public String toInsertSql() {
        StringBuilder sb = new StringBuilder();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sb.append("insert into authentication_access_log values (")
                .append("'").append(id).append("'").append(",")
                .append("'").append(loginDn).append("'").append(",")
                .append("'").append(userName).append("'").append(",")
                .append("'").append(nameId).append("'").append(",")
                .append("'").append(loggedBy).append("'").append(",")
                .append("'").append(userId).append("'").append(",")
                .append("'").append(message).append("'").append(",")
                .append("'").append(ipAddress).append("'").append(",")
                .append("'").append(content).append("'").append(",")
                .append("'").append(orgId).append("'").append(",")
                .append("'").append(orgName).append("'").append(",")
                .append("'").append(logType).append("'").append(",")
                .append("'").append(clientType).append("'").append(",")
                .append("'").append(sdf.format(optTime)).append("'").append(",")
                .append("'").append(moduleName).append("'").append(",")
                .append("'").append(tenantId).append("'").append(")")
                .toString();
    }

    public String toUpdateSql() {
        StringBuilder sb = new StringBuilder();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sb.append("update authentication_access_log set ")
                .append("ID = ").append("'").append(id).append("'").append(",")
                .append("LOGIN_DN = ").append("'").append(loginDn).append("'").append(",")
                .append("USER_NAME = ").append("'").append(userName).append("'").append(",")
                .append("NAME_ID = ").append("'").append(nameId).append("'").append(",")
                .append("LOGGED_BY = ").append("'").append(loggedBy).append("'").append(",")
                .append("USER_ID = ").append("'").append(userId).append("'").append(",")
                .append("MESSAGE = ").append("'").append(message).append("'").append(",")
                .append("IP_ADDRESS = ").append("'").append(ipAddress).append("'").append(",")
                .append("CONTENT = ").append("'").append(content).append("'").append(",")
                .append("ORG_ID = ").append("'").append(orgId).append("'").append(",")
                .append("ORG_NAME = ").append("'").append(orgName).append("'").append(",")
                .append("LOG_TYPE = ").append("'").append(logType).append("'").append(",")
                .append("CLIENT_TYPE = ").append("'").append(clientType).append("'").append(",")
                .append("OPT_TIME = ").append("'").append(sdf.format(optTime)).append("'").append(",")
                .append("MODULE_NAME = ").append("'").append(moduleName).append("'").append(",")
                .append("TENANT_ID = ").append("'").append(tenantId).append("'")
                .append("where id = '").append(id).append("'")
                .toString();
    }

    public String sqlValues() {
        StringBuilder sb = new StringBuilder();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sb.append("(")
                .append("'").append(id).append("'").append(",")
                .append("'").append(loginDn).append("'").append(",")
                .append("'").append(userName).append("'").append(",")
                .append("'").append(nameId).append("'").append(",")
                .append("'").append(loggedBy).append("'").append(",")
                .append("'").append(userId).append("'").append(",")
                .append("'").append(message).append("'").append(",")
                .append("'").append(ipAddress).append("'").append(",")
                .append("'").append(content).append("'").append(",")
                .append("'").append(orgId).append("'").append(",")
                .append("'").append(orgName).append("'").append(",")
                .append("'").append(logType).append("'").append(",")
                .append("'").append(clientType).append("'").append(",")
                .append("'").append(sdf.format(optTime)).append("'").append(",")
                .append("'").append(moduleName).append("'").append(",")
                .append("'").append(tenantId).append("'").append(")")
                .toString();
    }
}