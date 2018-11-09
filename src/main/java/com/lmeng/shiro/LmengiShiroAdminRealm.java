package com.lmeng.shiro;

import com.lmeng.pojo.Adminuser;
import com.lmeng.utils.ToolUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LmengiShiroAdminRealm extends AuthorizingRealm {

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        IShiro shiroFactory = ShiroFactroy.me();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        ShiroUser shiroUser = (ShiroUser) principalCollection.getPrimaryPrincipal();
        Set<String> permissionSet = new HashSet<>();
        if (shiroUser == null)
            return authorizationInfo;

        List<String> permissions = shiroFactory.findPermissionsByRoleId(shiroUser.getRoleId());
        for (String permission : permissions) {
            if (ToolUtil.isNotEmpty(permission)) {
                permissionSet.add(permission);
            }
        }
        String roleName = shiroFactory.findRoleNameByRoleId(shiroUser.getRoleId());
        authorizationInfo.setStringPermissions(permissionSet);
        authorizationInfo.addRole(roleName);
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        IShiro shiroFactory = ShiroFactroy.me();
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        Adminuser user = shiroFactory.adminUser(token.getUsername());
        ShiroUser shiroUser = shiroFactory.shiroAdminUser(user);
        return shiroFactory.info(shiroUser, user, super.getName());
    }
}
