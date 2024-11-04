package org.example.repository.implementations.inmemory;

import org.example.entities.StudentCourse;
import org.example.repository.interfaces.IStudentCourseRepo;

import java.util.ArrayList;
import java.util.List;

public class StudentCourseRepo implements IStudentCourseRepo {
    private List<StudentCourse> studentsCourses;

    public StudentCourseRepo(List<StudentCourse> studentsCourses) {
        this.studentsCourses = studentsCourses;
    }

    @Override
    public StudentCourse getStudentCourse(Long studentId, Long courseId) {
        for (StudentCourse studentCourse : studentsCourses) {
            if (studentCourse.getStudentId().equals(studentId) && studentCourse.getCourseId().equals(courseId)) {
                return studentCourse;
            }
        }
        return null;
    }

    @Override
    public List<StudentCourse> getStudentsOnCourses(Long courseId) {
        List<StudentCourse> studentsOnCourses = new ArrayList<>();
        for (StudentCourse studentCourse : studentsCourses) {
            if (studentCourse.getCourseId().equals(courseId)) {
                studentsOnCourses.add(studentCourse);
            }
        }
        return studentsOnCourses;
    }

    @Override
    public void addStudentCourse(StudentCourse studentCourse) {
        studentsCourses.add(studentCourse);
    }

    @Override
    public void updateStudentCourse(StudentCourse studentCourse) {
        for (int i =0; i < studentsCourses.size(); i++) {
            if (studentsCourses.get(i).getStudentId().equals(studentCourse.getStudentId()) &&
            studentsCourses.get(i).getCourseId().equals(studentCourse.getCourseId())) {
                studentsCourses.set(i, studentCourse);
            }
        }
    }

    @Override
    public void deleteStudentCourse(Long studentId, Long courseId) {
        studentsCourses.removeIf(studentCourse ->
                studentCourse.getStudentId().equals(studentId) && studentCourse.getCourseId().equals(courseId));
    }
}
