package org.example.commands.admincommands;

import org.example.commands.Command;
import org.example.provider.DataProvider;

import java.lang.reflect.Method;
import java.util.Scanner;

public class GetStudentCommand implements Command {
    private final DataProvider dataProvider;
    private final Scanner scanner;

    public GetStudentCommand(DataProvider dataProvider, Scanner scanner) {
        this.dataProvider = dataProvider;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        try {
            System.out.print("Enter student ID: ");
            Long studentId = Long.parseLong(scanner.nextLine());
            System.out.println("Searching for student with ID: " + studentId);
            Method method = dataProvider.getStudentService().getClass().getDeclaredMethod("getStudent", Long.class);
            Object result = method.invoke(dataProvider.getStudentService(), studentId);
            if (result != null) {
                System.out.println("Student found: " + result);
            } else {
                System.out.println("Student not found with ID: " + studentId);
            }
        } catch (Exception e) {
            System.out.println("Error executing getStudent");
        }
    }
}
