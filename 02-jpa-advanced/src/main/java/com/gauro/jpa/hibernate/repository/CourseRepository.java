package com.gauro.jpa.hibernate.repository;

import com.gauro.jpa.hibernate.Course;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

/**
 * @author Chandra
 */
@Repository
public class CourseRepository {

    private final EntityManager entityManager;

    public CourseRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Course findById(Long id){
        return entityManager.find(Course.class,id);
    }
    //public Course save(Course course) -> insert or update

    //public void deleteById(Long id);

}
