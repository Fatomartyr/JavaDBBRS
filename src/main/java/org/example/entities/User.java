package org.example.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private Long id;
    private String name;
    private String password;

    public User(Long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }
    @Override
    public String toString() {
        return "User {id = " + id + ", name = " + name + ", password = " + password + "}";
    }
}
