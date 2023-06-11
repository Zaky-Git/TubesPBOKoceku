package com.koceku.koceku.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koceku.koceku.Model.*;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    List<Transaction> findByEwalletIdAndMethod(int ewalletId, String method);

    List<Transaction> findByEwalletId(int ewalletId);

}
