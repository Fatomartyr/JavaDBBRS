package org.example.commands.admincommands;

import org.example.commands.Command;
import org.example.provider.DataProvider;

import java.lang.reflect.Method;
import java.util.Scanner;

public class DeleteUserCommand implements Command {
    private final DataProvider dataProvider;
    private final Scanner scanner;

    public DeleteUserCommand(DataProvider dataProvider, Scanner scanner) {
        this.dataProvider = dataProvider;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        try {
            System.out.print("Enter user ID to delete: ");
            String input = scanner.nextLine();
            Long userId = Long.parseLong(input);
            Method method = dataProvider.getUserService().getClass().getDeclaredMethod("deleteUser", Long.class);
            method.invoke(dataProvider.getUserService(), userId);
            System.out.println("User with ID " + userId + " has been deleted.");
        } catch (NoSuchMethodException e) {
            System.out.println("Method deleteUser not found");
        } catch (Exception e) {
            System.out.println("Error deleting student");
        }
    }
}
