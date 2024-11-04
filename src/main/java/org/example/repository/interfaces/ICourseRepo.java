package org.example.repository.interfaces;

import org.example.entities.Course;

public interface ICourseRepo {
    Course getCourse(Long id);
    void addCourse(Course course);
    void updateCourse(Course course);
    void deleteCourse(Long id);
}
