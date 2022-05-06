package com.test.demo.pwvalid;

import lombok.Data;

import java.util.Map;


public abstract class AbstractPWValidate implements PWValidate{

    protected Rule rule;

    public boolean validate(String pw){
        PWContext pwContext = new PWContext();
        pwContext.setPw(pw);

        preProcessor(pwContext);

        boolean valid = doProcessor(pwContext);

        postProcessor(pwContext);

        return valid;
    }

    public abstract void preProcessor(PWContext context);

    public abstract boolean doProcessor(PWContext context);

    public abstract void postProcessor(PWContext context);

    public void setRule(Rule rule){
        this.rule = rule;
    }

    @Data
    public static class PWContext{

        private String pw;

        private Map attrs;

    }
}
