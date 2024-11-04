package org.example.repository.interfaces;

import org.example.entities.Group;

import java.util.List;


public interface IGroupRepo {
    Group getGroup(Long id);
    List<Group> getGroupsByLecturerId(Long lecturerId);
    void addGroup(Group group);
    void updateGroup(Group group);
    void deleteGroup(Long id);
}
