package com.spring.data.jpa;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableJpaRepositories
public class SpringDataJpaApplication {

	@Autowired
	private CustomerRepository customerRepository;

	public static void main(String[] args) {
		ConfigurableApplicationContext context =
				SpringApplication.run(SpringDataJpaApplication.class, args);

	}

	@PostConstruct
	public void savedata(){
        System.out.println("Adding Mock Data");
		customerRepository.save(new Customer("Michael","Doe","Male"));
        customerRepository.save(new Customer("John","Doe","Male"));
        customerRepository.save(new Customer("Jenifer","Roberts","Female"));
	}
}
