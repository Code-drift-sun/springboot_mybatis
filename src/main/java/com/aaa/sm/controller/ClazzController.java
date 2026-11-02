package com.aaa.sm.controller;

import com.aaa.sm.common.Result;
import com.aaa.sm.entity.Clazz;
import com.aaa.sm.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clazz")
public class ClazzController {
    @Autowired
    private ClazzService clazzService;

    @GetMapping("/getById/{id}")
    public Result getById(@PathVariable int id) {
        return clazzService.getById(id);
    }

    @GetMapping("/all")
    public Result listAll() {
        return clazzService.listAll();
    }

    @GetMapping("/list")
    public Result list(@RequestParam(defaultValue = "1") int pageNum,
                       @RequestParam(defaultValue = "5") int pageSize,
                       @RequestParam(required = false) String name,
                       @RequestParam(required = false) String room) {
        return clazzService.list(name, room, pageNum, pageSize);
    }

    @PostMapping("/insert")
    public Result insert(@RequestBody Clazz clazz) {
        return clazzService.insert(clazz);
    }

    @PutMapping("/update")
    public Result update(@RequestBody Clazz clazz) {
        return clazzService.update(clazz);
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable int id) {
        return clazzService.delete(id);
    }
}