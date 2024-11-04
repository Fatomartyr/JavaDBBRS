package org.example.services;

import org.example.entities.Semester;
import org.example.repository.implementations.inmemory.SemesterRepo;
import org.example.repository.interfaces.ISemesterRepo;

public class SemesterService {
    private ISemesterRepo semesterRepo;
    public SemesterService(SemesterRepo semesterRepo) {
        this.semesterRepo = semesterRepo;
    }
    public void updateSemester(Semester semester) {
        semesterRepo.updateSemester(semester);
    }
}
