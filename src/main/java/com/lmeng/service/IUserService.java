package com.lmeng.service;

import com.lmeng.pojo.User;

import java.util.List;

public interface IUserService {

	public void saveUser(User user) throws Exception;

	public void updateUser(User user);

	public void deleteUser(String userId);

	public User queryUserById(String userId);

	public List<User> queryUserList(User user);

	public List<User> queryUserListPaged(User user, Integer page, Integer pageSize);

	public User queryUserByNameCustom(String UserName);
	
	public void saveUserTransactional(User user);
}
