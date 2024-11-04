package org.example.repository.interfaces;

import org.example.entities.Semester;

public interface ISemesterRepo {
    Semester getSemester(Long id);
    void addSemester(Semester semester);
    void updateSemester(Semester semester);
    void deleteSemester(Long id);
}
