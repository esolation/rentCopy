package com.epamLastTask.service.impl;

import com.epamLastTask.entities.User;
import com.epamLastTask.repositories.UserRepo;
import com.epamLastTask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation= Propagation.REQUIRED, readOnly = true)
@Service
public class UserServiceImpl implements UserDetailsService, UserService {
    @Autowired
    private UserRepo userRepo;
    @Override

    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepo.findByUsername(s);
    }

    @Override
    public void save(User user) {
        userRepo.save(user);
    }

    @Override
    public boolean userIsAvailable(User user) {
        if(userRepo.findByUsername(user.getUsername()) ==null && userRepo.findUserByEmail(user.getEmail())==null)
            return true;
        return false;
    }
}
