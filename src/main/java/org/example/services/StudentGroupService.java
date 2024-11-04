package org.example.services;

import org.example.entities.StudentGroup;
import org.example.repository.implementations.inmemory.StudentGroupRepo;
import org.example.repository.interfaces.IStudentGroupRepo;

import java.util.List;

public class StudentGroupService {
    private IStudentGroupRepo studentGroupRepo;
    public StudentGroupService(StudentGroupRepo studentGroupRepo) {
        this.studentGroupRepo = studentGroupRepo;
    }
    public StudentGroup getStudentGroup(Long studentId, Long groupId) {
        return studentGroupRepo.getStudentGroup(studentId, groupId);
    }
    public List<StudentGroup> getStudentsInGroups(Long groupId) {
        return studentGroupRepo.getStudentsInGroups(groupId);
    }
    public void addStudentGroup(StudentGroup studentGroup) {
        studentGroupRepo.addStudentGroup(studentGroup);
    }
    public void updateStudentGroup(StudentGroup studentGroup) {
        studentGroupRepo.updateStudentGroup(studentGroup);
    }
    public void deleteStudentGroup(Long studentId, Long groupId) {
        studentGroupRepo.deleteStudentGroup(studentId, groupId);
    }
}
