package org.example.commands.studentcommands;

import org.example.commands.Command;
import org.example.entities.Student;
import org.example.provider.DataProvider;

import java.lang.reflect.Method;
import java.util.Scanner;

import static org.example.commands.studentcommands.ParseStudent.parseStudent;

public class UpdateStudentCommand implements Command {

    private final DataProvider dataProvider;
    private final Scanner scanner;

    public UpdateStudentCommand(DataProvider dataProvider, Scanner scanner) {
        this.dataProvider = dataProvider;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        try {
            System.out.print("Enter updated student details (id, name, phone, email): ");
            String input = scanner.nextLine();
            Student student = parseStudent(input);
            Method method = dataProvider.getStudentService().getClass().getDeclaredMethod("updateStudent", Student.class);
            method.invoke(dataProvider.getStudentService(), student);
            System.out.println("Student updated: " + student);
        } catch (NoSuchMethodException e) {
            System.out.println("Method updateStudent not found");
        } catch (Exception e) {
            System.out.println("Error updating student");
        }
    }

}
