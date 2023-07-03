package com.springdatajpa.spring.data.jpa.repository;

import com.springdatajpa.spring.data.jpa.entity.Guardian;
import com.springdatajpa.spring.data.jpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


//Below one annotation is use for testing repository layer, when we don't want to affect our database
//@DataJpaTest
@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("asd@gmail.com")
                .firstName("asd")
                .lastName("qwe")
//                .guardianName("zxc")
//                .guardianMobile("99999999999")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void SaveStudentWithGuardian(){

        Guardian guardian = Guardian.builder()
                .email("asd@gmail.com")
                .name("safdsh")
                .mobile("9999999999")
                .build();

        Student student = Student.builder()
                .firstName("asdf")
                .emailId("asdfs@gmail.com")
                .lastName("patel")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList =
                studentRepository.findAll();
        System.out.println(studentList);
    }

    @Test
    public void printStudentByFirstNAme(){

        List<Student> students =
                studentRepository.findByFirstName("asd");
        System.out.println(students);
    }

    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> students =
                studentRepository.findByFirstNameContaining("as");
        System.out.println(students);
    }

    @Test
    public void  printStudentBasedOnGuardianName(){
        List<Student> students =
                studentRepository.findByGuardianName("zxc");
        System.out.println(students);
    }

    @Test
    public void printgetStudentByEmailAddress(){
        Student student = studentRepository.getStudentByEmailAddress("asd@gmail.com");
        System.out.println(student);
    }

    @Test
    public void printgetStudentFirstNameByEmailAddress(){
        String firstName =
                studentRepository.getStudentFirstNameByEmailAddress("asd@gmail.com");
        System.out.println(firstName);
    }

    @Test
    public void printgetStudentByEmailAddressNative(){
        Student student =
                studentRepository.getStudentByEmailAddressNative("asd@gmail.com");
        System.out.println(student);
    }

    @Test
    public void getStudentByEmailAddressNativeNamedParam(){
        Student student =
                studentRepository.getStudentByEmailAddressNativeNamedParam("asd@gmail.com");
        System.out.println(student);
    }

    @Test
    public void updateStudentNameByEmailId(){
        studentRepository.updateStudentNameByEmailId("Hello","asd@gmail.com");
    }
}