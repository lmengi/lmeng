package com.lmeng.shiro;

import com.lmeng.model.MenuModel;
import com.lmeng.pojo.User;
import com.lmeng.component.SpringContextComponent;
import com.lmeng.enums.AdminUserStatusEnum;
import com.lmeng.enums.RoleTypeEnum;
import com.lmeng.enums.UserStatusEnum;
import com.lmeng.pojo.Adminuser;
import com.lmeng.pojo.Menu;
import com.lmeng.pojo.Role;
import com.lmeng.pojo.User;
import com.lmeng.service.IAdminUserService;
import com.lmeng.service.IMenuService;
import com.lmeng.service.IRoleService;
import com.lmeng.service.IUserService;
import org.apache.shiro.authc.CredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.util.ByteSource;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
//@DependsOn("SpringContextComponent")
//@Transactional(readOnly = true)
public class ShiroFactroy implements IShiro{

    public static IShiro me() {
        return SpringContextComponent.getBean(IShiro.class);
    }

    @Resource
    private IUserService iUserService;

    @Resource
    private IAdminUserService iAdminUserService;

    @Resource
    private IRoleService iRoleService;

    @Resource
    private IMenuService iMenuService;

    @Override
    public User user(String userName) {

        User user = iUserService.queryUserByNameCustom(userName);

        // 账号不存在
        if (null == user) {
            throw new CredentialsException();
        }
        // 账号被冻结
        if (user.getStatusid() == UserStatusEnum.FREEZED.getCode()) {
            throw new LockedAccountException();
        }
        return user;
    }

    @Override
    public Adminuser adminUser(String userName) {
        Adminuser user = iAdminUserService.queryAdminUserByNameCustom(userName);

        // 账号不存在
        if (null == user) {
            throw new CredentialsException();
        }
        // 账号被冻结
        if (user.getStatusid() == AdminUserStatusEnum.FREEZED.getCode()) {
            throw new LockedAccountException();
        }
        return user;
    }

    @Override
    public SimpleAuthenticationInfo info(ShiroUser shiroUser, Adminuser user,  String realmName) {
        String credentials = user.getPassword();

        // 密码加盐处理
        String source = user.getSalt();
        ByteSource credentialsSalt = new Md5Hash(source);
        return new SimpleAuthenticationInfo(shiroUser, credentials, credentialsSalt, realmName);
    }

    @Override
    public ShiroUser shiroUser(User user) {
        ShiroUser shiroUser = new ShiroUser();
        shiroUser.setUserId(user.getUserId());
        shiroUser.setSalt(user.getSalt());
        shiroUser.setUserName(user.getName());

        shiroUser.setRoleType(RoleTypeEnum.USER.getCode());
        return shiroUser;
    }

    @Override
    public ShiroUser shiroAdminUser(Adminuser adminuser) {
        ShiroUser shiroUser = new ShiroUser();
        shiroUser.setUserId(adminuser.getAdminuserid());
        shiroUser.setSalt(adminuser.getSalt());
        shiroUser.setUserName(adminuser.getUsername());
        shiroUser.setRoleType(RoleTypeEnum.ADMIN.getCode());
        shiroUser.setRoleId(adminuser.getRoleid());
        Role role = iRoleService.getRoleById(adminuser.getRoleid());
        if (role != null) {
            List<Menu> menus = iMenuService.getMenusByKeys(role.getMenus());
            List<MenuModel> menuModels = new ArrayList<MenuModel>();
            for (Menu menu : menus)
            {
                MenuModel menuModel = new MenuModel();
                menuModel.setId(menu.getMenuId());
                menuModel.setName(menu.getMenuname());
                menuModel.setParentId(menu.getParentid());
                menuModel.setUrl(menu.getMenulink());
                menuModels.add(menuModel);
            }
            shiroUser.setMenus(menuModels);
            shiroUser.setRoleName(role.getRolename());
        }
        return  shiroUser;
    }

    @Override
    public List<String> findPermissionsByRoleId(Integer roleId) {
        List<String> menuNames = new ArrayList<String>();
        Role role = iRoleService.getRoleById(roleId);
        if (role != null) {
            List<Menu> menus = iMenuService.getMenusByKeys(role.getMenus());
            for (Menu m: menus){
                menuNames.add(m.getMenuname());
            }
        }
        return menuNames;
    }

    @Override
    public String findRoleNameByRoleId(Integer roleId) {
        Role role = iRoleService.getRoleById(roleId);
        if (role != null)
            return role.getRolename();
        return new String();
    }
}
