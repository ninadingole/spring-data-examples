package com.spring.jdbc.dao;

import com.spring.jdbc.domain.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by ninad on 3/9/2017.
 */
public class EmployeeRowMapper implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
        Employee employee = new Employee();
        employee.setEmpId(resultSet.getLong("empId"));
        employee.setEmpName(resultSet.getString("empName"));
        employee.setDepartment(resultSet.getString("department"));
        employee.setSupervisor(resultSet.getString("supervisor"));
        return employee;
    }
}
