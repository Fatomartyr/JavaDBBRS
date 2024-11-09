package org.example.commands;

import lombok.Getter;
import org.example.view.ViewType;

@Getter
public enum CommandsList {

    accessControl(ViewType.USER),
    getStudent(ViewType.ADMIN),
    addStudent(ViewType.ADMIN),
    updateStudent(ViewType.ADMIN),
    deleteStudent(ViewType.ADMIN),
    getAllStudents(ViewType.ADMIN),

    getUser(ViewType.ADMIN),
    addUser(ViewType.ADMIN),
    updateUser(ViewType.ADMIN),
    deleteUser(ViewType.ADMIN),
    getAllUsers(ViewType.ADMIN),
    getStudentAttendance(ViewType.STUDENT);
    private final ViewType viewType;

    CommandsList(ViewType viewType) {
        this.viewType = viewType;
    }

}
