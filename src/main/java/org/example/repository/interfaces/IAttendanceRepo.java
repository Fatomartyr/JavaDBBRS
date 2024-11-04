package org.example.repository.interfaces;

import org.example.entities.Attendance;


public interface IAttendanceRepo {
    Attendance getAttendance(Long id);
    int getPercentAttendance(Long studentId, String subjectName);
    void addAttendance(Attendance attendance);
    void updateAttendance(Attendance attendance);
    void deleteAttendance(Long id);
}
