package com.test.demo.template.service;

import com.test.demo.template.common.BaseBusinessTemplate;
import com.test.demo.template.entity.User;
import com.test.demo.template.entity.UserInfo;
import org.springframework.stereotype.Service;

import java.util.Map;


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
