package com.koceku.koceku.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koceku.koceku.Model.Ewallet;

@Repository
public interface EwalletRepository extends JpaRepository<Ewallet, Integer> {
}
