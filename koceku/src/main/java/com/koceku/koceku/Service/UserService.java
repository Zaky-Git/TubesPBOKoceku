package com.koceku.koceku.Service;

import org.springframework.stereotype.Service;

import com.koceku.koceku.Model.User;
import com.koceku.koceku.Repository.UserRepository;

@Service
public class UserService {
    
    UserRepository repo;

    public void SignUp(User user){
        repo.saveAndFlush(user);
    }
}
