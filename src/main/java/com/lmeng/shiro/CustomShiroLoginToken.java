package com.lmeng.shiro;

import org.apache.shiro.authc.UsernamePasswordToken;

public class CustomShiroLoginToken extends UsernamePasswordToken {

    public CustomShiroLoginToken(final String username, final String password,
                                 final Integer roleType) {
        super(username, password);
        this.roleType = roleType;
    }

    private Integer roleType;

    public Integer getRoleType() {
        return roleType;
    }

    public void setRoleType(Integer roleType) {
        this.roleType = roleType;
    }
}
