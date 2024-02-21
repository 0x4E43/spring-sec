package com.springsecurity.security.user;

import com.springsecurity.security.securityConfig.AuthProvider;
import com.springsecurity.security.securityConfig.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {

    @Autowired
    AuthProvider authProvider;

    @Autowired
    JWTService jwtService;

    public  String loginUser(UserVO vo){
        //use authentication
        try{
            Authentication authentication = authProvider.authenticate(new UsernamePasswordAuthenticationToken(
                    vo.getUsername(), vo.getPassword()
            ));

            if(authentication.isAuthenticated()){
                // TODO: Generate JWT token and return to user here
                String jwtToken = jwtService.generateToken(vo.getUsername());
                return vo.getUsername()+" "+ jwtToken;
            }else{
                return "Invalid credential";
            }
        }catch (Exception e){
            return  e.getMessage();
        }
    }

    public String generatePasswordForInitialUSer() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode("password");
    }
}
