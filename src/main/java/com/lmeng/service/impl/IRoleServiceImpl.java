package com.lmeng.service.impl;

import com.lmeng.mapper.RoleMapper;
import com.lmeng.pojo.Role;
import com.lmeng.service.IRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class IRoleServiceImpl implements IRoleService {

    @Resource
    private RoleMapper roleMapper;
    @Override
    public Role getRoleById(Integer roleId) {
        return roleMapper.selectByPrimaryKey(roleId);
    }
}
