package org.example.commands.studentcommands;

import org.example.entities.Student;

public class ParseStudent {

    public static Student parseStudent(String input) {
        String[] parts = input.split(",");
        if (parts.length != 4) {
            throw new IllegalArgumentException("Incorrect number of arguments. Expected 4 values.");
        }
        Long id = Long.parseLong(parts[0].trim());
        String name = parts[1].trim();
        String phone = parts[2].trim();
        String email = parts[3].trim();
        if (name.isEmpty() || phone.isEmpty() || email.isEmpty()) {
            throw new IllegalArgumentException("name, phone, and email cannot be empty.");
        }
        return new Student(id, name, phone, email);
    }
}
