package org.example.commands.studentcommands;

import org.example.commands.Command;
import org.example.entities.Student;
import org.example.provider.DataProvider;

import java.lang.reflect.Method;
import java.util.List;

public class GetAllStudentsCommand implements Command {
    private final DataProvider dataProvider;

    public GetAllStudentsCommand(DataProvider dataProvider) {
        this.dataProvider = dataProvider;
    }

    @Override
    public void execute() {
        try {
            Method method = dataProvider.getStudentService().getClass().getDeclaredMethod("getAllStudents");
            @SuppressWarnings("unchecked")
            List<Student> students = (List<Student>) method.invoke(dataProvider.getStudentService());

            if (students.isEmpty()) {
                System.out.println("No students found.");
            }
            else {
                StringBuilder result = new StringBuilder("Student List:\n");
                for (Student student : students) {
                    result.append(student).append("\n");
                }
                System.out.println(result);
            }
        } catch (NoSuchMethodException e) {
            System.out.println("Method getAllStudents not found");
        } catch (Exception e) {
            System.out.println("Error retrieving student list");
        }
    }
}
