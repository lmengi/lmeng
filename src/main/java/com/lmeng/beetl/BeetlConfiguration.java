package com.lmeng.beetl;

import com.lmeng.shiro.ShiroExt;
import com.lmeng.utils.KaptchaUtil;
import com.lmeng.utils.ToolUtil;
import org.beetl.ext.spring.BeetlGroupUtilConfiguration;

/**
 * @remark beetl 扩展配置
 * @author 508816
 */
public class BeetlConfiguration extends BeetlGroupUtilConfiguration {

    @Override
    public void initOther() {
        groupTemplate.registerFunctionPackage("tool", new ToolUtil());
        groupTemplate.registerFunctionPackage("shiro", new ShiroExt());
        groupTemplate.registerFunctionPackage("kaptcha", new KaptchaUtil());
    }


}
