package com.jp.music.user.service;

import java.util.List;

import com.jp.music.user.model.User;

public interface UserService {
	User findUserById(Integer id);
	User findUserByName(String name);
	
	void saveUser(User user);
	void deleteUser(Integer id);
	
	void saveAllUsers(List<User> userList);
	List<User> findAllUsers();
	
//	User loadUserByUsername(String username);
}
