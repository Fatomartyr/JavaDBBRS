package org.example.commands.usercommands;

import org.example.ApplicationContext;
import org.example.commands.Command;
import org.example.entities.Role;
import org.example.entities.User;
import org.example.provider.DataProvider;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

import static org.example.auxiliaryclasses.PasswordUtil.checkPassword;

public class AccessCommand implements Command {
    private final DataProvider dataProvider;
    private final Scanner scanner;


    public AccessCommand(DataProvider dataProvider, Scanner scanner) {
        this.dataProvider = dataProvider;
        this.scanner = scanner;

    }

    @Override
    public void execute() {
        try {
            boolean flag = false;
            Long userId = null;
            while (!flag) {
                System.out.println("Please enter your name:");
                String name = scanner.nextLine();
                System.out.println("Please enter your password:");
                String password = scanner.nextLine();
                Boolean isAuthenticated = dataProvider.getUserService().authentication(name, password);
                if (isAuthenticated) {
                    System.out.println("You have successfully logged in!");
                    for (User user : dataProvider.getUserService().getAllUsers()) {
                        if (user.getName().equals(name) && checkPassword(password, user.getPassword())) {
                            userId = user.getId();
                        }
                    }
                    flag = true;
                } else {
                    System.out.println("Error with log in. Try again.");
                }
            }
            Method method = dataProvider.getUserService().getClass().
                    getDeclaredMethod("authorization", Long.class);
            Role role = (Role) method.invoke(dataProvider.getUserService(), userId);
            if (role != null) {
                System.out.println("You get role: " + role.getRoleName());
            }
            else {
                System.out.println("Error with getting role");
            }
            User user = dataProvider.getUserService().getUser(userId);
            ApplicationContext.setUser(user);
            ApplicationContext.setRole(role);
            System.out.println("If you want to log off type: exit");
        } catch (NoSuchMethodException e) {
            System.out.println("Error executing access command");
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            System.out.println("Error occurred while invoking the method: " + cause.getMessage());
        } catch (IllegalAccessException e) {
            System.out.println("Access to the method is not allowed. Please check method visibility.");
        }
    }
}
