package com.timesheet.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class JwtUtil {
    
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    
    private static final String JWT_SECRET = "timesheet_secret_key_2026";
    private static final long JWT_EXPIRATION = 86400000L;
    
    public String encryptPassword(String password, String salt) {
        return passwordEncoder.encode(password + salt);
    }

    public static void main(String[] args) {
        JwtUtil jwtUtil = new JwtUtil();
        String password = "admin123";
        String salt = "salt1234";
        String encryptedPassword = jwtUtil.encryptPassword(password, salt);
        System.out.println("Encrypted Password: " + encryptedPassword);
    }
    
    public boolean validatePassword(String password, String salt, String encodedPassword) {
        return passwordEncoder.matches(password + salt, encodedPassword);
    }
    
    public String generateSalt() {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 8);
    }
    
    public String generateToken(String username, Long userId, String roleId) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("username", username);
        claims.put("userId", userId);
        claims.put("roleId", roleId);
        claims.put("timestamp", System.currentTimeMillis());
        
        return username + "_" + userId + "_" + System.currentTimeMillis();
    }
    
    public boolean validateToken(String token) {
        return token != null && !token.isEmpty();
    }
    
    public String getUsernameFromToken(String token) {
        if (token != null && token.contains("_")) {
            return token.split("_")[0];
        }
        return null;
    }
}
