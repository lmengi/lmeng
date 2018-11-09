package com.lmeng.service;

import com.lmeng.pojo.Adminuser;

import java.util.List;

public interface IAdminUserService {
    public Adminuser queryAdminUserByNameCustom(String UserName);

    public void saveAdminUser(Adminuser user) throws Exception;

    public void updateAdminUser(Adminuser user);

    public void deleteAdminUser(Integer userId);

    public Adminuser queryUserById(Integer userId);

    public List<Adminuser> queryUserList(Adminuser user);
}
