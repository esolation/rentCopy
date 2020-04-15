package com.epamLastTask.service;

import com.epamLastTask.entities.User;

public interface UserService {
    void save(User user);
    boolean userIsAvailable(User user);
}
