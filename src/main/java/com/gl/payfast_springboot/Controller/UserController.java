package com.gl.payfast_springboot.Controller;

import com.gl.payfast_springboot.Entity.UserEntity;
import com.gl.payfast_springboot.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add")
    public String addUser(@RequestBody  UserEntity user) {
        userService.addUser(user);
        return "User added successfully";
    }
}
