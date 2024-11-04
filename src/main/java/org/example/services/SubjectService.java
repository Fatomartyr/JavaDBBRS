package org.example.services;

import org.example.entities.Subject;
import org.example.repository.implementations.inmemory.SubjectRepo;
import org.example.repository.interfaces.ISubjectRepo;

public class SubjectService {
    private ISubjectRepo subjectRepo;
    public SubjectService(SubjectRepo subjectRepo) {
        this.subjectRepo = subjectRepo;
    }
    public Subject getSubject(Long id) {
        return subjectRepo.getSubject(id);
    }
    public void addSubject(Subject subject) {
        subjectRepo.addSubject(subject);
    }
    public void updateSubject(Subject subject) {
        subjectRepo.updateSubject(subject);
    }
    public void deleteSubject(Long id) {
        subjectRepo.deleteSubject(id);
    }
}
