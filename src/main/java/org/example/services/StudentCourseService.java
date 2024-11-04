package org.example.services;

import org.example.entities.StudentCourse;
import org.example.repository.implementations.inmemory.StudentCourseRepo;
import org.example.repository.interfaces.IStudentCourseRepo;

import java.util.List;

public class StudentCourseService {
    private IStudentCourseRepo studentCourseRepo;
    public StudentCourseService(StudentCourseRepo studentCourseRepo) {
        this.studentCourseRepo = studentCourseRepo;
    }
    public StudentCourse getStudentCourse(Long studentId, Long courseId) {
        return studentCourseRepo.getStudentCourse(studentId, courseId);
    }
    public List<StudentCourse> getStudentsOnCourses(Long courseId) {
        return studentCourseRepo.getStudentsOnCourses(courseId);
    }
    public void addStudentCourse(StudentCourse studentCourse) {
        studentCourseRepo.addStudentCourse(studentCourse);
    }
    public void updateStudentCourse(StudentCourse studentCourse) {
        studentCourseRepo.updateStudentCourse(studentCourse);
    }
    public void deleteStudentCourse(Long studentId, Long courseId) {
        studentCourseRepo.deleteStudentCourse(studentId, courseId);
    }
}
