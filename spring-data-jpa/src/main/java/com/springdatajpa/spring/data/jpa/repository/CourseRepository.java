package com.springdatajpa.spring.data.jpa.repository;

import com.springdatajpa.spring.data.jpa.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {

//    public Page<Course> findByTitleContaining(String title, Pageable pageable);
}
