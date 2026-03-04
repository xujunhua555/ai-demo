package com.timesheet.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName("weekly_report")
public class WeeklyReport {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long userId;
    private Integer year;
    private Integer week;
    private BigDecimal totalHours;
    private String status;
    private Date createdAt;
    private Date updatedAt;
}
