package org.example.commands;

import org.example.commands.studentcommands.*;
import org.example.commands.usercommands.GetAllUsersCommand;
import org.example.commands.usercommands.GetUserCommand;
import org.example.commands.usercommands.accesscontrol.AccessCommand;
import org.example.provider.DataProvider;
import org.example.entities.Role;
import org.example.view.StudentView;
import org.example.view.UserView;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class CommandFactory {
    private final Map<CommandsList, Command> commands = new HashMap<>();
    public CommandFactory(DataProvider dataProvider, Scanner scanner) {
        commands.put(CommandsList.getStudent, new GetStudentCommand(dataProvider, scanner));
        commands.put(CommandsList.addStudent, new AddStudentCommand(dataProvider, scanner));
        commands.put(CommandsList.updateStudent, new UpdateStudentCommand(dataProvider, scanner));
        commands.put(CommandsList.deleteStudent, new DeleteStudentCommand(dataProvider, scanner));
        commands.put(CommandsList.getAllStudents, new GetAllStudentsCommand(dataProvider));
        commands.put(CommandsList.getUser, new GetUserCommand(dataProvider, scanner));
        commands.put(CommandsList.getAllUsers, new GetAllUsersCommand(dataProvider));
        commands.put(CommandsList.accessControl, new AccessCommand(dataProvider, scanner, role -> {
            if (Objects.equals(role.getRoleName(), "Student")) {
                new StudentView(dataProvider, scanner).display();
            } else if (Objects.equals(role.getRoleName(), "User")) {
                new UserView(dataProvider, scanner).display();
            }
        }));
    }

    public Command getCommand(CommandsList command) {
        return commands.get(command);
    }

}
