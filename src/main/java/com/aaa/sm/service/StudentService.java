package com.aaa.sm.service;

import com.aaa.sm.common.Result;
import com.aaa.sm.entity.Student;

public interface StudentService {
    public Result getById(int id);

    //新增学生
    public Result insert(Student student);
}
