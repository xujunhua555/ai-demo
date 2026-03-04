package com.timesheet.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.timesheet.entity.Timesheet;
import com.timesheet.mapper.TimesheetMapper;
import com.timesheet.service.TimesheetService;
import org.springframework.stereotype.Service;

@Service
public class TimesheetServiceImpl extends ServiceImpl<TimesheetMapper, Timesheet> implements TimesheetService {
}
