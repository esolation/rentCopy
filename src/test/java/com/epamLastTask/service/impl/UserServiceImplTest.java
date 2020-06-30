package com.epamLastTask.service.impl;

import com.epamLastTask.entities.User;
import com.epamLastTask.entities.enums.Role;
import com.epamLastTask.repositories.UserRepo;
import com.epamLastTask.service.UserService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class UserServiceImplTest {

    @Autowired
    private UserServiceImpl userService;
    @MockBean
    private UserRepo userRepo;

    @Test
    void shouldCheckIfUserIsAdmin() {
        User user = new User();
        user.setRole(Collections.singleton(Role.ADMIN));
        Assert.assertTrue(userService.isAdmin(user));
    }

    @Test
    void shouldFindMatchesInPassNumb(){
        String passport = "KH11111";
        Assert.assertTrue(userService.checkPassport(passport));
    }


}