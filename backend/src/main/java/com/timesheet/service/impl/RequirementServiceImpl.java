package com.timesheet.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.timesheet.entity.Requirement;
import com.timesheet.mapper.RequirementMapper;
import com.timesheet.service.RequirementService;
import org.springframework.stereotype.Service;

@Service
public class RequirementServiceImpl extends ServiceImpl<RequirementMapper, Requirement> implements RequirementService {
}
