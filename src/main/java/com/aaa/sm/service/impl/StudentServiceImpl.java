package com.aaa.sm.service.impl;

import com.aaa.sm.common.Result;
import com.aaa.sm.dao.StudentDao;
import com.aaa.sm.entity.Student;
import com.aaa.sm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {


    @Autowired
    private StudentDao studentDao;

    @Override
    public Result getById(int id) {
        Student student = studentDao.getById(id);
        return Result.ok(student);
    }

    @Override
    public Result insert(Student student) {
        int result = studentDao.insert(student);
        return Result.ok(result);
    }
}