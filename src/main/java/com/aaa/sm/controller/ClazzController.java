package com.aaa.sm.controller;

import com.aaa.sm.common.Result;
import com.aaa.sm.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clazz")
public class ClazzController {
    @Autowired
    private ClazzService clazzService;
    @GetMapping("/getById")
    public Result getById(int id) {
        return clazzService.getById(id);
    }


}
