package org.example.services;

import org.example.entities.Lecturer;
import org.example.repository.implementations.inmemory.LecturerRepo;
import org.example.repository.interfaces.ILecturerRepo;

public class LecturerService {
    private ILecturerRepo lecturerRepo;
    public LecturerService(LecturerRepo lecturerRepo) {
        this.lecturerRepo = lecturerRepo;
    }
    public Lecturer getLecturer(Long id) {
        return lecturerRepo.getLecturer(id);
    }
    public void addLecturer(Lecturer lecturer) {
        lecturerRepo.addLecturer(lecturer);
    }
    public void updateLecturer(Lecturer lecturer) {
        lecturerRepo.updateLecturer(lecturer);
    }
    public void deleteLecturer(Long id) {
        lecturerRepo.deleteLecturer(id);
    }
}
