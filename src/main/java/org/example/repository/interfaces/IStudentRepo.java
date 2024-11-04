package org.example.repository.interfaces;

import org.example.entities.Student;

import java.util.List;


public interface IStudentRepo {
    Student getStudent(Long id);
    void addStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(Long id);
    List<Student> getAllStudents();
}
