package com.joy.bi.dashboard.service;

import com.joy.bi.dashboard.model.User;

public interface UserService {

    public User findUserByJwtToken(String jwt) throws Exception;

    public User findUserByEmail(String email) throws Exception;
}
