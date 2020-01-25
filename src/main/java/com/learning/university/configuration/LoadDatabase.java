package com.learning.university.configuration;

import com.learning.university.model.Student;
import com.learning.university.view.StudentRepository;
import com.learning.university.model.Subject;
import com.learning.university.view.SubjectRepository;
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

        //subjectRepo.save(new Subject("Defense against the Dark Arts", "Albus Dumbledore"));
        subjectRepo.save(new Subject("Herbology", "Pomona Sprout"));
        subjectRepo.save(new Subject("Transfiguration",  "Minerva McGonagall"));
        subjectRepo.save(new Subject("Potions", "Horace Slughorn"));

        studentRepo.save(new Student("Ron Weasley"));
        studentRepo.save(new Student("Harry Potter"));
        studentRepo.save(new Student("Hermoine Grenger"));

        return args -> {
            log.info("Preloading " + studentRepo);
            log.info("Preloading " + subjectRepo);
        };
    }
}
