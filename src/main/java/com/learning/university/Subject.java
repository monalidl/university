package com.learning.university;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Monali L on 1/20/2020
 */

@Data
@Entity
class Subject {
    private @Id @GeneratedValue Long id;
    private String name;

    Subject() {}

    Subject(String name) {
        this.name = name;
    }
}
