package com.aaa.sm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("class")
public class Clazz {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer cid;
    @TableField("class_name")
    private String name;
    private String grade;
    @TableField("head_teacher")
    private String teacher;
    private String room;
}