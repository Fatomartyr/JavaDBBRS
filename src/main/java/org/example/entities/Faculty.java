package org.example.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Faculty {
    private Long id;
    private String facultyName;
    private String dean;

    public Faculty(Long id, String facultyName, String dean) {
        this.id = id;
        this.facultyName = facultyName;
        this.dean = dean;
    }

    @Override
    public String toString() {
        return "Faculty {id = " + id + ", facultyName = " + facultyName + ", dean = " + dean + "}";
    }
}
