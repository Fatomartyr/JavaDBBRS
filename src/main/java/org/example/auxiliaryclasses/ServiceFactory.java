package org.example.auxiliaryclasses;

import org.example.repository.implementations.inmemory.*;
import org.example.services.*;

public class ServiceFactory {
    private final AttendanceRepo attendanceRepo;
    private final CourseRepo courseRepo;
    private final FacultyRepo facultyRepo;
    private final GroupRepo groupRepo;
    private final LecturerRepo lecturerRepo;
    private final RoleRepo roleRepo;
    private final SemesterRepo semesterRepo;
    private final SemesterSubjectRepo semesterSubjectRepo;
    private final SpecializationRepo specializationRepo;
    private final StudentCourseRepo studentCourseRepo;
    private final StudentGroupRepo studentGroupRepo;
    private final StudentRepo studentRepo;
    private final SubjectRepo subjectRepo;
    private final UserRepo userRepo;
    public ServiceFactory(AttendanceRepo attendanceRepo, CourseRepo courseRepo,
                          FacultyRepo facultyRepo, GroupRepo groupRepo,
                          LecturerRepo lecturerRepo, RoleRepo roleRepo,
                          SemesterRepo semesterRepo, SemesterSubjectRepo semesterSubjectRepo,
                          SpecializationRepo specializationRepo,
                          StudentCourseRepo studentCourseRepo, StudentGroupRepo studentGroupRepo,
                          StudentRepo studentRepo, SubjectRepo subjectRepo, UserRepo userRepo) {
        this.attendanceRepo = attendanceRepo;
        this.courseRepo = courseRepo;
        this.facultyRepo = facultyRepo;
        this.groupRepo = groupRepo;
        this.lecturerRepo = lecturerRepo;
        this.roleRepo = roleRepo;
        this.semesterRepo = semesterRepo;
        this.semesterSubjectRepo = semesterSubjectRepo;
        this.specializationRepo = specializationRepo;
        this.studentCourseRepo = studentCourseRepo;
        this.studentGroupRepo = studentGroupRepo;
        this.studentRepo = studentRepo;
        this.subjectRepo = subjectRepo;
        this.userRepo = userRepo;
    }
    public AttendanceService createAttendanceService() {
        return new AttendanceService(attendanceRepo);
    }
    public CourseService createCourseService() {
        return new CourseService(courseRepo);
    }
    public FacultyService createFacultyService() {
        return new FacultyService(facultyRepo);
    }
    public GroupService createGroupService() {
        return new GroupService(groupRepo);
    }
    public LecturerService createLecturerService() {
        return new LecturerService(lecturerRepo);
    }
    public SemesterService createSemesterService() {
        return new SemesterService(semesterRepo);
    }
    public SemesterSubjectService createSemesterSubjectService() {
        return new SemesterSubjectService(semesterSubjectRepo);
    }
    public SpecializationService createSpecializationService() {
        return new SpecializationService(specializationRepo);
    }
    public StudentCourseService createStudentCourseService() {
        return new StudentCourseService(studentCourseRepo);
    }
    public StudentGroupService createStudentGroupService() {
        return new StudentGroupService(studentGroupRepo);
    }
    public StudentService createStudentService() {
        return new StudentService(studentRepo);
    }
    public SubjectService createSubjectService() {
        return new SubjectService(subjectRepo);
    }
    public UserService createUserService() {
        return new UserService(userRepo, roleRepo);
    }
}
