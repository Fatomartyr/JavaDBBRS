package org.example.repository.implementations.inmemory;

import org.example.entities.SemesterSubject;
import org.example.repository.interfaces.ISemesterSubjectRepo;

import java.util.ArrayList;
import java.util.List;

public class SemesterSubjectRepo implements ISemesterSubjectRepo {
    private List<SemesterSubject> semestersSubjects;
    public SemesterSubjectRepo(List<SemesterSubject> semestersSubjects) {
        this.semestersSubjects = semestersSubjects;
    }

    @Override
    public SemesterSubject getSubjectSemester(Long semesterId, Long subjectId) {
        for (SemesterSubject semesterSubject : semestersSubjects) {
            if (semesterSubject.getSemesterId().equals(semesterId) && semesterSubject.getSubjectId().equals(subjectId)) {
                return semesterSubject;
            }
        }
        return null;
    }

    @Override
    public List<SemesterSubject> getSubjectsOnCourses(Long semesterId) {
        List<SemesterSubject> subjectsOnCourses = new ArrayList<>();
        for (SemesterSubject semesterSubject : semestersSubjects) {
            if (semesterSubject.getSemesterId().equals(semesterId)) {
                subjectsOnCourses.add(semesterSubject);
            }
        }
        return subjectsOnCourses;
    }

    @Override
    public void addSubjectSemester(SemesterSubject semesterSubject) {
        semestersSubjects.add(semesterSubject);
    }

    @Override
    public void updateSubjectSemester(SemesterSubject semesterSubject) {
        for (int i =0; i < semestersSubjects.size(); i++) {
            if (semestersSubjects.get(i).getSubjectId().equals(semesterSubject.getSubjectId()) &&
                    semestersSubjects.get(i).getSemesterId().equals(semesterSubject.getSemesterId())) {
                semestersSubjects.set(i, semesterSubject);
            }
        }
    }

    @Override
    public void deleteSubjectSemester(Long semesterId, Long subjectId) {
        semestersSubjects.removeIf(semesterSubject ->
                semesterSubject.getSubjectId().equals(subjectId) && semesterSubject.getSemesterId().equals(semesterId));
    }
}
