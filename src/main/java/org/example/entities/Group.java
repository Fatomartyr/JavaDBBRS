package org.example.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Group {
    private Long id;
    private Long lecturerId;
    private Long specializationId;
    private Integer groupNumber;
    private String curator;

    public Group(Long id, Long lecturerId, Long specializationId, Integer groupNumber, String curator) {
        this.id = id;
        this.lecturerId = lecturerId;
        this.specializationId = specializationId;
        this.groupNumber = groupNumber;
        this.curator = curator;
    }
    @Override
    public String toString() {
        return "Group {id = " + id + ", lecturerId = " + lecturerId + ", specializationId = " + specializationId
                + ", groupNumber = " + groupNumber + ", curator = " + curator + "}";
    }
}
