package org.example.repository.implementations.inmemory;

import org.example.entities.Lecturer;
import org.example.repository.interfaces.ILecturerRepo;

import java.util.List;

public class LecturerRepo implements ILecturerRepo {
    private List<Lecturer> lecturers;
    public LecturerRepo(List<Lecturer> lecturers) {
        this.lecturers = lecturers;
    }

    @Override
    public Lecturer getLecturer(Long id) {
        for (Lecturer lecturer : lecturers) {
            if (lecturer.getId().equals(id)) {
                return lecturer;
            }
        }
        return null;
    }

    @Override
    public void addLecturer(Lecturer lecturer) {
        lecturers.add(lecturer);
    }

    @Override
    public void updateLecturer(Lecturer lecturer) {
        for (int i = 0; i < lecturers.size(); i++) {
            if (lecturers.get(i).getId().equals(lecturer.getId())) {
                lecturers.set(i, lecturer);
            }
        }
    }

    @Override
    public void deleteLecturer(Long id) {
        lecturers.removeIf(lecturer -> lecturer.getId().equals(id));
    }
}
