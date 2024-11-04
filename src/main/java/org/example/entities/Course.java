package org.example.entities;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class Course {
    private Long id;
    private LocalDate firstDate;
    private LocalDate secondDate;
    private Integer cost;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public Course(Long id, LocalDate firstDate, LocalDate secondDate, Integer cost) {
        this.id = id;
        this.firstDate = firstDate;
        this.secondDate = secondDate;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Course {id = " + id + ", firstDate = " + firstDate.format(formatter)
                + ", secondDate = " + secondDate.format(formatter) + ", cost = " + cost + "}";
    }

}
