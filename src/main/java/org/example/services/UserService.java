package org.example.services;

import lombok.Getter;
import org.example.auxiliaryclasses.PasswordUtil;
import org.example.entities.Role;
import org.example.entities.User;
import org.example.repository.implementations.inmemory.RoleRepo;
import org.example.repository.implementations.inmemory.UserRepo;
import org.example.repository.interfaces.IRoleRepo;
import org.example.repository.interfaces.IUserRepo;

import java.util.List;


public class UserService {
    private IUserRepo userRepo;
    @Getter
    private IRoleRepo roleRepo;
    public UserService(UserRepo userRepo, RoleRepo roleRepo) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
    }
    public User getUser(Long userId) {
        return userRepo.getUser(userId);
    }
    public void addUser(User user) {
        userRepo.addUser(user);
    }
    public void updateUser(User user) {
        userRepo.updateUser(user);
    }
    public void deleteUser(Long userId) {
        userRepo.deleteUser(userId);
    }

    public List<User> getAllUsers() {
        return userRepo.getAllUsers();
    }

    public Role authorization(Long userId) {
        User user = userRepo.getUser(userId);
        if (user == null) {
            return null;
        }
        return roleRepo.getRole(userId);
    }

    public Boolean authentication(String name, String password) {
        List<User> users = userRepo.getAllUsers();
        for (User user : users) {
            if (user.getName().equals(name) && checkPassword(password, user.getPassword())) {
                return true;
            }
        }
        return false;
    }

    public Boolean checkPassword(String rawPassword, String hashedPassword) {
        return PasswordUtil.checkPassword(rawPassword, hashedPassword);
    }

    public Long getMaxUserId() {
        return userRepo.getAllUsers().stream().map(User::getId).max(Long::compare).orElse(0L);
    }
    public Long getMaxRoleId() {
        return roleRepo.getAllRoles().stream().map(Role::getRoleId).max(Long::compare).orElse(0L);
    }
}
