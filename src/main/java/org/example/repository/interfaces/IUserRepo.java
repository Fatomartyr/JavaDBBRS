package org.example.repository.interfaces;

import org.example.entities.User;

import java.util.List;

public interface IUserRepo {
    User getUser(Long id);
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(Long id);
    List<User> getAllUsers();
}
