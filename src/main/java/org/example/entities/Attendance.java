package org.example.entities;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class Attendance {
    private Long id;
    private Long studentId;
    private String subjectName;
    private LocalDate date;
    private Boolean attended;

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public Attendance(Long id, Long studentId, String subjectName, LocalDate date, Boolean attended) {
        this.id = id;
        this.studentId = studentId;
        this.subjectName = subjectName;
        this.date = date;
        this.attended = attended;
    }

    @Override
    public String toString() {
        return "Attendance {id = " + id + ", studentId = " + studentId
                + ", date = " + date + ", attended = " + attended + "}";
    }

}
