package org.example.services;

import org.example.entities.Attendance;
import org.example.repository.implementations.inmemory.AttendanceRepo;
import org.example.repository.interfaces.IAttendanceRepo;


public class AttendanceService {
    private IAttendanceRepo attendanceRepo;
    public AttendanceService(AttendanceRepo attendanceRepo) {
        this.attendanceRepo = attendanceRepo;
    }
    public String getPercentAttendance(Long studentId, String subjectName) {
        return attendanceRepo.getPercentAttendance(studentId, subjectName) + " %";
    }
    public Attendance getAttendance(Long attendanceId) {
        return attendanceRepo.getAttendance(attendanceId);
    }
    public void addAttendance(Attendance attendance) {
        attendanceRepo.addAttendance(attendance);
    }
    public void updateAttendance(Attendance attendance) {
        attendanceRepo.updateAttendance(attendance);
    }
    public void deleteAttendance(Long attendanceId) {
        attendanceRepo.deleteAttendance(attendanceId);
    }
}
