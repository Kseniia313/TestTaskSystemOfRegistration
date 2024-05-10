package org.example.service;

import org.example.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdminServiceImpl implements AdminService {
    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public List<User> findUserByUserName(String userName) {
        return null;
    }

    @Override
    public void defineOperatorRole(User user) {

    }
}
