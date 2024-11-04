package org.example.services;

import org.example.entities.Faculty;
import org.example.repository.implementations.inmemory.FacultyRepo;
import org.example.repository.interfaces.IFacultyRepo;

public class FacultyService {
    private IFacultyRepo facultyRepo;
    public FacultyService(FacultyRepo facultyRepo) {
        this.facultyRepo = facultyRepo;
    }
    public Faculty getFaculty(Long id) {
        return facultyRepo.getFaculty(id);
    }
    public void addFaculty(Faculty faculty) {
        facultyRepo.addFaculty(faculty);
    }
    public void updateFaculty(Faculty faculty) {
        facultyRepo.updateFaculty(faculty);
    }
    public void deleteFaculty(Long id) {
        facultyRepo.deleteFaculty(id);
    }
}
