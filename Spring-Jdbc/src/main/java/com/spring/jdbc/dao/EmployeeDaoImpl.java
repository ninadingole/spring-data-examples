package com.spring.jdbc.dao;

import com.spring.jdbc.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by ninad on 3/9/2017.
 */
@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    private final static String TABLENAME = "employee";

    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert jdbcInsert;

    @Autowired
    public EmployeeDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.jdbcInsert = new SimpleJdbcInsert(dataSource).withTableName(TABLENAME)
                .usingGeneratedKeyColumns("empId");
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> query = this.jdbcTemplate.query("SELECT * FROM employee", new EmployeeRowMapper());
        return query;
    }

    @Override
    public int addEmployee(Employee e) {
        BeanPropertySqlParameterSource source = new BeanPropertySqlParameterSource(e);
        int execute = this.jdbcInsert.execute(source);
        return execute;
    }

    @Override
    public Employee getEmployee(long id) {
        List<Employee> query = this.jdbcTemplate.query("SELECT * FROM employee WHERE empId=?", new Object[]{id}, new EmployeeRowMapper());
        return query.get(0);
    }

    @Override
    public List<Employee> search(String searchType, String value) {
        List<Employee> query = this.jdbcTemplate.query("SELECT * FROM employee WHERE " + searchType + " = ?", new Object[]{value}, new EmployeeRowMapper());
        return query;
    }

    @Override
    public int updateEmployee(Employee e) {
        int update = this.jdbcTemplate.update("UPDATE employee SET empName=?,department=?,supervisor=? WHERE empId=?", new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1, e.getEmpName());
                preparedStatement.setString(2, e.getDepartment());
                preparedStatement.setString(3, e.getSupervisor());
                preparedStatement.setLong(4, e.getEmpId());
            }
        });
        return update;
    }
}
