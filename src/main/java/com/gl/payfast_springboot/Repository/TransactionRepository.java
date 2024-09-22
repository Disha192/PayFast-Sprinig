package com.gl.payfast_springboot.Repository;

import com.gl.payfast_springboot.Entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TransactionRepository extends JpaRepository<Transaction,Long> {
}
