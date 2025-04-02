package com.joy.bi.dashboard.repository;

import com.joy.bi.dashboard.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    public  User findByEmail(String username);

}