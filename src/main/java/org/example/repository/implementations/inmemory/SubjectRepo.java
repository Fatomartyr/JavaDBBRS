package org.example.repository.implementations.inmemory;

import org.example.entities.Subject;
import org.example.repository.interfaces.ISubjectRepo;

import java.util.List;

public class SubjectRepo implements ISubjectRepo {
    private List<Subject> subjects;
    public SubjectRepo(List<Subject> subjects) {
        this.subjects = subjects;
    }

    @Override
    public Subject getSubject(Long id) {
        for (Subject subject : subjects) {
            if (subject.getId().equals(id)) {
                return subject;
            }
        }
        return null;
    }

    @Override
    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    @Override
    public void updateSubject(Subject subject) {
        for (int i = 0; i < subjects.size(); i++) {
            if (subjects.get(i).getId().equals(subject.getId())) {
                subjects.set(i, subject);
            }
        }
    }

    @Override
    public void deleteSubject(Long id) {
        subjects.removeIf(subject -> subject.getId().equals(id));
    }
}