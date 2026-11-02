package com.aaa.sm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private Integer id;
    private String no;
    private String name;
    private String gender;
    private Date birthday;
    private Integer classId;
    private String phone;

    private Clazz clazz;
}
