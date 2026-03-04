package com.timesheet.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.timesheet.entity.Timesheet;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TimesheetMapper extends BaseMapper<Timesheet> {
}
