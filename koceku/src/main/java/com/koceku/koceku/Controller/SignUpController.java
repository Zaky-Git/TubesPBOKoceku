// package com.koceku.koceku.Controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import com.koceku.koceku.Repositories.*;
// import com.koceku.koceku.Model.*;

// @Controller
// @RequestMapping("/signup")
// public class SignUpController {

// @Autowired
// private UserRepository userRepository;

// @PostMapping
// public String signup(User user) {
// // Lakukan validasi data pengguna jika diperlukan
// // Contoh: Validasi email yang unik

// // Simpan data pengguna ke dalam database
// userRepository.save(user);

// // Redirect ke halaman login atau ke halaman lain yang sesuai
// return "redirect:/login";
// }
// }
