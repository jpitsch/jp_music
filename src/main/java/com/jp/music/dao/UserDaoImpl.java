package com.jp.music.dao;

import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.jp.music.models.User;

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
    public User findUserByName(String userName) {
        return findByCriteria(Restrictions.like("userName", userName, MatchMode.START));
    }
}
