package com.timesheet.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.timesheet.entity.Project;
import com.timesheet.mapper.ProjectMapper;
import com.timesheet.service.ProjectService;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project> implements ProjectService {
}
