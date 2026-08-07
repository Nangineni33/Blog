package com.example.Blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService service;

    @PostMapping("/Register")
    public User Register(@RequestBody User user){
        return service.PasswordEncode(user);
    }

    @PostMapping("/Login")
    public String Login(@RequestBody User loginrequest){
        return service.loginRequest(loginrequest);
    }
}
