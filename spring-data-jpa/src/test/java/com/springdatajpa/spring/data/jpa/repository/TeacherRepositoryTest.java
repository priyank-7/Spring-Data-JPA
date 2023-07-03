package com.springdatajpa.spring.data.jpa.repository;

import com.springdatajpa.spring.data.jpa.entity.Course;
import com.springdatajpa.spring.data.jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void SaveTeacher(){

        Course course1 = Course.builder()
                .courseTitle("DSA")
                .credit(5)
                .build();

        Course course2 = Course.builder()
                .courseTitle("OOP")
                .credit(6)
                .build();

        Teacher teacher =
                Teacher.builder()
                        .firstName("asfdasd")
                        .lastName("sdf")
//                        .courses(List.of(course1,course2))
                        .build();
        teacherRepository.save(teacher);
    }
}