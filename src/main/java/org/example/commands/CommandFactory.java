package org.example.commands;

import org.example.commands.admincommands.*;
import org.example.commands.admincommands.GetAllUsersCommand;
import org.example.commands.admincommands.GetUserCommand;
import org.example.commands.studentcommands.GetStudentAttendanceCommand;
import org.example.commands.usercommands.AccessCommand;
import org.example.provider.DataProvider;

import java.util.HashMap;
import java.util.Map;
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
        commands.put(CommandsList.addUser, new AddUserCommand(dataProvider, scanner));
        commands.put(CommandsList.accessControl, new AccessCommand(dataProvider, scanner));
        commands.put(CommandsList.updateUser, new UpdateUserCommand(dataProvider, scanner));
        commands.put(CommandsList.deleteUser, new DeleteUserCommand(dataProvider, scanner));
        commands.put(CommandsList.getStudentAttendance, new GetStudentAttendanceCommand(dataProvider, scanner));
    }

    public Command getCommand(CommandsList command) {
        return commands.get(command);
    }

}
