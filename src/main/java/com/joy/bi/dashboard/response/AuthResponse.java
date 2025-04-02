package com.joy.bi.dashboard.response;

import com.joy.bi.dashboard.model.USER_ROLE;
import lombok.Data;

@Data
public class AuthResponse {

    private String jwt;

    private String message;

    private USER_ROLE role;
}