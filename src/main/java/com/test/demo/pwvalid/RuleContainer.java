package com.test.demo.pwvalid;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class RuleContainer {
    private final static String AND = "and";
    private final static String OR = "or";

    public static MidProcess init(Rule rule){
        MidProcess midProcess = new MidProcess(rule);
        return midProcess;
    }


    public final static class MidProcess{
        private List processList = new ArrayList();

        public MidProcess(Rule rule) {
            processList.add(rule);
        }

        public MidProcess and(Rule rule){

            processList.add(AND);
            processList.add(rule);

            return this;
        }

        public MidProcess or(Rule rule){

            processList.add(OR);
            processList.add(rule);

            return this;
        }

        public Rule toRule(){

            return new Rule() {
                @Override
                public boolean valid(String pw) {
                    boolean result = false;
                    Iterator iterator = processList.iterator();

                    while(iterator.hasNext()){
                        Object o = iterator.next();
                        if(o instanceof Rule){
                            result = ((Rule)o).valid(pw);
                        }else if(o.equals(AND)){
                            result &= ((Rule)iterator.next()).valid(pw);
                        }else if(o.equals(OR)){
                            result |= ((Rule)iterator.next()).valid(pw);
                        }
                    }

                    return result;
                }
            };
        }
    }


}
