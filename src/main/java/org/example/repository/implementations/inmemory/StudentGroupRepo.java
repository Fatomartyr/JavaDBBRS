package org.example.repository.implementations.inmemory;

import org.example.entities.StudentGroup;
import org.example.repository.interfaces.IStudentGroupRepo;

import java.util.ArrayList;
import java.util.List;

public class StudentGroupRepo implements IStudentGroupRepo {
    private List<StudentGroup> studentsGroups;

    public StudentGroupRepo(List<StudentGroup> studentsGroups) {
        this.studentsGroups = studentsGroups;
    }

    @Override
    public StudentGroup getStudentGroup(Long studentId, Long groupId) {
        for (StudentGroup studentGroup : studentsGroups) {
            if (studentGroup.getStudentId().equals(studentId) && studentGroup.getGroupId().equals(groupId)) {
                return studentGroup;
            }
        }
        return null;
    }

    @Override
    public List<StudentGroup> getStudentsInGroups(Long groupId) {
        List<StudentGroup> studentsInGroups = new ArrayList<>();
        for (StudentGroup studentGroup : studentsGroups) {
            if (studentGroup.getGroupId().equals(groupId)) {
                studentsInGroups.add(studentGroup);
            }
        }
        return studentsInGroups;
    }

    @Override
    public void addStudentGroup(StudentGroup studentGroup) {
        studentsGroups.add(studentGroup);
    }

    @Override
    public void updateStudentGroup(StudentGroup studentGroup) {
        for (int i =0; i < studentsGroups.size(); i++) {
            if (studentsGroups.get(i).getStudentId().equals(studentGroup.getStudentId()) &&
                    studentsGroups.get(i).getGroupId().equals(studentGroup.getGroupId())) {
                studentsGroups.set(i, studentGroup);
            }
        }

    }

    @Override
    public void deleteStudentGroup(Long studentId, Long groupId) {
        studentsGroups.removeIf(studentGroup ->
                studentGroup.getStudentId().equals(studentId) && studentGroup.getGroupId().equals(groupId));
    }
}
