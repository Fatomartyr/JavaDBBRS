package org.example.view;

import org.example.commands.Command;
import org.example.commands.CommandsList;
import org.example.provider.DataProvider;
import org.example.commands.CommandFactory;

import java.util.Scanner;

public class AdminView implements IConsoleView {
    private final CommandFactory commandFactory;
    private final Scanner scanner;

    public AdminView(DataProvider dataProvider, Scanner scanner) {
        this.scanner = scanner;
        this.commandFactory = new CommandFactory(dataProvider, scanner);
    }

    @Override
    public void display() {
        handleChoice();
    }

    private void handleChoice() {
        System.out.println("Select an admin command");
        CommandsList[] commands = CommandsList.values();
        for (int i = 0; i < commands.length; i++) {
            if (commands[i].getViewType() == ViewType.ADMIN) {
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
        while (commandIndex < 1 || commandIndex > 10) {
            System.out.println("Invalid command number! Try again");
            commandIndex = scanner.nextInt();
        }
        scanner.nextLine();
        try {
            CommandsList commandType = commands[commandIndex];
            if (commandType.getViewType() == ViewType.ADMIN) {
                System.out.println(commandIndex);
                System.out.println(commandType.name());
                Command command = commandFactory.getCommand(commandType);
                command.execute();
            } else {
                System.out.println("Invalid command for AdminView");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid command");
        }
    }
}
