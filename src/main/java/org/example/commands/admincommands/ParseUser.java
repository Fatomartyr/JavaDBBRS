package org.example.commands.admincommands;

import org.example.entities.User;

public class ParseUser {

    public static User parseUser(String input) {
        String[] parts = input.split(",");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Incorrect number of arguments. Expected 3 values.");
        }
        Long id = Long.parseLong(parts[0].trim());
        String name = parts[1].trim();
        String password = parts[2].trim();
        if (name.isEmpty() || password.isEmpty()) {
            throw new IllegalArgumentException("name, password cannot be empty.");
        }
        return new User(id, name, password);
    }
}
