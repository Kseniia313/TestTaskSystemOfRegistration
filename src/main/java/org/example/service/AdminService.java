package org.example.service;

import org.example.entity.User;

import java.util.List;

public interface AdminService {
    List<User> getAllUsers();

    List<User> findUserByUserName(String userName);

    void defineOperatorRole(User user);
}
