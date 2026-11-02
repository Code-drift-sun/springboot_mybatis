package com.aaa.sm.service.impl;

import com.aaa.sm.common.Result;
import com.aaa.sm.dao.ClazzDao;
import com.aaa.sm.entity.Clazz;
import com.aaa.sm.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClazzServiceImpl implements ClazzService {
    @Autowired
    private ClazzDao clazzDao;
    @Override
    public Result getById(int id) {
        Clazz clazz = clazzDao.getById(id);
        return Result.ok(clazz);
    }
}
