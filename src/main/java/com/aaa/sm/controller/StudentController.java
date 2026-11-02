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

    @GetMapping("/getById/{id}")
    public Result getById(@PathVariable int id) {
        return studentService.getById(id);
    }

    @PostMapping("/insert")
    public Result insert(@RequestBody Student student) {
        return studentService.insert(student);
    }

    @GetMapping("/list")
    public Result list(@RequestParam(defaultValue = "1") int pageNum,
                       @RequestParam(defaultValue = "5") int pageSize,
                       @RequestParam(required = false) String name,
                       @RequestParam(required = false) String className) {
        return studentService.list(name, className, pageNum, pageSize);
    }

    @PutMapping("/update")
    public Result update(@RequestBody Student student) {
        return studentService.update(student);
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable int id) {
        return studentService.delete(id);
    }
}