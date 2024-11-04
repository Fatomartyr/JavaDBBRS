package org.example.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Lecturer {
    private Long id;
    private Long groupId;
    private Long facultyId;
    private String lecturerName;
    private String lecturerEmail;
    private String lecturerPhone;
    private String lecturerDegree;

    public Lecturer(Long id, Long groupId, Long facultyId, String lecturerName, String lecturerEmail, String lecturerPhone, String lecturerDegree) {
        this.id = id;
        this.groupId = groupId;
        this.facultyId = facultyId;
        this.lecturerName = lecturerName;
        this.lecturerEmail = lecturerEmail;
        this.lecturerPhone = lecturerPhone;
        this.lecturerDegree = lecturerDegree;
    }

    @Override
    public String toString() {
        return "Lecturer {id = " + id + ", groupId = " + groupId
                + ", facultyId = " + facultyId
                + ", lecturerName = " + lecturerName
                + ", lecturerEmail = " + lecturerEmail + ", lecturerPhone = " + lecturerPhone
                + ", lecturerDegree = " + lecturerDegree + "}";
    }
}
