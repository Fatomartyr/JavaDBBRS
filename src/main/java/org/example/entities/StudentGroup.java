package org.example.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentGroup {
    private Long studentId;
    private Long groupId;

    public StudentGroup(Long studentId, Long groupId) {
        this.studentId = studentId;
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return "StudentGroup = {studentId = " + studentId + ", groupId = " + groupId + "}";
    }
}
