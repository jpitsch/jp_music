package com.jp.music.dao;

import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.jp.music.user.model.User;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User, String> implements UserDao {
 
    protected UserDaoImpl() {
        super(User.class);
    }
 
    @Override
    public void saveUser(User user) {
        saveOrUpdate(user);
    }
 
    @Override
    public User findUserByName(String username) {
        return findByCriteria(Restrictions.like("username", username, MatchMode.START));
    }
}
