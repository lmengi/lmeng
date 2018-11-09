package com.lmeng.utils;

import com.lmeng.component.SpringContextComponent;
import com.lmeng.properties.LmengProperties;

/**
 * 验证码工具类
 */
public class KaptchaUtil {

    public static Boolean getKaptchaOnOff() {
        boolean t = SpringContextComponent.getBean(LmengProperties.class).getKaptchaOpen();
        return t;
    }
}