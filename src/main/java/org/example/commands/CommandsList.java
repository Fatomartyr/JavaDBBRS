package org.example.commands;

import lombok.Getter;
import org.example.view.ViewType;

@Getter
public enum CommandsList {

    getStudent(ViewType.STUDENT),
    addStudent(ViewType.STUDENT),
    updateStudent(ViewType.STUDENT),
    deleteStudent(ViewType.STUDENT),
    getAllStudents(ViewType.STUDENT),

    getUser(ViewType.USER),
    addUser(ViewType.USER),
    updateUser(ViewType.USER),
    deleteUser(ViewType.USER),
    getAllUsers(ViewType.USER),

    accessControl(ViewType.BOTH);
    private final ViewType viewType;

    CommandsList(ViewType viewType) {
        this.viewType = viewType;
    }

}
