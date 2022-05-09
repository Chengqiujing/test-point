package com.test.demo.pwvalid.impl;

import com.test.demo.pwvalid.AbstractPWValidate;
import com.test.demo.pwvalid.Rule;


public class DefaultPWValidate extends AbstractPWValidate {

    @Override
    public boolean validate(String pw) {
        return rule.valid(pw);
    }

//    @Override
//    public void preProcessor(AbstractPWValidate.PWContext context) {
//        // todo  前置处理：密码解密
//    }

    @Override
    public boolean doProcessor(AbstractPWValidate.PWContext context) {
        return rule.valid(context.getPw());
    }

//    @Override
//    public void postProcessor(AbstractPWValidate.PWContext context) {
//        // todo 后置处理
//    }

    @Override
    public void setRule(Rule rule) {
        super.setRule(new DefaultRule());
    }
}
