package com.spring.jdbc.dao;

import com.spring.jdbc.domain.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by ninad on 3/8/2017.
 */
public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setPassword(resultSet.getString("password"));
        user.setUsername(resultSet.getString("userName"));
        return user;
    }
}
