package org.example.repository.implementations.inmemory;

import org.example.entities.Specialization;
import org.example.repository.interfaces.ISpecializationRepo;

import java.util.List;

public class SpecializationRepo implements ISpecializationRepo {
    private List<Specialization> specializations;
    public SpecializationRepo(List<Specialization> specializations) {
        this.specializations = specializations;
    }

    @Override
    public Specialization getSpecialization(Long id) {
        for (Specialization specialization : specializations) {
            if (specialization.getId().equals(id)) {
                return specialization;
            }
        }
        return null;
    }

    @Override
    public void addSpecialization(Specialization specialization) {
        specializations.add(specialization);
    }

    @Override
    public void updateSpecialization(Specialization specialization) {
        for (int i = 0; i < specializations.size(); i++) {
            if (specializations.get(i).getId().equals(specialization.getId())) {
                specializations.set(i, specialization);
            }
        }
    }

    @Override
    public void deleteSpecialization(Long id) {
        specializations.removeIf(specialization -> specialization.getId().equals(id));
    }
}
