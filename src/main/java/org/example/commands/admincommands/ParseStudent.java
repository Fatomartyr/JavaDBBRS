package org.example.commands.admincommands;

import org.example.entities.Student;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParseStudent {

    public static Student parseStudent(String input) {
        String[] parts = input.split(",");
        if (parts.length < 5) {
            throw new IllegalArgumentException("Incorrect number of arguments. Expected at least 5 values.");
        }
        Long id = Long.parseLong(parts[0].trim());
        List<Long> subjectIds = Arrays.stream(parts[1].trim().split(" "))
                .map(Long::parseLong)
                .collect(Collectors.toList());
        String name = parts[2].trim();
        String phone = parts[3].trim();
        String email = parts[4].trim();
        if (name.isEmpty() || phone.isEmpty() || email.isEmpty()) {
            throw new IllegalArgumentException("name, phone, and email cannot be empty.");
        }
        return new Student(id, subjectIds, name, phone, email);
    }
}
