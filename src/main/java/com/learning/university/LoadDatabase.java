package com.learning.university;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Monali L on 1/20/2020
 */

@Configuration
@Slf4j
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase (StudentRepository studentRepo, SubjectRepository subjectRepo) {

        studentRepo.save(new Student("Ron", "Potions"));
        studentRepo.save(new Student("Harry", "Herbology"));
        studentRepo.save(new Student("Hermione", "Transfiguration"));
        studentRepo.save(new Student("Ginnie", "Defense against the Dark Arts"));
        studentRepo.save(new Student("Luna", "Potions"));
        studentRepo.save(new Student("Malfoy", "Herbology"));

        subjectRepo.save(new Subject("Defense against the Dark Arts"));
        subjectRepo.save(new Subject("Herbology"));
        subjectRepo.save(new Subject("Transfiguration"));
        subjectRepo.save(new Subject("Potions"));

        return args -> {
            log.info("Preloading " + studentRepo.findAll());
            log.info("Preloading " + subjectRepo.findAll());
        };
    }
}
