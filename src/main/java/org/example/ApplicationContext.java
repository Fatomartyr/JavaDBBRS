package org.example;

import lombok.Getter;
import lombok.Setter;
import org.example.entities.Role;
import org.example.entities.User;


public class ApplicationContext {
    @Getter
    @Setter
    private static User user;
    @Getter
    @Setter
    private static Role role;

}
