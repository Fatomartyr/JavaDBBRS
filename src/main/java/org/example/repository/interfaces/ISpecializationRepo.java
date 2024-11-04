package org.example.repository.interfaces;

import org.example.entities.Specialization;

public interface ISpecializationRepo {
    Specialization getSpecialization(Long id);
    void addSpecialization(Specialization specialization);
    void updateSpecialization(Specialization specialization);
    void deleteSpecialization(Long id);
}
