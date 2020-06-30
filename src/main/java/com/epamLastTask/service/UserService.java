package com.epamLastTask.service;

import com.epamLastTask.entities.User;

public interface UserService {

  int saveUser(User user);
  boolean checkPassport(String passNumb);
  boolean isAdmin(User user);
  User findUserById(Long id);
  User getAuthenticationUser();
}
