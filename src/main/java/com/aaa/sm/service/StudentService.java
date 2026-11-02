package com.aaa.sm.service;

import com.aaa.sm.common.Result;
import com.aaa.sm.entity.Student;

public interface StudentService {
    public Result getById(int id);

    //新增学生
    public Result insert(Student student);

    //分页+条件查询
    public Result list(String name, String className, int pageNum, int pageSize);

    //修改学生
    public Result update(Student student);

    //删除学生
    public Result delete(int id);
}