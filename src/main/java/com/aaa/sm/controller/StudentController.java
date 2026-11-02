package com.aaa.sm.controller;

import com.aaa.sm.common.Result;
import com.aaa.sm.entity.Student;
import com.aaa.sm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping("/getById")
    public Result getById(int id){
        return studentService.getById(id);
    }

    @PostMapping("/insert")
    public Result insert(@RequestBody Student student){
        return studentService.insert(student);
    }
}
