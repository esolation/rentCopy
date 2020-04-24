package com.epamLastTask.service.impl;

import com.epamLastTask.entities.User;
import com.epamLastTask.entities.enums.Role;
import com.epamLastTask.repositories.UserRepo;
import com.epamLastTask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
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
    public boolean saveUser(User user) {
        if(userRepo.findByUsername(user.getUsername()) ==null && userRepo.findUserByEmail(user.getEmail())==null) {
            user.setRole(Collections.singleton(Role.USER));
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepo.save(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean isAdmin(User user) {
        return user.getRole().contains(Role.ADMIN);
    }
}
