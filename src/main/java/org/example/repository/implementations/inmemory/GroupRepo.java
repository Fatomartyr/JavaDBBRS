package org.example.repository.implementations.inmemory;

import org.example.entities.Group;
import org.example.repository.interfaces.IGroupRepo;

import java.util.ArrayList;
import java.util.List;

public class GroupRepo implements IGroupRepo {
    private List<Group> groups;
    public GroupRepo(List<Group> groups) {
        this.groups = groups;
    }

    @Override
    public Group getGroup(Long id) {
        for (Group group : groups) {
            if (group.getId().equals(id)) {
                return group;
            }
        }
        return null;
    }

    @Override
    public List<Group> getGroupsByLecturerId(Long lecturerId) {
        List<Group> groupsByLecturerId = new ArrayList<>();
        for (Group group : groups) {
            if (group.getLecturerId().equals(lecturerId)) {
                groupsByLecturerId.add(group);
            }
        }
        return groupsByLecturerId;
    }

    @Override
    public void addGroup(Group group) {
        groups.add(group);
    }

    @Override
    public void updateGroup(Group group) {
        for (int i = 0; i < groups.size(); i++) {
            if (groups.get(i).getId().equals(group.getId())) {
                groups.set(i, group);
            }
        }
    }

    @Override
    public void deleteGroup(Long id) {
        groups.removeIf(group -> group.getId().equals(id));
    }
}
