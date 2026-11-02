package com.aaa.sm.dao;

import com.aaa.sm.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {
    //根据id查询学生
    public Student getById(int id);
    //新增学生
    public int insert(Student student);

    //条件查询（分页由PageHelper插件完成，这里不写limit）
    public List<Student> list(@Param("name") String name,
                              @Param("className") String className);

    //修改学生
    public int update(Student student);

    //删除学生
    public int deleteById(int id);

    //统计某个班级下的学生数量（删除班级前校验外键）
    public int countByClassId(int classId);
}