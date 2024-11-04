package org.example.repository.interfaces;

import org.example.entities.Faculty;

public interface IFacultyRepo {
    Faculty getFaculty(Long id);
    void addFaculty(Faculty faculty);
    void updateFaculty(Faculty faculty);
    void deleteFaculty(Long id);
}
