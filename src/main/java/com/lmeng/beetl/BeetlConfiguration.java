package com.lmeng.beetl;

import com.lmeng.shiro.ShiroExt;
import com.lmeng.utils.KaptchaUtil;
import com.lmeng.utils.ToolUtil;
import org.beetl.core.Context;
import org.beetl.core.Function;
import org.beetl.ext.spring.BeetlGroupUtilConfiguration;

import java.io.UnsupportedEncodingException;

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
