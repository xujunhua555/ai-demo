package com.timesheet.service;

import com.timesheet.dto.LoginRequest;
import com.timesheet.dto.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest request);
}
