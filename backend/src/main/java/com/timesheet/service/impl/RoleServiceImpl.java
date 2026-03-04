package com.timesheet.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.timesheet.entity.Role;
import com.timesheet.mapper.RoleMapper;
import com.timesheet.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
}
