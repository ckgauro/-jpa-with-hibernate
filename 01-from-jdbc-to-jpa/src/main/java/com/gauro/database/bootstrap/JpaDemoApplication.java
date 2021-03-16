package com.gauro.database.bootstrap;

import com.gauro.database.entity.Person;
import com.gauro.database.jpa.PersonJpaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author Chandra
 */
@Slf4j
@Component
public class JpaDemoApplication implements CommandLineRunner {

    private final PersonJpaRepository personJpaRepository;

    public JpaDemoApplication(PersonJpaRepository personJpaRepository) {
        this.personJpaRepository = personJpaRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        log.info("========JpaDemoApplication=========");
        log.info(personJpaRepository.findById(10001).toString());

        log.info("All users -> {}", personJpaRepository.findAll());
        log.info("Deleting 10002 -> No of Rows Deleted - ");
        // personJpaRepository.deleteById(10002);
        log.info("Inserting 10004 -> {}",
                personJpaRepository.insert(new Person(10004, "Tara", "Berlin", new Date())));

        log.info("Update 10003 -> {}",
                personJpaRepository.update(new Person(10003, "Pieter", "Utrecht", new Date())));


    }
}
