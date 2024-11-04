package org.example.repository.implementations.inmemory;

import org.example.entities.Faculty;
import org.example.repository.interfaces.IFacultyRepo;

import java.util.List;

public class FacultyRepo implements IFacultyRepo {
    private List<Faculty> facultyRepo;
    public FacultyRepo(List<Faculty> facultyRepo) {
        this.facultyRepo = facultyRepo;
    }

    @Override
    public Faculty getFaculty(Long id) {
        for (Faculty faculty : facultyRepo) {
            if (faculty.getId().equals(id)) {
                return faculty;
            }
        }
        return null;
    }

    @Override
    public void addFaculty(Faculty faculty) {
        facultyRepo.add(faculty);
    }

    @Override
    public void updateFaculty(Faculty faculty) {
        for (int i = 0; i < facultyRepo.size(); i++) {
            if (facultyRepo.get(i).getId().equals(faculty.getId())) {
                facultyRepo.set(i, faculty);
            }
        }
    }

    @Override
    public void deleteFaculty(Long id) {
        facultyRepo.removeIf(faculty -> faculty.getId().equals(id));
    }
}
