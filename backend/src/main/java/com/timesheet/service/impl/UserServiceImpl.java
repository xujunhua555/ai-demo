package com.timesheet.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.timesheet.entity.Role;
import com.timesheet.entity.User;
import com.timesheet.mapper.UserMapper;
import com.timesheet.service.RoleService;
import com.timesheet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    
    @Autowired
    private RoleService roleService;
    
    private void validateReferences(User user) {
        if (user.getRoleId() != null) {
            Role role = roleService.getById(user.getRoleId());
            if (role == null) {
                throw new RuntimeException("角色不存在，roleId: " + user.getRoleId());
            }
        }
    }
    
    @Override
    public boolean save(User entity) {
        validateReferences(entity);
        return super.save(entity);
    }
    
    @Override
    public boolean updateById(User entity) {
        validateReferences(entity);
        return super.updateById(entity);
    }
}
