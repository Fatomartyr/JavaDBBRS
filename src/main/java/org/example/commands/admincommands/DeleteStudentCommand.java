package org.example.commands.studentcommands;

import org.example.commands.Command;
import org.example.provider.DataProvider;

import java.lang.reflect.Method;
import java.util.Scanner;

public class DeleteStudentCommand implements Command {
    private final DataProvider dataProvider;
    private final Scanner scanner;
    public DeleteStudentCommand(DataProvider dataProvider, Scanner scanner) {
        this.dataProvider = dataProvider;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        try {
            System.out.print("Enter student ID to delete: ");
            String input = scanner.nextLine();
            Long studentId = Long.parseLong(input);
            Method method = dataProvider.getStudentService().getClass().getDeclaredMethod("deleteStudent", Long.class);
            method.invoke(dataProvider.getStudentService(), studentId);
            System.out.println("Student with ID " + studentId + " has been deleted.");
        } catch (NoSuchMethodException e) {
            System.out.println("Method deleteStudent not found");
        } catch (Exception e) {
            System.out.println("Error deleting student");
        }
    }
}
