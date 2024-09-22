package com.gl.payfast_springboot.Service;

import com.gl.payfast_springboot.Entity.UserEntity;
import com.gl.payfast_springboot.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String addUser(UserEntity user) {
        userRepository.save(user);
        return "User added successfully";
    }


    public UserEntity getUserById(long userid) {
        return userRepository.findById(userid).orElse(null);
    }
}
