package org.example.services;

import org.example.entities.Group;
import org.example.repository.implementations.inmemory.GroupRepo;
import org.example.repository.interfaces.IGroupRepo;

import java.util.List;

public class GroupService {
    private IGroupRepo groupRepo;
    public GroupService(GroupRepo groupRepo) {
        this.groupRepo = groupRepo;
    }
    public Group getGroup(Long id){
        return groupRepo.getGroup(id);
    }
    public List<Group> getGroupsByLecturerId(Long lecturerId){
        return groupRepo.getGroupsByLecturerId(lecturerId);
    }
    public void addGroup(Group group){
        groupRepo.addGroup(group);
    }
    public void updateGroup(Group group){
        groupRepo.updateGroup(group);
    }
    public void deleteGroup(Long id){
        groupRepo.deleteGroup(id);
    }
}
