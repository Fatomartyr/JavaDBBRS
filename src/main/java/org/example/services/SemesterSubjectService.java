package org.example.services;

import org.example.entities.SemesterSubject;
import org.example.repository.implementations.inmemory.SemesterSubjectRepo;
import org.example.repository.interfaces.ISemesterSubjectRepo;

import java.util.List;

public class SemesterSubjectService {
    private ISemesterSubjectRepo semesterSubjectRepo;
    public SemesterSubjectService(SemesterSubjectRepo semesterSubjectRepo) {
        this.semesterSubjectRepo = semesterSubjectRepo;
    }
    public SemesterSubject getSemesterSubject(Long semesterId, Long subjectId) {
        return semesterSubjectRepo.getSubjectSemester(semesterId, subjectId);
    }
    public List<SemesterSubject> getSubjectsOnSemesters(Long semesterId) {
        return semesterSubjectRepo.getSubjectsOnCourses(semesterId);
    }
    public void addSemesterSubject(SemesterSubject semesterSubject) {
        semesterSubjectRepo.addSubjectSemester(semesterSubject);
    }
    public void removeSemesterSubject(Long semesterId, Long subjectId) {
        semesterSubjectRepo.deleteSubjectSemester(semesterId, subjectId);
    }
}
