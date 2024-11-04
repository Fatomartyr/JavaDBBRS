package org.example.view;

import org.example.commands.Command;
import org.example.commands.CommandFactory;
import org.example.commands.CommandsList;
import org.example.entities.User;
import org.example.provider.DataProvider;

import java.util.Scanner;


public class UserView implements IConsoleView {
    private final CommandFactory commandFactory;
    private final Scanner scanner;

    public UserView(DataProvider dataProvider, Scanner scanner) {
        this.scanner = scanner;
        this.commandFactory = new CommandFactory(dataProvider, scanner);
    }

    @Override
    public void display() {
        handleChoice();
    }

    /*private static User getUser(String input) {
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
    }*/

    private void handleChoice() {
        System.out.println("Select a user command :");
        CommandsList[] commands = CommandsList.values();
        for (int i = 0; i < commands.length; i++) {
            if (commands[i].getViewType() == ViewType.USER ||
                    commands[i].getViewType() == ViewType.BOTH) {
                System.out.println(i + ": " + commands[i].name());
            }
        }
        System.out.print("Enter command number: ");
        int commandIndex = scanner.nextInt();
        scanner.nextLine();
        try {
            CommandsList commandType = commands[commandIndex];
            if (commandType.getViewType() == ViewType.USER ||
                    commandType.getViewType() == ViewType.BOTH) {
                Command command = commandFactory.getCommand(commandType);
                command.execute();
            } else {
                System.out.println("Invalid command for UserView");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid command");
        }
    }
}
