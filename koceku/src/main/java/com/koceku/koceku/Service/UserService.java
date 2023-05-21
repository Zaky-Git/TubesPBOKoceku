// package com.koceku.koceku.Service;
// package com.koceku.Service;
// package com.koceku.koceku;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;

// import com.koceku.koceku.Model.Ewallet;
// import com.koceku.koceku.Model.User;

// @Service
// public class UserService {

// private UserRepository userRepository;

// @Autowired
// public UserService(UserRepository userRepository) {
// this.userRepository = userRepository;
// }

// @Autowired
// private EwalletRepository ewalletRepository;

// @Transactional
// public void signUp(String nama, String email, String phoneNumber) {
// Ewallet ewallet = new Ewallet();
// User user = new User(nama, email, phoneNumber, ewallet);
// userRepository.save(user);
// ewalletRepository.save(ewallet);
// }
// }
