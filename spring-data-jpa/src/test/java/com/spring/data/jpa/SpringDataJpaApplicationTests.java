package com.spring.data.jpa;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static org.hamcrest.core.Is.is;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableJpaRepositories
public class SpringDataJpaApplicationTests {

    @Autowired
    private CustomerRepository customerRepository;

    @PostConstruct
    public void setUp() {
        Customer michael = new Customer("Michael", "Doe", "Male");
        michael.addAddress(new Address("A2", "NewYork", "33221"));
        customerRepository.save(michael);
        customerRepository.save(new Customer("John", "Doe", "Male"));
        customerRepository.save(new Customer("Jenifer", "Roberts", "Female"));
    }

    @Test
    public void testCount() {
        long customers = this.customerRepository.count();
        Assert.assertThat(customers, is(3L));
    }

    @Test
    public void testFindAll() {
        Customer customer = new Customer("Michael", "Doe", "Male");
        customer.setId(1);
        Iterable<Customer> customers = this.customerRepository.findAll();
        Assert.assertThat(customers, CoreMatchers.hasItem(customer));
    }

    @Test
    public void testFindByLastName() {
        Iterable<Customer> roberts = this.customerRepository.findByLastName("Roberts");
        long size = roberts.spliterator().estimateSize();
        Assert.assertThat(size, is(1L));
        Assert.assertThat(roberts.iterator().next().getLastName(), is("Roberts"));
    }

    @Test
    public void testFindByZipCode() {
        Iterable<Customer> addressZipCode = this.customerRepository.findByAddressZipCode("33221");
        Assert.assertThat(addressZipCode.iterator().next().getAddress().iterator().next().getZipCode(),
                is("33221"));
    }
}
