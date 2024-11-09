package org.example.view;

import org.example.commands.Command;
import org.example.commands.CommandFactory;
import org.example.commands.CommandsList;
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

    private void handleChoice() {
        System.out.println("Select a user command");
        CommandsList[] commands = CommandsList.values();
        for (int i = 0; i < commands.length; i++) {
            if (commands[i].getViewType() == ViewType.USER) {
                System.out.println(i + ": " + commands[i].name());
            }
        }
        System.out.print("Enter command number: ");
        while (true) {
            if (scanner.hasNextInt()) {
                break;
            }
            else {
                System.out.println("Invalid data. Please try to type command number again.");
                scanner.next();
            }
        }
        int commandIndex = scanner.nextInt();
        while (commandIndex != 0) {
            System.out.println("Invalid command number! Try again");
            commandIndex = scanner.nextInt();
        }
        scanner.nextLine();
        try {
            CommandsList commandType = commands[commandIndex];
            if (commandType.getViewType() == ViewType.USER) {
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
