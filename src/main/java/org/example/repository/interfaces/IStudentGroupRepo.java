package org.example.repository.interfaces;

import org.example.entities.StudentGroup;

import java.util.List;

public interface IStudentGroupRepo {
    StudentGroup getStudentGroup(Long studentId, Long groupId);
    List<StudentGroup> getStudentsInGroups(Long groupId);
    void addStudentGroup(StudentGroup studentGroup);
    void updateStudentGroup(StudentGroup studentGroup);
    void deleteStudentGroup(Long studentId, Long groupId);
}
