package com.spring.data.jpa;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.*;

/**
 * Abstract Entity used to define ID parameter to other entities.
 * Created by ninad on 2/25/2017.
 */
@MappedSuperclass
@Data
@EqualsAndHashCode(of = {"id"})
public class AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
}
