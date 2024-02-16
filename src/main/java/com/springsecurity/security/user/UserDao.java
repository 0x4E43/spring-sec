package com.springsecurity.security.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserDao extends JpaRepository<UserBean, String> {
    UserDetails findByUsername(String username);
}
