package org.example.commands.admincommands;

import org.example.commands.Command;
import org.example.entities.Role;
import org.example.entities.User;
import org.example.provider.DataProvider;
import org.example.view.ViewType;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

import static org.example.auxiliaryclasses.PasswordUtil.hashPassword;
import static org.example.commands.admincommands.ParseUser.parseUser;

public class AddUserCommand implements Command {
    private final DataProvider dataProvider;
    private final Scanner scanner;

    public AddUserCommand(DataProvider dataProvider, Scanner scanner) {
        this.dataProvider = dataProvider;
        this.scanner = scanner;
    }

    private static final Pattern NAME_PATTERN = Pattern.compile("^[A-Za-zА-Яа-яЁё\\d\\s-]{4,16}$");

    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^(?=(?:\\D*\\d){2})[A-Za-z\\d]{8}$");

    @Override
    public void execute() {
        try {
            System.out.print("Enter user details (id, name, password): ");
            String input = scanner.nextLine();
            User user = parseUser(input);

            if (NAME_PATTERN.matcher(user.getName()).matches()) {
                if (PASSWORD_PATTERN.matcher(user.getPassword()).matches()) {
                    if (dataProvider.getUserService().getUser(user.getId()) == null) {
                        Long maxId = dataProvider.getUserService().getMaxUserId();
                        if (user.getId() == maxId + 1) {
                            user.setPassword(hashPassword(user.getPassword()));
                            Method method = dataProvider.getUserService().
                                    getClass().getDeclaredMethod("addUser", User.class);
                            method.invoke(dataProvider.getUserService(), user);
                            System.out.println("User added: " + user);
                            System.out.println("Enter the user role, one of the following roles: "
                                    + "Lecturer, Student, User, Admin ");
                            String inputRole = scanner.nextLine();
                            try {
                                ViewType role = ViewType.valueOf(inputRole.toUpperCase());
                                Long maxIdForRole = dataProvider.getUserService().getMaxRoleId();
                                dataProvider.getUserService().getRoleRepo().addRole
                                        (new Role(user.getId(), maxIdForRole + 1, inputRole));
                                System.out.println("Role added successfully: " + role);
                            } catch (IllegalArgumentException e) {
                            System.out.println("Invalid role. Please enter a valid role.");
                        }

                        } else {
                            System.out.println("Invalid ID sequence. The ID should be " + (maxId + 1));
                        }
                    } else {
                        System.out.println("User with ID " + user.getId() + " already exists. Please use a different ID.");
                    }
                } else {
                    System.out.println("Invalid password." +
                            " Password must be at least 8 characters long and contain at least 2 digits.");
                }
            } else {
                System.out.println("Invalid name format. Name should contain from 4 to 16 characters long.");
            }
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            System.out.println("Method addUser not found");
        } catch (IllegalAccessException e) {
            System.out.println("Error adding student");
        }
    }
}
