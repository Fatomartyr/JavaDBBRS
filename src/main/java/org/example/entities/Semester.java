package org.example.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Semester {
    private Long id;
    private Long courseId;
    private Integer semester;

    public Semester(Long id, Long courseId, Integer semester) {
        this.id = id;
        this.courseId = courseId;
        this.semester = semester;
    }
    @Override
    public String toString() {
        return "Semester {id = " + id + "courseId = " + courseId +  ", semester = " + semester + "}";
    }

}
