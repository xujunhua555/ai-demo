package com.timesheet.dto;

import lombok.Data;

@Data
public class LoginResponse {
    private String token;
    private UserDTO user;
    
    @Data
    public static class UserDTO {
        private Long id;
        private String username;
        private String name;
        private String email;
        private Long roleId;
        private String roleName;
    }
}
