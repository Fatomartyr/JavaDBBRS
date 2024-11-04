package org.example.services;

import org.example.entities.Course;
import org.example.repository.implementations.inmemory.CourseRepo;
import org.example.repository.interfaces.ICourseRepo;

public class CourseService {
    private ICourseRepo courseRepo;
    public CourseService(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }
    public Course getCourse(Long id) {
        return courseRepo.getCourse(id);
    }
    public void addCourse(Course course) {
        courseRepo.addCourse(course);
    }
    public void updateCourse(Course course) {
        courseRepo.updateCourse(course);
    }
    public void deleteCourse(Long id) {
        courseRepo.deleteCourse(id);
    }
}
