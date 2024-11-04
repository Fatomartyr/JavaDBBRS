package org.example.repository.interfaces;

import org.example.entities.Subject;

public interface ISubjectRepo {
    Subject getSubject(Long id);
    void addSubject(Subject subject);
    void updateSubject(Subject subject);
    void deleteSubject(Long id);
}
