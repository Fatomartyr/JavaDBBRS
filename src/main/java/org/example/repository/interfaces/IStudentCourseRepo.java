package org.example.repository.interfaces;

import org.example.entities.StudentCourse;

import java.util.List;

public interface IStudentCourseRepo {
    StudentCourse getStudentCourse(Long studentId, Long courseId);
    List<StudentCourse> getStudentsOnCourses(Long courseId);
    void addStudentCourse(StudentCourse studentCourse);
    void updateStudentCourse(StudentCourse studentCourse);
    void deleteStudentCourse(Long studentId, Long courseId);
}
