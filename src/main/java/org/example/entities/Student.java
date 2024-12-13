package org.example.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Student {
    private Long id;
    private List<Long> subjectIds;
    private String studentName;
    private String studentPhone;
    private String studentEmail;

    public Student(Long id, List<Long> subjectIds, String studentName, String studentPhone, String studentEmail) {
        this.id = id;
        this.subjectIds = subjectIds;
        this.studentName = studentName;
        this.studentPhone = studentPhone;
        this.studentEmail = studentEmail;
    }

    @Override
    public String toString() {
        return "Student {id=" + id + ", subjectIds=" + subjectIds + ", studentName=" + studentName +
                ", studentPhone=" + studentPhone + ", studentEmail=" + studentEmail + "}";
    }
}
