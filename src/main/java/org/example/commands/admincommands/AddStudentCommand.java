package org.example.commands.studentcommands;

import org.example.commands.Command;
import org.example.entities.Student;
import org.example.provider.DataProvider;

import java.lang.reflect.Method;
import java.util.Scanner;
import java.util.regex.Pattern;

import static org.example.commands.studentcommands.ParseStudent.parseStudent;

public class AddStudentCommand implements Command {
    private final DataProvider dataProvider;
    private final Scanner scanner;

    public AddStudentCommand(DataProvider dataProvider, Scanner scanner) {
        this.dataProvider = dataProvider;
        this.scanner = scanner;
    }

    private static final Pattern NAME_PATTERN = Pattern.compile("^[A-Za-zА-Яа-яЁё\\s-]{2,50}$");
    private static final Pattern PHONE_PATTERN = Pattern.compile("^\\+?7\\d{10}$");
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[\\w.-]+@[A-Za-z\\d]+\\.[A-Za-z]{2,6}$");

    @Override
    public void execute() {
        try {
            System.out.print("Enter student details (id, name, phone, email): ");
            String input = scanner.nextLine();
            Student student = parseStudent(input);
            if (NAME_PATTERN.matcher(student.getStudentName()).matches()) {
                if (PHONE_PATTERN.matcher(student.getStudentPhone()).matches()) {
                    if (EMAIL_PATTERN.matcher(student.getStudentEmail()).matches()) {
                        if (dataProvider.getStudentService().getStudent(student.getId()) == null) {
                            Long maxId = dataProvider.getStudentService().getMaxStudentId();
                            if (student.getId() == maxId + 1) {
                                Method method = dataProvider.getStudentService().getClass().getDeclaredMethod("addStudent", Student.class);
                                method.invoke(dataProvider.getStudentService(), student);
                                System.out.println("Student added: " + student);
                            } else {
                                System.out.println("Invalid ID sequence. The ID should be " + (maxId + 1));
                            }
                        } else {
                            System.out.println("Student with ID " + student.getId() + " already exists. Please use a different ID.");
                        }
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
            System.out.println("Method addStudent not found");
        } catch (Exception e) {
            System.out.println("Error adding student");
        }
    }

}
