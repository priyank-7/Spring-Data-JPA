package com.springdatajpa.spring.data.jpa.repository;

import com.springdatajpa.spring.data.jpa.entity.Course;
import com.springdatajpa.spring.data.jpa.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void SaveCourseMaterial(){

        Course course =
                Course.builder()
                        .courseTitle(".net")
                        .credit(6)
                        .build();

        CourseMaterial courseMaterial =
                CourseMaterial.builder()
                        .url("www.apple.com")
                        .course(course)
                        .build();

        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void printAllCourses(){
        List<CourseMaterial> courseMaterials =
                courseMaterialRepository.findAll();
        System.out.println(courseMaterials);
    }
}