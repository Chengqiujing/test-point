package com.test.demo.pwvalid;

/**
 * @author：chengqj
 * @createDate：2022/5/9 9:39
 * ©北京数字认证股份有限公司 2022
 * @description:
 */
public interface PWFilter {

    public boolean doProcess(AbstractPWValidate.PWProcess pwProcess);
}
