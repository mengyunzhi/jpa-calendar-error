package com.example.demo;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;


@SpringBootTest
@RunWith(SpringRunner.class)
public class StudentRepositoryTest {
    private static final Logger logger = LoggerFactory.getLogger(StudentRepositoryTest.class);
    @Autowired StudentRepository studentRepository;

    @Test
    public void test() {
        Student student = new Student();
        Calendar calendar = Calendar.getInstance();
        long time = 20000000L;
        /** init with 20,000,000 */
        calendar.setTimeInMillis(time);
        student.setApplyTime(calendar);

        /** save entity with: 20,000,000 (1970/1/1 13:33:20 +8:00). database: 1970-01-01 13:33:20 +8:00 */
        studentRepository.save(student);

        Student student1 = studentRepository.findById(student.getId()).get();
        Assertions.assertThat(student1.getApplyTime().getTimeInMillis()).isGreaterThan(time);

        /** get 70400000 (1970/1/2 3:33:20 +8:00) , database:  1970-01-01 13:33:20 (+8:00)*/
        time = student1.getApplyTime().getTimeInMillis();
        logger.warn(String.valueOf(time));

        student1.setName("hi");
        studentRepository.save(student1);

        student1 = studentRepository.findById(student.getId()).get();
        Assertions.assertThat(student1.getApplyTime().getTimeInMillis()).isGreaterThan(time);
        time = student1.getApplyTime().getTimeInMillis();

        /** get  120800000(1970/1/2 17:33:20 +8:00), database: 1970-01-02 03:33:20*/
        logger.warn(String.valueOf(time));

        student1.setName("hello");
        studentRepository.save(student1);

        student1 = studentRepository.findById(student.getId()).get();
        Assertions.assertThat(student1.getApplyTime().getTimeInMillis()).isGreaterThan(time);
        time = student1.getApplyTime().getTimeInMillis();

        /** get 171200000(1970/1/3 7:33:20 +8:00) database: 1970-01-02 17:33:20 +8:00*/
        logger.warn(String.valueOf(time));
    }

}