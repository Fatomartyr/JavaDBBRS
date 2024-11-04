package org.example.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {
    private Long id;
    private String studentName;
    private String studentPhone;
    private String studentEmail;

    public Student(Long id, String studentName, String studentPhone, String studentEmail) {
        this.id = id;
        this.studentName = studentName;
        this.studentPhone = studentPhone;
        this.studentEmail = studentEmail;
    }

    @Override
    public String toString() {
        return "Student {id=" + id + ", studentName=" + studentName +
                ", studentPhone=" + studentPhone + ", studentEmail=" + studentEmail + "}";
    }
}
