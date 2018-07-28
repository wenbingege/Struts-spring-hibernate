package com.ssh.service;

import com.ssh.modle.User;

public interface UserService {
    boolean addUser(User user);
    User selectUser(int id);
    boolean deleteUser(int id);
    boolean updateUser(User user);
    boolean login(String username,String password);
}
