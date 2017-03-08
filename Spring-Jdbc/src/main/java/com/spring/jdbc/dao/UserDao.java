package com.spring.jdbc.dao;

import com.spring.jdbc.domain.User;

/**
 * Created by ninad on 3/8/2017.
 */
public interface UserDao {

    int addUser(User user);

    User getUser(String userName);
}
