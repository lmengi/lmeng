package com.lmeng.shiro;

import com.lmeng.utils.ToolUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;

/**
 * shiro工具类
 * @author lsk
 */
public class ShiroKit {

    /**
     * 加盐参数
     */
    public final static String hashAlgorithmName = "MD5";

    /**
     * 循环次数
     */
    public final static int hashIterations = 1024;


    /**
     * @remark 从shiro获取session
     * @function  getSession
     */
    public static Session getSession() {
        return getSubject().getSession();
    }

    /**
     * @remark 验证当前用户是否为“访客”，即未认证（包含未记住）的用户。用user搭配使用
     * @function  isGuest
     * @return 访客：true，否则false
     */
    public static boolean isGuest() {
        return !isUser();
    }

    /**
     * @remark 认证通过或已记住的用户。与guset搭配使用。
     * @function isUser
     * @return 用户：true，否则 false
     */
    public static boolean isUser() {
        return getSubject() != null && getSubject().getPrincipal() != null;
    }

    /**
     * shiro密码加密工具类
     *
     * @param credentials 密码
     * @param saltSource 密码盐
     * @return
     */
    public static String md5(String credentials, String saltSource) {
        ByteSource salt = new Md5Hash(saltSource);
        return new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations).toString();
    }

    /**
     * 获取随机盐值
     * @param length
     * @return
     */
    public static String getRandomSalt(int length) {
        return ToolUtil.getRandomString(length);
    }

    /**
     * @remark 判断当前用户是否是超级管理员
     * @function isAdmin
     */
    public static boolean isAdmin() {
//        List<Integer> roleList = ShiroKit.getUser().getRoleList();
//        for (Integer integer : roleList) {
//            String singleRoleTip = ConstantFactory.me().getSingleRoleTip(integer);
//            if (singleRoleTip.equals(Const.ADMIN_NAME)) {
//                return true;
//            }
//        }
        return false;
    }

    public static ShiroUser getUser() {
        if (isGuest()) {
            return null;
        } else {
            return (ShiroUser) getSubject().getPrincipals().getPrimaryPrincipal();
        }
    }

    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    public static boolean isAuthenticated() {
        return getSubject() != null && getSubject().isAuthenticated();
    }
}
