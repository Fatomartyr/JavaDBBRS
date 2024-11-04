package org.example.repository.interfaces;

import org.example.entities.Lecturer;


public interface ILecturerRepo {
    Lecturer getLecturer(Long id);
    void addLecturer(Lecturer lecturer);
    void updateLecturer(Lecturer lecturer);
    void deleteLecturer(Long id);
}
