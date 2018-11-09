package com.lmeng.service.impl;

import com.lmeng.mapper.AdminUserMapperCustom;
import com.lmeng.mapper.AdminuserMapper;
import com.lmeng.pojo.Adminuser;
import com.lmeng.service.IAdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IAdminUserServiceImpl implements IAdminUserService {

    @Autowired
    private AdminUserMapperCustom adminUserMapperCustom;

    @Autowired
    private AdminuserMapper adminuserMapper;

    @Override
    public Adminuser queryAdminUserByNameCustom(String UserName) {
        List<Adminuser> userList = adminUserMapperCustom.queryAdminUserSimplyInfoByName(UserName);

        if (userList != null && !userList.isEmpty()) {
            return (Adminuser)userList.get(0);
        }
        return null;
    }

    @Override
    public void saveAdminUser(Adminuser user) throws Exception {
        adminuserMapper.insert(user);
    }

    @Override
    public void updateAdminUser(Adminuser user) {
        adminuserMapper.updateByPrimaryKey(user);
    }

    @Override
    public void deleteAdminUser(Integer userId) {
        adminuserMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public Adminuser queryUserById(Integer userId) {
        return adminuserMapper.selectByPrimaryKey(userId);
    }

    @Override
    public List<Adminuser> queryUserList(Adminuser user) {
        return null;
    }

}
