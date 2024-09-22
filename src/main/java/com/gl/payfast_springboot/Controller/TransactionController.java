package com.gl.payfast_springboot.Controller;

import com.gl.payfast_springboot.Entity.Account;
import com.gl.payfast_springboot.Entity.Transaction;
import com.gl.payfast_springboot.Exceptions.AccountNotFoundException;
import com.gl.payfast_springboot.Service.AccountService;
import com.gl.payfast_springboot.Service.KafkaService.BasicConsumerService;
import com.gl.payfast_springboot.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    BasicConsumerService basicConsumerService;
    @Autowired
    TransactionService transactionService;

    @Autowired
    AccountService accountService;

    @PostMapping("/add")
    public String transaction(@RequestBody Transaction transaction) throws AccountNotFoundException {
        Account account = accountService.getAccountById(transaction.getAccountId());
        if (account == null) {
            throw new AccountNotFoundException("Account not found with id: " + transaction.getAccountId());
        }
        transactionService.createtransaction(transaction);
        return "Transaction done successfully";
    }
    @GetMapping("/ConsumerService")
    public String consumerService() {
       return  basicConsumerService.getLastconsumeMessage();
    }



}
