package com.test.demo.template.service;

import com.test.demo.template.common.BaseBusinessTemplate;
import com.test.demo.template.entity.User;
import com.test.demo.template.entity.UserInfo;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * *************************************************************************
 * <p/>
 *
 * @文件名称: UserService.java
 * @包 路 径： com.test.demo.template.service
 * @版权所有：北京数字认证股份有限公司 (C) 2021
 * @类描述:
 * @版本: V1.0
 * @author：chengqj
 * @创建时间：2021/4/23 11:00
 */
@Service
public class UserService extends BaseBusinessTemplate<User, UserInfo> {
    @Override
    public UserInfo packageDO(User a, Map<String, Object> tranferObj) {
        return null;
    }

    @Override
    public void checkRight(UserInfo userInfo, Map<String, Object> tranferObj) {

    }

    @Override
    public void validateData(UserInfo t, Map<String, Object> tranferObj) {

    }

    @Override
    public void dealBizRelationShip(UserInfo t, Map<String, Object> tranferObj) {

    }

    @Override
    public void dealBiz(UserInfo t, Map<String, Object> tranferObj) {

    }

    @Override
    public void doLog(UserInfo t, Map<String, Object> tranferObj) {

    }

    @Override
    public void doPublish(UserInfo t, Map<String, Object> tranferObj) {

    }
}
