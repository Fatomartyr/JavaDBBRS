package org.example.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SemesterSubject {
    private Long semesterId;
    private Long SubjectId;
    public SemesterSubject(Long semesterId, Long SubjectId) {
        this.semesterId = semesterId;
        this.SubjectId = SubjectId;
    }
    @Override
    public String toString() {
        return "SemesterSubject { semesterId = " + semesterId + ", SubjectId = " + SubjectId + "}";
    }
}
