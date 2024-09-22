package com.gl.payfast_springboot.Controller;

import com.gl.payfast_springboot.Entity.Account;
import com.gl.payfast_springboot.Entity.UserEntity;
import com.gl.payfast_springboot.Service.AccountService;
import com.gl.payfast_springboot.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;


    @PostMapping("/add")
    public ResponseEntity<String> createAccount(@RequestBody Account account)  {
        return accountService.createAccount(account);
    }
}


