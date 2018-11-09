package com.lmeng.shiro;

import com.lmeng.model.MenuModel;
import com.lmeng.pojo.Menu;

import java.io.Serializable;
import java.util.List;

public class ShiroUser implements Serializable {

    public Integer userId;          // 主键ID
    public String userName;       // 账号

    public String salt;

    public Integer roleType;      //权限类型

    public Integer roleId; // 角色

    public String roleName; // 角色

    public List<MenuModel> menus; // 角色集

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getRoleType() {
        return roleType;
    }

    public void setRoleType(Integer roleType) {
        this.roleType = roleType;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<MenuModel> getMenus() {
        return menus;
    }

    public void setMenus(List<MenuModel> menus) {
        this.menus = menus;
    }
}
