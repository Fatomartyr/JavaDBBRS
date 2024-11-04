package org.example.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentCourse {
    private Long studentId;
    private Long courseId;
    public StudentCourse(Long studentId, Long courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }
    @Override
    public String toString() {
        return "StudentCourse { studentId = " + studentId + ", courseId = " + courseId + "}";
    }
}
