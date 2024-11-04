package org.example.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Semester {
    private Long id;
    private Long courseId;
    private Integer year;
    private Integer semester;

    public Semester(Long id, Long courseId, Integer year, Integer semester) {
        this.id = id;
        this.courseId = courseId;
        this.year = year;
        this.semester = semester;
    }
    @Override
    public String toString() {
        return "Semester {id = " + id + "courseId = " + courseId + ", year = " + year + ", semester = " + semester + "}";
    }

}
