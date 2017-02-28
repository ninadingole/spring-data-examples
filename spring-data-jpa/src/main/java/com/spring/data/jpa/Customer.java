package com.spring.data.jpa;

import lombok.*;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Represents Customer Data in database.
 * Created by ninad on 2/24/2017.
 */
@Getter
@Entity
@RequiredArgsConstructor
@ToString
public class Customer extends AbstractEntity{

    private final String firstName,lastName;
    private final String gender;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "customer_id")
    private Set<Address> address = new HashSet<>();

    public Customer() {
        firstName = null;
        lastName = null;
        gender = null;
    }

    public void addAddress(Address address){
        this.address.add(address);
    }

    public Set<Address> getAddress(){
        return Collections.unmodifiableSet(this.address);
    }
}
