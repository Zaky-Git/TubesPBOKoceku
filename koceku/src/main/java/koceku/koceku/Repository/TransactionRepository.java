package koceku.koceku.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import koceku.koceku.Model.*;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

}