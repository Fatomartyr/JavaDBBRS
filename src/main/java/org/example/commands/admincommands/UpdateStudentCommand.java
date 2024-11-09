package org.example.commands.admincommands;

import org.example.commands.Command;
import org.example.entities.Student;
import org.example.provider.DataProvider;

import java.lang.reflect.Method;
import java.util.Scanner;
import java.util.regex.Pattern;

import static org.example.commands.admincommands.ParseStudent.parseStudent;

public class UpdateStudentCommand implements Command {

    private final DataProvider dataProvider;
    private final Scanner scanner;

    public UpdateStudentCommand(DataProvider dataProvider, Scanner scanner) {
        this.dataProvider = dataProvider;
        this.scanner = scanner;
    }

    private static final Pattern NAME_PATTERN = Pattern.compile("^[A-Za-zА-Яа-яЁё\\s-]{2,50}$");
    private static final Pattern PHONE_PATTERN = Pattern.compile("^\\+?7\\d{10}$");
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[\\w.-]+@[A-Za-z\\d]+\\.[A-Za-z]{2,6}$");

    @Override
    public void execute() {

        try {
            String input;
            int studentId;

            do {
                System.out.print("Enter student details (id, name, phone, email): ");
                input = scanner.nextLine();

                String[] parts = input.split(", ");
                if (parts.length < 4) {
                    System.out.println("Invalid input format. Please provide id, name, phone, email.");
                    continue;
                }

                try {
                    studentId = Integer.parseInt(parts[0].trim());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid student ID format. ID should be a number.");
                    continue;
                }

                if (studentId > dataProvider.getStudentService().getMaxStudentId() || studentId < 0) {
                    System.out.println("Invalid student ID");
                    continue;
                }
                break;
            } while (true);
            Student student = parseStudent(input);
            if (NAME_PATTERN.matcher(student.getStudentName()).matches()) {
                if (PHONE_PATTERN.matcher(student.getStudentPhone()).matches()) {
                    if (EMAIL_PATTERN.matcher(student.getStudentEmail()).matches()) {
                        Method method = dataProvider.getStudentService().getClass().getDeclaredMethod("updateStudent", Student.class);
                        method.invoke(dataProvider.getStudentService(), student);
                        System.out.println("Student updated: " + student);
                    } else {
                        System.out.println("Invalid email format. Please enter a valid email address.");
                    }
                } else {
                    System.out.println("Invalid phone format. Phone should start with '7' and contain exactly 11 digits.");
                }
            } else {
                System.out.println("Invalid name format. Name should contain only" +
                        " letters, spaces, and hyphens, and be 2 to 50 characters long.");
            }
        } catch (NoSuchMethodException e) {
            System.out.println("Method updateStudent not found");
        } catch (Exception e) {
            System.out.println("Error updating student");
        }
    }
}
