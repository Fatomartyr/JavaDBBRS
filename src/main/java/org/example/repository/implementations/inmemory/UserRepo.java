package org.example.repository.implementations.inmemory;

import org.example.entities.User;
import org.example.repository.interfaces.IUserRepo;

import java.util.List;

public class UserRepo implements IUserRepo {
    private List<User> users;
    public UserRepo(List<User> users) {
        this.users = users;
    }
    @Override
    public User getUser(Long id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void updateUser(User user) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(user.getId())) {
                users.set(i, user);
                return;
            }
        }
    }

    @Override
    public void deleteUser(Long id) {
        users.removeIf(user -> user.getId().equals(id));
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }
}





