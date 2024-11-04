package org.example.repository.implementations.inmemory;

import org.example.entities.Semester;
import org.example.repository.interfaces.ISemesterRepo;

import java.util.List;

public class SemesterRepo implements ISemesterRepo {
    private List<Semester> semesters;
    public SemesterRepo(List<Semester> semesters) {
        this.semesters = semesters;
    }

    @Override
    public Semester getSemester(Long id) {
        for (Semester semester : semesters) {
            if (semester.getId().equals(id)) {
                return semester;
            }
        }
        return null;
    }

    @Override
    public void addSemester(Semester semester) {
        semesters.add(semester);
    }

    @Override
    public void updateSemester(Semester semester) {
        for (int i = 0; i < semesters.size(); i++) {
            if (semesters.get(i).getId().equals(semester.getId())) {
                semesters.set(i, semester);
            }
        }
    }

    @Override
    public void deleteSemester(Long id) {
        semesters.removeIf(semester -> semester.getId().equals(id));
    }
}