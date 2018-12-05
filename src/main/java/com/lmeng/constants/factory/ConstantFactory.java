package com.lmeng.constants.factory;

import com.lmeng.component.SpringContextComponent;
import com.lmeng.pojo.Role;
import com.lmeng.service.IRoleService;
import com.lmeng.utils.ToolUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
public class ConstantFactory implements IConstantFactory{


    public static IConstantFactory me() {
        return SpringContextComponent.getBean("constantFactory");
    }

    @Autowired
    private IRoleService roleService;


    @Override
    public String getUserNameById(Integer userId) {
        return null;
    }

    @Override
    public String getRoleName(String roleIds) {
        return null;
    }

    @Override
    public String getSingleRoleName(Integer roleId) {
        if (0 == roleId) {
            return "--";
        }
        Role roleObj = roleService.getRoleById(roleId);
        if (ToolUtil.isNotEmpty(roleObj) && ToolUtil.isNotEmpty(roleObj.getRolename())) {
            return roleObj.getRolename();
        }
        return "";
    }

    @Override
    public String getMenuNames(String menuIds) {
        return null;
    }

    @Override
    public String getMenuName(Long menuId) {
        return null;
    }

    @Override
    public String getMenuNameByCode(String code) {
        return null;
    }

    @Override
    public String getSexName(Integer sex) {
        return null;
    }

    @Override
    public String getStatusName(Integer status) {
        return null;
    }

    @Override
    public String getCacheObject(String para) {
        return null;
    }
}
