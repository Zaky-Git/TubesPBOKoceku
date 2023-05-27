package com.koceku.koceku.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koceku.koceku.Model.Transaction;
import com.koceku.koceku.Model.User;
import com.koceku.koceku.Repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository repo;

    public void SignUp(User user) {
        repo.save(user);
    }

    public User findUserByEmail(String email) {
        try {
            User user1 = repo.findByEmail(email);
            return user1;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return null;
    }

}
