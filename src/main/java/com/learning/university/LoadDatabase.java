package com.learning.university;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.mapping.Collection;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Monali L on 1/20/2020
 */

@Configuration
@Slf4j
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase (StudentRepository studentRepo, SubjectRepository subjectRepo) {

        //subjectRepo.save(new Subject("Defense against the Dark Arts", "Albus Dumbledore"));
        subjectRepo.save(new Subject("Herbology", "Pomona Sprout"));
        subjectRepo.save(new Subject("Transfiguration",  "Minerva McGonagall"));
        subjectRepo.save(new Subject("Potions", "Horace Slughorn"));

        studentRepo.save(new Student("Ron Weasley"));
        studentRepo.save(new Student("Harry Potter"));
        studentRepo.save(new Student("Hermoine Grenger"));
        /*studentRepo.save(new Student("Harry", Arrays.asList(subjectRepo.getOne((long) 2))));
        studentRepo.save(new Student("Hermione", Arrays.asList(subjectRepo.getOne((long) 4))));
        studentRepo.save(new Student("Ginnie", Arrays.asList(subjectRepo.getOne((long) 3))));
        studentRepo.save(new Student("Luna", Arrays.asList(subjectRepo.getOne((long) 1))));
        studentRepo.save(new Student("Malfoy", Arrays.asList(subjectRepo.getOne((long) 2))));*/

        return args -> {
            log.info("Preloading " + studentRepo);
            log.info("Preloading " + subjectRepo);
        };
    }
}
