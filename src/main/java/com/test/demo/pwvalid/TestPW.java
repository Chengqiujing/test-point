package com.test.demo.pwvalid;

import com.test.demo.pwvalid.impl.DefaultPWValidate;


public class TestPW {

    public static void main(String[] args) {
        String pw = "123123";

        PWValidate pwValidate = new DefaultPWValidate();

        boolean validate = pwValidate.validate(pw);

        System.out.println(validate);



        // 自定义逻辑规则

        Rule rule = RuleContainer.init(new RuleA()).and(new RuleB()).or(new RuleC()).toRule();
        ((AbstractPWValidate)pwValidate).setRule(rule);
        System.out.println(pwValidate.validate(pw));
    }


    static class RuleA implements Rule{

        @Override
        public boolean valid(String pw) {
            return false;
        }
    }

    static class RuleB implements Rule{

        @Override
        public boolean valid(String pw) {
            return false;
        }
    }

    static class RuleC implements Rule{

        @Override
        public boolean valid(String pw) {
            return false;
        }
    }
}
