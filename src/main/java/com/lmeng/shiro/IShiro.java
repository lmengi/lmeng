package com.lmeng.shiro;


import com.lmeng.pojo.User;
import com.lmeng.pojo.Adminuser;
import com.lmeng.pojo.User;
import org.apache.shiro.authc.SimpleAuthenticationInfo;

import java.util.List;

public interface IShiro {

    /**
     * @remark 根据账号获取登录用户
     * @param userName 账号
     * @return User
     */
    User user(String userName);

    /**
     * @remark 根据账号获取管理员
     * @param userName 账号
     * @return Adminuser
     */
    Adminuser adminUser(String userName);

    /**
     * @remark 根据账号获取管理员
     * @param shiroUser 账号信息
     * @return SimpleAuthenticationInfo
     */
    public SimpleAuthenticationInfo info(ShiroUser shiroUser, Adminuser user, String realmName);

    /**
     * @remark 生成统一的账户信息
     * @param user 账号信息
     * @return shiroUser
     */
    public ShiroUser shiroUser(User user);

    /**
     * @remark 生成统一的账户信息
     * @param adminuser 账号信息
     * @return ShiroUser
     */
    public ShiroUser shiroAdminUser(Adminuser adminuser);

    /**
     * 获取权限列表通过角色id
     *
     * @param roleId 角色id
     */
    List<String> findPermissionsByRoleId(Integer roleId);

    /**
     * 根据角色id获取角色名称
     *
     * @param roleId 角色id
     */
    String findRoleNameByRoleId(Integer roleId);
}
