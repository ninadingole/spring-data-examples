package com.spring.jdbc.dao;

import com.spring.jdbc.domain.Employee;

import java.util.List;

/**
 * Created by ninad on 3/9/2017.
 */
public interface EmployeeDao {

    List<Employee> getAllEmployees();

    int addEmployee(Employee e);

    Employee getEmployee(long id);

    List<Employee> search(String searchType, String value);

    int updateEmployee(Employee e);
}
