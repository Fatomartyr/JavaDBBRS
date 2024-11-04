package org.example.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Specialization {
    private Long id;
    private Long facultyId;
    private String specializationName;

    public Specialization(Long id, Long facultyId, String specializationName) {
        this.id = id;
        this.facultyId = facultyId;
        this.specializationName = specializationName;
    }

    @Override
    public String toString() {
        return "Specialization {id = " + id + ", facultyId = " + facultyId
                + ", specializationName = " + specializationName + "}";
    }
}
