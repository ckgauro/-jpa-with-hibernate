package com.gauro.database.bootstrap;

import com.gauro.database.entity.Person;
import com.gauro.database.jdbc.PersonJdbcDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author Chandra
 */
@Slf4j
@Component
public class BootStrapCommand implements CommandLineRunner {

    private final PersonJdbcDao personJdbcDao;

    public BootStrapCommand(PersonJdbcDao personJdbcDao) {
        this.personJdbcDao = personJdbcDao;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("All Users--->");
        personJdbcDao.findAll().forEach(System.out::println);

        log.info("User id 10001 -> {}", personJdbcDao.findById(10001));
        log.info("Deleting 10002 -> No of Rows Deleted - {}", personJdbcDao.deleteById(10002));

        log.info("Inserting 10004 -> {}",
                personJdbcDao.insert(new Person(10004, "Tara", "Berlin", new Date())));

        log.info("Update 10003 -> {}",
                personJdbcDao.update(new Person(10003, "Pieter", "Utrecht", new Date())));

        log.info("All Users findAllRowMapper--->");
        personJdbcDao.findAllRowMapper().forEach(System.out::println);


    }
}
