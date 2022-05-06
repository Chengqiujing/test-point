package com.test.demo.pwvalid.config.impl;

import com.test.demo.pwvalid.config.AccessConfig;
import com.test.demo.pwvalid.config.PWConfig;

import java.util.ResourceBundle;


public class DefaultAccessConfig implements AccessConfig {
    @Override
    public PWConfig getConfig() {
        // 从配置文件读取 或者 从数据库读取
        ResourceBundle resourceBundle = ResourceBundle.getBundle("pwConfig");

        PWConfig pwConfig = new PWConfig();
        pwConfig.setWord(true);
        pwConfig.setSpecilSymbol(true);
        pwConfig.setLength(10);
        return pwConfig;
    }
}
