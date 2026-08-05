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

    public User PasswordEncode(User user){
        user.setPassword(encode.encode(user.getPassword()));
        repository.save(user);
        return user;
    }
}
