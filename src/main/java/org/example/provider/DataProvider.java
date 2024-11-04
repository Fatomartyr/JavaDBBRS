package org.example.provider;

import org.example.auxiliaryclasses.ServiceFactory;
import org.example.services.*;

public class DataProvider {
    private final AttendanceService attendanceService;
    private final CourseService courseService;
    private final FacultyService facultyService;
    private final GroupService groupService;
    private final LecturerService lecturerService;
    private final SemesterService semesterService;
    private final SemesterSubjectService semesterSubjectService;
    private final SpecializationService specializationService;
    private final StudentCourseService studentCourseService;
    private final StudentGroupService studentGroupService;
    private final StudentService studentService;
    private final SubjectService subjectService;
    private final UserService userService;
    public DataProvider(ServiceFactory serviceFactory) {
        this.attendanceService = serviceFactory.createAttendanceService();
        this.courseService = serviceFactory.createCourseService();
        this.facultyService = serviceFactory.createFacultyService();
        this.groupService = serviceFactory.createGroupService();
        this.lecturerService = serviceFactory.createLecturerService();
        this.semesterService = serviceFactory.createSemesterService();
        this.semesterSubjectService = serviceFactory.createSemesterSubjectService();
        this.specializationService = serviceFactory.createSpecializationService();
        this.studentCourseService = serviceFactory.createStudentCourseService();
        this.studentGroupService = serviceFactory.createStudentGroupService();
        this.studentService = serviceFactory.createStudentService();
        this.subjectService = serviceFactory.createSubjectService();
        this.userService = serviceFactory.createUserService();
    }

    public AttendanceService getAttendanceService() {
        return attendanceService;
    }

    public CourseService getCourseService() {
        return courseService;
    }

    public FacultyService getFacultyService() {
        return facultyService;
    }

    public GroupService getGroupService() {
        return groupService;
    }

    public LecturerService getLecturerService() {
        return lecturerService;
    }

    public SemesterService getSemesterService() {
        return semesterService;
    }

    public SemesterSubjectService getSemesterSubjectService() {
        return semesterSubjectService;
    }

    public SpecializationService getSpecializationService() {
        return specializationService;
    }

    public StudentCourseService getStudentCourseService() {
        return studentCourseService;
    }

    public StudentGroupService getStudentGroupService() {
        return studentGroupService;
    }

    public StudentService getStudentService() {
        return studentService;
    }

    public SubjectService getSubjectService() {
        return subjectService;
    }

    public UserService getUserService() {
        return userService;
    }
}
