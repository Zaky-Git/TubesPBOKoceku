// package com.koceku.koceku.Security;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Configuration;
// import
// org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import
// org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import
// org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import
// org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.security.crypto.password.PasswordEncoder;

// @Configuration
// public class SecurityConfig extends WebSecurityConfigurerAdapter {

// @Autowired
// private PasswordEncoder passwordEncoder;

// protected void configure(HttpSecurity http) throws Exception {
// http
// .authorizeRequests()
// .antMatchers("/signup").permitAll()
// .anyRequest().authenticated()
// .and()
// .formLogin()
// .loginPage("/signin")
// .permitAll()
// .and()
// .logout()
// .permitAll();
// }

// @Autowired
// public void configureGlobal(AuthenticationManagerBuilder auth) throws
// Exception {
// auth
// .inMemoryAuthentication()
// .withUser("username")
// .password("password")
// .roles("USER");
// }

// }
