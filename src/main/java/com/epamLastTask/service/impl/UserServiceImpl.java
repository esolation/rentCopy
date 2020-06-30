package com.epamLastTask.service.impl;

import com.epamLastTask.entities.User;
import com.epamLastTask.entities.enums.Role;
import com.epamLastTask.repositories.UserRepo;
import com.epamLastTask.service.UserService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;


@Service
public class UserServiceImpl implements UserDetailsService, UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepo.findByUsername(s);
    }

    @Override
    public int saveUser(User user) {
        if(userRepo.findByUsername(user.getUsername()) ==null && userRepo.findUserByEmail(user.getEmail())==null) {
            if(!checkPassport(user.getPassportNumb()))
                return 2;
            user.setRole(Collections.singleton(Role.USER));
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setPassportNumb(user.getPassportNumb().toUpperCase());
            userRepo.save(user);
            return 1;
        }
        return 0;
    }

    @Override
    public boolean checkPassport(String passNumb) {
        return passNumb.matches("^[а-яА-ЯёЁa-zA-Z0-9]+$");
    }

    @Override
    public boolean isAdmin(User user) {
        return user.getRole().contains(Role.ADMIN);
    }

    @Override
    public User findUserById(Long id) {
        return userRepo.findUserById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public User getAuthenticationUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) auth.getPrincipal();
        Hibernate.initialize(user.getOrder());
        return user;
    }


}
