package com.koceku.koceku.Repositories;

import com.koceku.koceku.Model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public interface UserRepository extends JpaRepository<User, Long> {

    User findByphoneNumber(String phoneNumber);

    boolean existsByphoneNumber(String phoneNumber);

    User save(User user);

    User findByname(String name);
}
