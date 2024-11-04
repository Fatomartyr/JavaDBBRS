package org.example.services;

import org.example.entities.Specialization;
import org.example.repository.implementations.inmemory.SpecializationRepo;
import org.example.repository.interfaces.ISpecializationRepo;

public class SpecializationService {
    private ISpecializationRepo specializationRepo;
    public SpecializationService(SpecializationRepo specializationRepo) {
        this.specializationRepo = specializationRepo;
    }
    public Specialization getSpecialization(Long id) {
        return specializationRepo.getSpecialization(id);
    }
    public void addSpecialization(Specialization specialization) {
        specializationRepo.addSpecialization(specialization);
    }
    public void updateSpecialization(Specialization specialization) {
        specializationRepo.updateSpecialization(specialization);
    }
    public void deleteSpecialization(Long id) {
        specializationRepo.deleteSpecialization(id);
    }
}
