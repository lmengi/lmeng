package com.lmeng.mapper;

import com.lmeng.pojo.Adminuser;

import java.util.List;

public interface AdminUserMapperCustom {
    List<Adminuser> queryAdminUserSimplyInfoByName(String userName);
}