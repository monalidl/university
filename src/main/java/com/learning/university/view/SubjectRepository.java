package com.learning.university.view;

import com.learning.university.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Monali L on 1/20/2020
 */

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
