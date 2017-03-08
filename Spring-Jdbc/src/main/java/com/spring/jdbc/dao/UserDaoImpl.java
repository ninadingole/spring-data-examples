package com.spring.jdbc.dao;

import com.spring.jdbc.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

/**
 * Created by ninad on 3/8/2017.
 */
@Repository
public class UserDaoImpl implements UserDao {


    private final static String TABLENAME = "users";

    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert jdbcInsert;
    private UserMappingQuery userMappingQuery;

    @Autowired
    public UserDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.jdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName(TABLENAME);
        this.userMappingQuery = new UserMappingQuery(dataSource);
    }

    @Override
    public int addUser(User user) {
        BeanPropertySqlParameterSource source = new BeanPropertySqlParameterSource(user);
        int execute = this.jdbcInsert.execute(source);
        return execute;
    }

    @Override
    public User getUser(String userName) {
        User user = this.jdbcTemplate.queryForObject("SELECT userName,password from users where userName = ?", new UserRowMapper(), userName);
        return user;
    }


}
