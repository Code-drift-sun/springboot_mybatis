package com.aaa.sm.service.impl;

import com.aaa.sm.common.Result;
import com.aaa.sm.dao.ClazzDao;
import com.aaa.sm.dao.StudentDao;
import com.aaa.sm.entity.Clazz;
import com.aaa.sm.entity.Student;
import com.aaa.sm.service.ClazzService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {
    @Autowired
    private ClazzDao clazzDao;

    @Autowired
    private StudentDao studentDao;

    @Override
    public Result getById(int id) {
        Clazz clazz = clazzDao.selectById(id);
        if (clazz == null) {
            return Result.error("班级不存在");
        }
        return Result.ok(clazz);
    }

    @Override
    public Result listAll() {
        //单表查询全部班级，前端下拉框用
        return Result.ok(clazzDao.selectList(
                Wrappers.<Clazz>lambdaQuery().orderByAsc(Clazz::getCid)));
    }

    @Override
    public Result list(String name, String room, int pageNum, int pageSize) {
        //开启分页
        PageHelper.startPage(pageNum, pageSize);
        //单表条件查询，走MyBatis-Plus
        List<Clazz> clazzes = clazzDao.selectList(
                Wrappers.<Clazz>lambdaQuery()
                        .like(name != null && !name.isEmpty(), Clazz::getName, name)
                        .like(room != null && !room.isEmpty(), Clazz::getRoom, room)
                        .orderByAsc(Clazz::getCid));
        //把查询的结果封装到pageInfo类中
        PageInfo<Clazz> pageInfo = new PageInfo<>(clazzes);
        return Result.ok(pageInfo);
    }

    @Override
    public Result insert(Clazz clazz) {
        try {
            //单表新增，走MyBatis-Plus
            int result = clazzDao.insert(clazz);
            return Result.ok(result);
        } catch (DuplicateKeyException e) {
            return Result.error("班级名称已存在，请更换班级名称");
        }
    }

    @Override
    public Result update(Clazz clazz) {
        if (clazz.getCid() == null) {
            return Result.error("班级id不能为空");
        }
        if (clazzDao.selectById(clazz.getCid()) == null) {
            return Result.error("班级不存在");
        }
        if (clazz.getName() == null && clazz.getGrade() == null
                && clazz.getTeacher() == null && clazz.getRoom() == null) {
            return Result.error("没有需要修改的字段");
        }
        try {
            //单表修改，走MyBatis-Plus（只更新不为null的字段）
            int result = clazzDao.updateById(clazz);
            return Result.ok(result);
        } catch (DuplicateKeyException e) {
            return Result.error("班级名称已存在，请更换班级名称");
        }
    }

    @Override
    public Result delete(int id) {
        if (clazzDao.selectById(id) == null) {
            return Result.error("班级不存在");
        }
        //单表统计，走MyBatis-Plus
        Long count = studentDao.selectCount(
                Wrappers.<Student>lambdaQuery().eq(Student::getClassId, id));
        if (count != null && count > 0) {
            return Result.error("该班级下还有" + count + "名学生，不能删除");
        }
        //单表删除，走MyBatis-Plus
        int result = clazzDao.deleteById(id);
        return Result.ok(result);
    }
}