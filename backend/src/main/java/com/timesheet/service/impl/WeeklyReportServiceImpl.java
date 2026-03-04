package com.timesheet.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.timesheet.entity.WeeklyReport;
import com.timesheet.mapper.WeeklyReportMapper;
import com.timesheet.service.WeeklyReportService;
import org.springframework.stereotype.Service;

@Service
public class WeeklyReportServiceImpl extends ServiceImpl<WeeklyReportMapper, WeeklyReport> implements WeeklyReportService {
}
