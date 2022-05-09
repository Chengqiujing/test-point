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
        ((AbstractPWValidate)pwValidate).setPwFilter(new SlefFilter());
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

    static class SlefFilter implements PWFilter{

        @Override
        public boolean doProcess(AbstractPWValidate.PWProcess pwProcess) {
            // todo 处理密码加密

            boolean b = pwProcess.doProcess();

            // todo 后置处理

            return b;
        }
    }

}
