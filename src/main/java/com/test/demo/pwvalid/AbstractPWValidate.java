package com.test.demo.pwvalid;

import lombok.Data;

import java.util.Map;


public abstract class AbstractPWValidate implements PWValidate {

    protected Rule rule;

    private PWFilter pwFilter;

    public boolean validate(String pw) {
        PWContext pwContext = new PWContext();
        pwContext.setPw(pw);

        if (pwFilter == null) {
            return doProcessor(pwContext);
        }

        return pwFilter.doProcess(new PWProcess(this, pwContext));
    }

    public abstract boolean doProcessor(PWContext context);

    public void setRule(Rule rule) {
        this.rule = rule;
    }

    public void setPwFilter(PWFilter pwFilter) {
        this.pwFilter = pwFilter;
    }

    @Data
    public static class PWContext {

        private String pw;

        private Map attrs;

    }

    public static final class PWProcess {
        private PWValidate pwValidate;
        private PWContext pwContext;

        public PWProcess(PWValidate pwValidate, PWContext pwContext) {
            this.pwValidate = pwValidate;
            this.pwContext = pwContext;
        }

        public boolean doProcess(){
            return pwValidate.validate(pwContext.getPw());
        }

        public PWContext getPwContext() {
            return pwContext;
        }
    }
}
