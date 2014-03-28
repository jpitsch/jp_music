package com.jp.music.dao;

import java.io.Serializable;

import com.jp.music.user.model.User;

public interface UserDao extends AbstractDao<User, Serializable> {
	void saveUser(User user);
    User findUserByName(String userName);
}
