package com.learning.university.view;

/**
 * @author Monali L on 1/20/2020
 */

import com.learning.university.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
