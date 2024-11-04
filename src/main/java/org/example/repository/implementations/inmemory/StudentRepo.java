package org.example.repository.implementations.inmemory;

import org.example.entities.Student;
import org.example.repository.interfaces.IStudentRepo;

import java.util.List;

public class StudentRepo implements IStudentRepo {
    private List<Student> students;
    public StudentRepo(List<Student> students) {
        this.students = students;
    }

    @Override
    public Student getStudent(Long id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    @Override
    public void addStudent(Student student) {
        students.add(student);
    }

    @Override
    public void updateStudent(Student student) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(student.getId())) {
                students.set(i, student);
            }
        }
    }

    @Override
    public void deleteStudent(Long id) {
        students.removeIf(student -> student.getId().equals(id));
    }

    @Override
    public List<Student> getAllStudents() {
        return students;
    }
}