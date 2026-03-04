package com.timesheet.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName("timesheet")
public class Timesheet {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long userId;
    private Long requirementId;
    private Long projectId;
    private Date workDate;
    private BigDecimal hours;
    private String description;
    private Date createdAt;
    private Date updatedAt;
}
