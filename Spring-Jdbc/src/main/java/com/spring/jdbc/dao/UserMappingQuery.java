package com.spring.jdbc.dao;

import com.spring.jdbc.domain.User;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
 * Created by ninad on 3/8/2017.
 */
public class UserMappingQuery extends MappingSqlQuery<User> {

    public UserMappingQuery(DataSource dataSource){
        super(dataSource,"SELECT userName,password from users where username=? and password=?");
        super.declareParameter(new SqlParameter("userName", Types.VARCHAR));
        super.declareParameter(new SqlParameter("password",Types.VARCHAR));
        compile();
    }

    @Override
    protected User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user =new User();
        user.setUsername(resultSet.getString("userName"));
        user.setPassword(resultSet.getString("password"));
        return user;
    }


}
