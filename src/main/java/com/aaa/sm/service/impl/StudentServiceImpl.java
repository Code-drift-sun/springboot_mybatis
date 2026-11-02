package com.aaa.sm.service.impl;

import com.aaa.sm.common.Result;
import com.aaa.sm.dao.StudentDao;
import com.aaa.sm.entity.Student;
import com.aaa.sm.service.StudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {


    @Autowired
    private StudentDao studentDao;

    @Override
    public Result getById(int id) {
        Student student = studentDao.getById(id);
        if (student == null) {
            return Result.error("学生不存在");
        }
        return Result.ok(student);
    }

    @Override
    public Result insert(Student student) {
        try {
            int result = studentDao.insert(student);
            return Result.ok(result);
        } catch (DuplicateKeyException e) {
            return Result.error("学号已存在，请更换学号");
        }
    }

    @Override
    public Result list(String name, String className, int pageNum, int pageSize) {
        //开启分页
        PageHelper.startPage(pageNum, pageSize);
        List<Student> students = studentDao.list(name, className);
        //把查询的结果封装到pageInfo类中
        PageInfo<Student> pageInfo = new PageInfo<>(students);
        return Result.ok(pageInfo);
    }

    @Override
    public Result update(Student student) {
        if (student.getId() == null) {
            return Result.error("学生id不能为空");
        }
        if (studentDao.getById(student.getId()) == null) {
            return Result.error("学生不存在");
        }
        if (student.getNo() == null && student.getName() == null
                && student.getGender() == null && student.getBirthday() == null
                && student.getClassId() == null && student.getPhone() == null) {
            return Result.error("没有需要修改的字段");
        }
        try {
            int result = studentDao.update(student);
            return Result.ok(result);
        } catch (DuplicateKeyException e) {
            return Result.error("学号已存在，请更换学号");
        }
    }

    @Override
    public Result delete(int id) {
        if (studentDao.getById(id) == null) {
            return Result.error("学生不存在");
        }
        int result = studentDao.deleteById(id);
        return Result.ok(result);
    }
}