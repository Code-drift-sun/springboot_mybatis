package com.aaa.sm.dao;

import com.aaa.sm.entity.Student;

public interface StudentDao {
    //根据id查询学生
    public Student getById(int id);
    //新增学生
    public int insert(Student student);


}
