package org.example.commands.studentcommands;

import org.example.commands.Command;
import org.example.provider.DataProvider;

import java.lang.reflect.Method;
import java.util.Scanner;

public class GetStudentAttendanceCommand implements Command {
    private final DataProvider dataProvider;
    private final Scanner scanner;

    public GetStudentAttendanceCommand(DataProvider dataProvider, Scanner scanner) {
        this.dataProvider = dataProvider;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        try {
            System.out.println("Enter student ID and subject name: ");
            Long studentId = Long.parseLong(scanner.nextLine());
            String subjectName = scanner.nextLine();
            Method method = dataProvider.getStudentService().getClass().
                    getDeclaredMethod("getAttendance", Long.class, String.class);
            Object result = method.invoke(dataProvider.getStudentService(), studentId, subjectName);
            System.out.println(subjectName + " attendance: " + result);
        } catch (Exception e) {
            System.out.println("Error with executing getAttendance method.");
        }
    }
}
