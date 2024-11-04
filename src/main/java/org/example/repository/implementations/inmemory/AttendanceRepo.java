package org.example.repository.implementations.inmemory;

import org.example.entities.Attendance;
import org.example.repository.interfaces.IAttendanceRepo;

import java.util.List;

public class AttendanceRepo implements IAttendanceRepo {
    private List<Attendance> attendances;

    public AttendanceRepo(List<Attendance>  attendances) {
        this.attendances = attendances;
    }

    @Override
    public Attendance getAttendance(Long id) {
        for (Attendance attendance : attendances) {
            if (attendance.getId().equals(id)) {
                return attendance;
            }
        }
        return null;
    }

    @Override
    public int getPercentAttendance(Long studentId, String subjectName) {
        int absent = 0;
        int count = 0;
        for (Attendance attendance : attendances) {
            if (attendance.getStudentId().equals(studentId) && attendance.getSubjectName().equals(subjectName)) {
                count++;
                if (!attendance.getAttended()) {
                    absent++;
                }
            }
        }
        return (1 - absent / count) * 100;
    }

    @Override
    public void addAttendance(Attendance attendance) {
        attendances.add(attendance);
    }

    @Override
    public void updateAttendance(Attendance attendance) {
        for (int i = 0; i < attendances.size(); i++) {
            if (attendances.get(i).getId().equals(attendance.getId())) {
                attendances.set(i, attendance);
            }
        }
    }

    @Override
    public void deleteAttendance(Long id) {
        attendances.removeIf(attendance -> attendance.getId().equals(id));
    }

}
