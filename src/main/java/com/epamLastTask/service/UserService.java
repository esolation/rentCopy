package com.epamLastTask.service;

import com.epamLastTask.entities.User;

public interface UserService {

  boolean saveUser(User user);
  boolean isAdmin(User user);
  User findUserById(Long id);
  User getAuthenticationUser();
}
