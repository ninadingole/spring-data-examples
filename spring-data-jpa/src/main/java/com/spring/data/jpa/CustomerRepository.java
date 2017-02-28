package com.spring.data.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data Repository for {@link Customer} db entities
 * Created by ninad on 2/24/2017.
 */
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Iterable<Customer> findByLastName(String lastnames);

    Iterable<Customer> findByAddressZipCode(String zipCode);
}
