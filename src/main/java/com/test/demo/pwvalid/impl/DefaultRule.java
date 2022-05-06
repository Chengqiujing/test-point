package com.test.demo.pwvalid.impl;

import com.test.demo.pwvalid.Rule;
import com.test.demo.pwvalid.config.AccessConfig;
import com.test.demo.pwvalid.config.impl.DefaultAccessConfig;


public class DefaultRule implements Rule {

    private static AccessConfig config;

    static {
        config = new DefaultAccessConfig();
    }

    @Override
    public boolean valid(String pw) {

        return isMatchStand(pw)
                && isContainSpecificSymbol(pw)
                && isContainWord(pw);
    }


    public boolean isContainWord(String pw){
        if(config.getConfig().isWord()){

            // todo 包含字符
        }

        return true;
    }

    public boolean isContainSpecificSymbol(String pw){
        if (config.getConfig().isSpecilSymbol()) {

            // todo 包含字符
        }

        return true;
    }

    public boolean isMatchStand(String pw){
        if(config.getConfig().getLength() != 0){

            // todo 长度校验
        }

        return true;
    }



}
