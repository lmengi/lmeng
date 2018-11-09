package com.lmeng.shiro;

import com.lmeng.pojo.User;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;


public class LmengiShiroRealm extends AuthorizingRealm {

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //TODO 暂无权限认证
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//        IShiro shiroFactory = ShiroFactroy.me();
//        CustomShiroLoginToken token = (CustomShiroLoginToken) authenticationToken;
//        User user = shiroFactory.user(token.getUsername());
//        ShiroUser shiroUser = shiroFactory.shiroUser(user);
//        return shiroFactory.info(shiroUser, super.getName());
        return null;
    }

}
