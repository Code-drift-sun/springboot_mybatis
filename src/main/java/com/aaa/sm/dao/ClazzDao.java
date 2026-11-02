package com.aaa.sm.dao;

import com.aaa.sm.entity.Clazz;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClazzDao {
    //根据id查询班级
    Clazz getById(int id);

    //查询全部班级（前端下拉框用）
    public List<Clazz> listAll();

    //条件查询（分页由PageHelper插件完成，这里不写limit）
    public List<Clazz> list(@Param("name") String name,
                            @Param("room") String room);

    //新增班级
    public int insert(Clazz clazz);

    //修改班级
    public int update(Clazz clazz);

    //删除班级
    public int deleteById(int id);
}