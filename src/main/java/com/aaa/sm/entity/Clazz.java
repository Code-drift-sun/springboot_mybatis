package com.aaa.sm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Clazz {
    private Integer cid;
    private String name;
    private String grade;
    private String teacher;
    private String room;
}
