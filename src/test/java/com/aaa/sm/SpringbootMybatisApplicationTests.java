package com.aaa.sm;

import com.aaa.sm.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootMybatisApplicationTests {

    @Autowired
    private StudentService studentService;

    @Test
    void contextLoads() {
        System.out.println(studentService.getById(1));
    }

}
