package org.example.commands.admincommands;

import org.example.commands.Command;
import org.example.entities.User;
import org.example.provider.DataProvider;

import java.lang.reflect.Method;
import java.util.Scanner;
import java.util.regex.Pattern;

import static org.example.auxiliaryclasses.PasswordUtil.hashPassword;
import static org.example.commands.admincommands.ParseUser.parseUser;

public class UpdateUserCommand  implements Command {
    private final DataProvider dataProvider;
    private final Scanner scanner;

    public UpdateUserCommand(DataProvider dataProvider, Scanner scanner) {
        this.dataProvider = dataProvider;
        this.scanner = scanner;
    }

    private static final Pattern NAME_PATTERN = Pattern.compile("^[A-Za-zА-Яа-яЁё\\d\\s-]{4,16}$");

    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^(?=(?:\\D*\\d){2})[A-Za-z\\d]{8,}$");

    @Override
    public void execute() {
        try {
            String input;
            int userId;

            do {
                System.out.print("Enter updated user details (id, name, password): ");
                input = scanner.nextLine();

                String[] parts = input.split(", ");
                if (parts.length < 3) {
                    System.out.println("Invalid input format. Please provide id, name, and password.");
                    continue;
                }

                try {
                    userId = Integer.parseInt(parts[0].trim());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid user ID format. ID should be a number.");
                    continue;
                }

                if (userId > dataProvider.getUserService().getMaxUserId() || userId < 0) {
                    System.out.println("Invalid user ID");
                    continue;
                }
                break;
            } while (true);
            User user = parseUser(input);
            if (NAME_PATTERN.matcher(user.getName()).matches()) {
                if (PASSWORD_PATTERN.matcher(user.getPassword()).matches()) {
                    user.setPassword(hashPassword(user.getPassword()));
                    Method method =
                            dataProvider.getUserService().getClass().getDeclaredMethod("updateUser", User.class);
                    method.invoke(dataProvider.getUserService(), user);
                    System.out.println("User updated: " + user);
                } else {
                    System.out.println("Invalid password." +
                            " Password must be at least 8 characters long and contain at least 2 digits.");
                }
            } else {
                System.out.println("Invalid name format. Name should contain from 4 to 16 characters long.");
            }
        } catch (NoSuchMethodException e) {
            System.out.println("Method updateUser not found");
        } catch (Exception e) {
            System.out.println("Error updating user");
        }
    }
}
