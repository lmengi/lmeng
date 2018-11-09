package com.lmeng.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.lmeng.mapper.UserMapper;
import com.lmeng.mapper.UserMapperCustom;
import com.lmeng.pojo.User;
import com.lmeng.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service
public class IUserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserMapperCustom userMapperCustom;


    @Override
    //@Transactional 事务回滚
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveUser(User user) throws Exception {
        userMapper.insert(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateUser(User user) {
        userMapper.updateByPrimaryKey(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteUser(String userId) {
        userMapper.deleteByPrimaryKey(userId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User queryUserById(String userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<User> queryUserList(User user) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(user.getName())) {
//			criteria.andEqualTo("username", user.getUsername());
            criteria.andLike("username", "%" + user.getName() + "%");
        }

        if (!StringUtils.isEmpty(user.getNickname())) {
            criteria.andLike("nickname", "%" + user.getNickname() + "%");
        }

        List<User> userList = userMapper.selectByExample(example);

        return userList;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<User> queryUserListPaged(User user, Integer page, Integer pageSize) {
        // 开始分页
        PageHelper.startPage(page, pageSize);

        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(user.getNickname())) {
            criteria.andLike("nickname", "%" + user.getNickname() + "%");
        }
        example.orderBy("registTime").desc();
        List<User> userList = userMapper.selectByExample(example);

        return userList;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User queryUserByNameCustom(String UserName) {
        List<User> userList = userMapperCustom.queryUserSimplyInfoByName(UserName);

        if (userList != null && !userList.isEmpty()) {
            return (User)userList.get(0);
        }

        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveUserTransactional(User user) {
        userMapper.insert(user);
        user.setStatusid(1);
        userMapper.updateByPrimaryKeySelective(user);
    }

}
