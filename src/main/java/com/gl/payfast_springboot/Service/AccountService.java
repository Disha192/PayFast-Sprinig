package com.gl.payfast_springboot.Service;

import com.gl.payfast_springboot.Entity.Account;
import com.gl.payfast_springboot.Entity.UserEntity;
import com.gl.payfast_springboot.Exceptions.UserNotFoundException;
import com.gl.payfast_springboot.Repository.AccountRepository;
import com.gl.payfast_springboot.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    UserRepository userRepository;


    public ResponseEntity<String> createAccount(Account account) throws UserNotFoundException {
        UserEntity user = userRepository.findById(account.getUserId()).
                orElseThrow(()->new UserNotFoundException("User not found with id: "+account.getUserId()));
        accountRepository.save(account);
        return ResponseEntity.ok("Account created successfully");
    }

    public Account getAccountById(Long accountId) {
        return accountRepository.findById(accountId).orElse(null);
    }
}
