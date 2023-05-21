package com.koceku.koceku.Repository;

import com.koceku.koceku.Model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByphoneNumber(String phoneNumber);

    boolean existsByphoneNumber(String phoneNumber);

    User save(User user);

    User findByname(String name);
}
