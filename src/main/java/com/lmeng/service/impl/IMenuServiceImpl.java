package com.lmeng.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.lmeng.mapper.MenuMapper;
import com.lmeng.pojo.Menu;
import com.lmeng.service.IMenuService;
import com.lmeng.utils.ConvertUtil;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class IMenuServiceImpl implements IMenuService {

    @Resource
    private MenuMapper menuMapper;

    @Override
    public List<Menu> getMenusByKeys(String menuIds) {
        Example example = new Example(Menu.class);
        Example.Criteria criteria = example.createCriteria();

        Integer[] roleArray = ConvertUtil.toIntArray(menuIds);
        if (!StringUtils.isEmpty(menuIds)) {
            criteria.andIn("menuId", Arrays.asList(roleArray));
        }
        criteria.andEqualTo("statusId", 1);
        List<Menu> userList = menuMapper.selectByExample(example);

        return userList;
    }
}
