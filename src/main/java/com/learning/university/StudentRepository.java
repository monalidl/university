package com.learning.university;

/**
 * @author Monali L on 1/20/2020
 */

import org.springframework.data.jpa.repository.JpaRepository;

interface StudentRepository extends JpaRepository<Student, Long> {

}
