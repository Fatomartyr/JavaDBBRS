package org.example.services;

import org.example.entities.Student;
import org.example.repository.implementations.inmemory.StudentRepo;
import org.example.repository.interfaces.IStudentRepo;

import java.util.List;

public class StudentService {
    private IStudentRepo studentRepo;
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }
    public Student getStudent(Long id) {
        return studentRepo.getStudent(id);
    }
    public void addStudent(Student student) {
        studentRepo.addStudent(student);
    }
    public void updateStudent(Student student) {
        studentRepo.updateStudent(student);
    }
    public void deleteStudent(Long id) {
        studentRepo.deleteStudent(id);
    }
    public List<Student> getAllStudents() {
        return studentRepo.getAllStudents();
    }
    public Long getMaxStudentId() {
        return studentRepo.getAllStudents().stream().map(Student::getId).max(Long::compare).orElse(0L);
    }
}
