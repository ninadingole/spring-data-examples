package com.spring.jdbc;

import com.spring.jdbc.dao.EmployeeDao;
import com.spring.jdbc.dao.UserDao;
import com.spring.jdbc.domain.Employee;
import com.spring.jdbc.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.properties.PropertyMapping;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@EnableAutoConfiguration
@SpringBootTest(properties = {"classpath:application-test.properties"})
@PropertyMapping("classpath:application-test.properties")
public class EmployeeDaoImplTest {

	@Autowired
	private EmployeeDao employeeDao;

	@Test
	public void testAddEmployee() {
		Employee emp = new Employee();
		emp.setEmpName("John");
		emp.setSupervisor("Harry");
		emp.setDepartment("IT");
        int i = employeeDao.addEmployee(emp);
        Assert.assertEquals(1,i);
	}

	@Test
    public void testGetAllEmployees(){
        List<Employee> allEmployees =
                this.employeeDao.getAllEmployees();
        for(Employee e: allEmployees){
            System.out.println(e);
        }
        Assert.assertNotNull(allEmployees);
        Assert.assertTrue(allEmployees.size() > 0);
    }

    @Test
    public void testUpdate(){
        Employee employee = this.employeeDao.getEmployee(42433);
        employee.setEmpName("Mark");
        int i = this.employeeDao.updateEmployee(employee);
        Assert.assertEquals(1,i);
        Employee e = this.employeeDao.getEmployee(42433);
        Assert.assertEquals("Mark", e.getEmpName());
    }

    @Test
    public void testSearch(){
        List<Employee> search = this.employeeDao.search("department", "Market");
        Assert.assertNotNull(search);
        Assert.assertTrue(search.size() == 2);
    }
}
