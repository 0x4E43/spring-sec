package com.springsecurity.security.user;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {

    public  String loginUser(UserVO vo){
        //use authentication
        return vo.getUsername();
    }
}
