package com.example.Blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    BCryptPasswordEncoder encode;

    @Autowired
    UserRepository repository;

    @Autowired
    JwtUtil jwtUtil;

    public User PasswordEncode(User user){
        user.setPassword(encode.encode(user.getPassword()));
        repository.save(user);
        return user;
    }

    public String loginRequest(User loginrequest){
        User user= repository.findByUsername(loginrequest.getUsername()).orElseThrow(() -> new RuntimeException("User not found"));

        if (encode.matches(loginrequest.getPassword(), user.getPassword())) {
            return jwtUtil.generateToken(user.getUsername());
        }
        return "Invalid password";
    }
}
