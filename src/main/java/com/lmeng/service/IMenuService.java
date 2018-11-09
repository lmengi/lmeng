package com.lmeng.service;

import com.lmeng.pojo.Menu;

import java.util.List;

public interface IMenuService {

    List<Menu> getMenusByKeys(String menuIds);
}
