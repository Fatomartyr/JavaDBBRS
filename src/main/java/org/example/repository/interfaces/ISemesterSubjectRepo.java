package org.example.repository.interfaces;

import org.example.entities.SemesterSubject;

import java.util.List;

public interface ISemesterSubjectRepo {
    SemesterSubject getSubjectSemester(Long semesterId, Long subjectId);
    List<SemesterSubject> getSubjectsOnCourses(Long semesterId);
    void addSubjectSemester(SemesterSubject semesterSubject);
    void updateSubjectSemester(SemesterSubject semesterSubject);
    void deleteSubjectSemester(Long semesterId, Long subjectId);
}
