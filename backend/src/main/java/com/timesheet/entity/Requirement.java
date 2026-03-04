package com.timesheet.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName("requirement")
public class Requirement {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long projectId;
    private String title;
    private String description;
    private Integer complexity;
    private BigDecimal estimatedHours;
    private String status;
    private Date createdAt;
    private Date updatedAt;
}
