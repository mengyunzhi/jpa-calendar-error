package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@SpringBootTest
@RunWith(SpringRunner.class)
public class StudentRepositoryTest {
    private static final Logger logger = LoggerFactory.getLogger(StudentRepositoryTest.class);
    @Autowired StudentRepository studentRepository;

    @Test
    public void test() {
        Student student = new Student();
        studentRepository.save(student);

        Student student1 = studentRepository.findById(student.getId()).get();
        System.out.println(student1.getApplyTimestamp().getTime());
        System.out.println(student1.getApplyTime().getTimeInMillis());

    }

}