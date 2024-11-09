package org.example.commands.admincommands;

import org.example.commands.Command;
import org.example.provider.DataProvider;

import java.lang.reflect.Method;
import java.util.Scanner;

public class GetUserCommand implements Command {
    private final DataProvider dataProvider;
    private final Scanner scanner;

    public GetUserCommand(DataProvider dataProvider, Scanner scanner) {
        this.dataProvider = dataProvider;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        try {
            System.out.println("Enter user id: ");
            Long userId = Long.parseLong(scanner.nextLine());
            System.out.println("Searching for user with ID: " + userId);
            Method method = dataProvider.getUserService().getClass().getDeclaredMethod("getUser", Long.class);
            Object result = method.invoke(dataProvider.getUserService(), userId);
            if (result != null) {
                System.out.println("User found: " + result);
            } else {
                System.out.println("User not found with ID: " + userId);
            }
        } catch (Exception e) {
            System.out.println("Error executing getUser");
        }
    }
}
