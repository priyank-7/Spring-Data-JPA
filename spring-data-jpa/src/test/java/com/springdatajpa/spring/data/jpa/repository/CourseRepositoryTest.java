package com.springdatajpa.spring.data.jpa.repository;

import com.springdatajpa.spring.data.jpa.entity.Course;
import com.springdatajpa.spring.data.jpa.entity.Student;
import com.springdatajpa.spring.data.jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses(){
        List<Course> courses =
                courseRepository.findAll();
        System.out.println(courses);
    }

    @Test
    public void saveCourseWithTeacher(){

        Teacher teacher = Teacher.builder().firstName("asfdgfg").lastName("asdfg").build();

        Course course = Course.builder()
                .credit(6)
                .courseTitle("Python")
                .teacher(teacher)
                .build();
        courseRepository.save(course);
    }

//    Pagination
    @Test
    public void findAllPagination(){
        Pageable firstPageWithThreeRecord =
                 PageRequest.of(0,3);
        Pageable secondPageWithTwoRecord =
                PageRequest.of(1,2);
        List<Course> courses =
                courseRepository.findAll(secondPageWithTwoRecord).getContent();

        long totalElements = courseRepository.findAll(secondPageWithTwoRecord)
                        .getTotalElements();

        long totalPages = courseRepository.findAll(secondPageWithTwoRecord).getTotalPages();

        System.out.println("Total Elements : " + totalElements);
        System.out.println("Total Pages : " + totalPages);
        System.out.println(courses);
    }

//    Pagination With Sorting
    @Test
    public void findAllWithSorting(){
        Pageable sortByTitle =
                PageRequest.of(
                        0,
                        2,
                        Sort.by("courseTitle")
                );
        Pageable sortByCreditDesc =
                PageRequest.of(
                        0,
                        2,
                        Sort.by("credit").descending()
                );

        Pageable sortByTitleAndCreditDesc =
                PageRequest.of(
                        0,
                        2,
                        Sort.by("courseTitle")
                                .descending()
                                .and(Sort.by("credit"))
                );

        List<Course> courses
                = courseRepository.findAll(sortByTitle).getContent();
        System.out.println(courses);
    }

//    @Test
//    public void printFindByTitleContaining(){
//        Pageable firstPageTenRecords =
//                PageRequest.of(0,10);
//        List<Course> courses =
//                courseRepository.findByTitleContaining("D", firstPageTenRecords).getContent();
//        System.out.println(courses);
//    }

    @Test
    public void saveCourseWithStudentAndTeacher(){

        Teacher teacher = Teacher.builder()
                .firstName("ashjdgshj")
                .lastName("sdfhjb")
                .build();

        Student student = Student.builder()
                .firstName("asdhbmjhb")
                .lastName("asdjbjyh")
                .emailId("asdff@gmail.com")
                .build();

        Course course = Course.builder()
                .courseTitle("AI")
                .credit(12)
                .teacher(teacher)
                .build();

        course.addStudents(student);

        courseRepository.save(course);
    }
}