package com.spring.data.jpa;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by ninad on 2/25/2017.
 */
@Getter
@Entity
@RequiredArgsConstructor
public class Address extends AbstractEntity{

    private final String street, city, zipCode;

    public Address(){
        street = null;
        city = null;
        zipCode = null;
    }
}
