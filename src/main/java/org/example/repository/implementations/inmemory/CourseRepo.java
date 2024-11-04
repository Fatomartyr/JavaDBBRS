package org.example.repository.implementations.inmemory;

import org.example.entities.Course;
import org.example.repository.interfaces.ICourseRepo;

import java.util.List;

public class CourseRepo implements ICourseRepo {
    private List<Course> courses;

    public CourseRepo(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public Course getCourse(Long id) {
        for (Course course : courses) {
            if (course.getId().equals(id)) {
                return course;
            }
        }
        return null;
    }

    @Override
    public void addCourse(Course course) {
        courses.add(course);
    }

    @Override
    public void updateCourse(Course course) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getId().equals(course.getId())) {
                courses.set(i, course);
            }
        }
    }

    @Override
    public void deleteCourse(Long id) {
        courses.removeIf(course -> course.getId().equals(id));
    }
}
