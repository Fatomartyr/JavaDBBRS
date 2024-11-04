package org.example.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Subject {
    private Long id;
    private Long lectorId;
    private String subjectName;
    private Integer subjectClock;

    public Subject(Long id, Long lectorId, String subjectName, Integer subjectClock) {
        this.id = id;
        this.lectorId = lectorId;
        this.subjectName = subjectName;
        this.subjectClock = subjectClock;
    }

    @Override
    public String toString() {
        return "Subject {id = " + id + ", lectorId = " + lectorId +
                ", subjectName = " + subjectName + ", subjectClock = " + subjectClock + "}";
    }
}
