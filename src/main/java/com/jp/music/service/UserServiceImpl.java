package com.jp.music.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jp.music.dao.UserDao;
import com.jp.music.models.User;

@Service("userService")
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;

	@Override
	public User findUserByName(String name) {
		return userDao.findUserByName(name);
	}

	@Override
	@Transactional(readOnly = false)
	public void saveUser(User user) {
		userDao.saveUser(user);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteUser(Integer id) {
		User user = userDao.findById(id);
		userDao.delete(user);
	}

	@Override
	public List<User> findAllUsers() {
		List<User> userList = userDao.findAll();
		return userList;
	}

	@Override
	public void saveAllUsers(List<User> userList) {
		userDao.saveOrUpdateAll(userList);
	}

	@Override
	public User findUserById(Integer id) {
		return userDao.findById(id);
	}

//	@Override
//	public User loadUserByUsername(String username) {
//		User u = userDao.findUserByName(username);
//		return new User(u.getUserName(), u.getUserPass(), "ROLE_USER");
//	}

}
