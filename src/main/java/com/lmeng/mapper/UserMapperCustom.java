package com.lmeng.mapper;

import com.lmeng.pojo.User;

import java.util.List;

public interface UserMapperCustom {
    List<User> queryUserSimplyInfoByName(String userName);
}