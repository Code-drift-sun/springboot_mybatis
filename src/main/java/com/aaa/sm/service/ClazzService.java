package com.aaa.sm.service;

import com.aaa.sm.common.Result;
import com.aaa.sm.entity.Clazz;

public interface ClazzService {
    public Result getById(int id);

    //查询全部班级（前端下拉框用）
    public Result listAll();

    //分页+条件查询
    public Result list(String name, String room, int pageNum, int pageSize);

    //新增班级
    public Result insert(Clazz clazz);

    //修改班级
    public Result update(Clazz clazz);

    //删除班级
    public Result delete(int id);
}