package com.selvigtech.jwtauth.service;

import com.selvigtech.jwtauth.domain.Role;
import com.selvigtech.jwtauth.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String userName, String roleName);
    User getUser(String username);
    List<User>getUsers();
}
