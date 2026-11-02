package com.aaa.sm.dao;

import com.aaa.sm.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao extends BaseMapper<Student> {
    //根据id查询学生（多表：关联班级，必须用XML）
    public Student getById(int id);

    //条件查询（多表：关联班级，必须用XML，分页由PageHelper插件完成）
    public List<Student> list(@Param("name") String name,
                              @Param("className") String className);
}