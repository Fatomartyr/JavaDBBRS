package org.example.mockdatabase;


import lombok.Getter;
import org.example.auxiliaryclasses.ServiceFactory;
import org.example.entities.*;
import org.example.provider.DataProvider;
import org.example.repository.implementations.inmemory.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MockDatabase {
    private final AttendanceRepo attendanceRepo = new AttendanceRepo(initializeAttendanceRepo());
    private final CourseRepo courseRepo = new CourseRepo(initializeCourseRepo());
    private final FacultyRepo facultyRepo = new FacultyRepo(initializeFacultyRepo());
    private final GroupRepo groupRepo = new GroupRepo(initializeGroupRepo());
    private final LecturerRepo lecturerRepo = new LecturerRepo(initializeLecturerRepo());
    private final RoleRepo roleRepo = new RoleRepo(initializeRoleRepo());
    private final SemesterRepo semesterRepo = new SemesterRepo(initializeSemesterRepo());
    private final SemesterSubjectRepo semesterSubjectRepo = new SemesterSubjectRepo(initializeSemesterSubjectRepo());
    private final SpecializationRepo specializationRepo = new SpecializationRepo(initializeSpecializationRepo());
    private final StudentCourseRepo studentCourseRepo = new StudentCourseRepo(initializeStudentCourseRepo());
    private final StudentGroupRepo studentGroupRepo = new StudentGroupRepo(initializeStudentGroupRepo());
    private final StudentRepo studentRepo = new StudentRepo(initializeStudentRepo());
    private final SubjectRepo subjectRepo = new SubjectRepo(initializeSubjectRepo());
    private final UserRepo userRepo = new UserRepo(initializeUserRepo());
    private final ServiceFactory serviceFactory = new ServiceFactory(attendanceRepo, courseRepo, facultyRepo,
            groupRepo, lecturerRepo, roleRepo, semesterRepo, semesterSubjectRepo, specializationRepo,
            studentCourseRepo, studentGroupRepo, studentRepo, subjectRepo, userRepo);

    @Getter
    private final DataProvider dataProvider = new DataProvider(serviceFactory);

    private List<Attendance> initializeAttendanceRepo() {
        List<Attendance> attendances = new ArrayList<>();
        attendances.add(new Attendance(1L, 1L, "Mathematics", LocalDate.of(2024, 10, 1), true));
        attendances.add(new Attendance(2L, 1L, "Physics", LocalDate.of(2024, 10, 2), false));
        attendances.add(new Attendance(3L, 1L, "Chemistry", LocalDate.of(2024, 10, 3), true));
        attendances.add(new Attendance(4L, 1L, "Biology", LocalDate.of(2024, 10, 4), true));
        attendances.add(new Attendance(5L, 1L, "Mathematics", LocalDate.of(2024, 10, 5), false));
        return attendances;
    }

    private List<Course> initializeCourseRepo() {
        List<Course> courses = new ArrayList<>();
        courses.add(new Course(1L, LocalDate.of(2024, 10, 1), LocalDate.of(2024, 12, 15), 500));
        courses.add(new Course(2L, LocalDate.of(2024, 10, 15), LocalDate.of(2025, 1, 15), 600));
        courses.add(new Course(3L, LocalDate.of(2024, 11, 1), LocalDate.of(2025, 2, 28), 450));
        courses.add(new Course(4L, LocalDate.of(2024, 11, 15), LocalDate.of(2025, 3, 15), 550));
        courses.add(new Course(5L, LocalDate.of(2024, 12, 1), LocalDate.of(2025, 3, 1), 700));
        return courses;
    }
    private List<Faculty> initializeFacultyRepo() {
        List<Faculty> faculties = new ArrayList<>();
        faculties.add(new Faculty(1L, "Faculty of Science", "Alice Johnson"));
        faculties.add(new Faculty(2L, "Faculty of Engineering", "Bob Smith"));
        faculties.add(new Faculty(3L, "Faculty of Arts", "Carol Davis"));
        faculties.add(new Faculty(4L, "Faculty of Medicine", "David Brown"));
        faculties.add(new Faculty(5L, "Faculty of Education", "Eva White"));
        return faculties;
    }

    private List<Group> initializeGroupRepo() {
        List<Group> groups = new ArrayList<>();
        groups.add(new Group(1L, 1L, 1L, 101, "Samuel Carter"));
        groups.add(new Group(2L, 2L, 1L, 102, "Emily Thompson"));
        groups.add(new Group(3L, 3L, 2L, 103, "Michael Clark"));
        groups.add(new Group(4L, 1L, 2L, 104, "Jessica Lewis"));
        groups.add(new Group(5L, 2L, 3L, 105, "William Walker"));
        return groups;
    }

    private List<Lecturer> initializeLecturerRepo() {
        List<Lecturer> lecturers = new ArrayList<>();
        lecturers.add(new Lecturer(1L, Arrays.asList(1L, 2L), 101L, 1L, "James Parker", "james.parker@example.com", "+1234567890", "degree1"));
        lecturers.add(new Lecturer(2L, Arrays.asList(3L),  102L, 1L, "Sarah Wilson", "sarah.wilson@example.com", "+1234567891", "degree2"));
        lecturers.add(new Lecturer(3L, Arrays.asList(4L, 5L),103L, 2L, "David Taylor", "david.taylor@example.com", "+1234567892", "degree3"));
        lecturers.add(new Lecturer(4L, Arrays.asList(1L), 104L, 2L, "Laura Evans", "laura.evans@example.com", "+1234567893", "degree4"));
        lecturers.add(new Lecturer(5L, Arrays.asList(2L, 3L),105L, 3L, "Emily Brown", "emily.brown@example.com", "+1234567894", "degree5"));
        return lecturers;
    }

    private List<Role> initializeRoleRepo() {
        List<Role> roles = new ArrayList<>();
        roles.add(new Role(1L, 1L, "Admin"));
        roles.add(new Role(2L, 2L, "Student"));
        roles.add(new Role(3L, 1L, "Lecturer"));
        roles.add(new Role(4L, 3L, "Student"));
        roles.add(new Role(5L, 4L, "Lecturer"));
        return roles;
    }

    private List<Semester> initializeSemesterRepo() {
        List<Semester> semesters = new ArrayList<>();
        semesters.add(new Semester(1L, 1L, 1));
        semesters.add(new Semester(2L, 1L, 2));
        semesters.add(new Semester(3L, 2L, 1));
        semesters.add(new Semester(4L, 3L, 1));
        semesters.add(new Semester(5L, 4L, 2));
        return semesters;
    }

    private List<SemesterSubject> initializeSemesterSubjectRepo() {
        List<SemesterSubject> semesterSubjects = new ArrayList<>();
        semesterSubjects.add(new SemesterSubject(1L, 1L));
        semesterSubjects.add(new SemesterSubject(1L, 2L));
        semesterSubjects.add(new SemesterSubject(2L, 3L));
        semesterSubjects.add(new SemesterSubject(3L, 4L));
        semesterSubjects.add(new SemesterSubject(4L, 1L));
        return semesterSubjects;
    }
    private List<Specialization> initializeSpecializationRepo() {
        List<Specialization> specializations = new ArrayList<>();
        specializations.add(new Specialization(1L, 1L, "Computer Science"));
        specializations.add(new Specialization(2L, 1L, "Biology"));
        specializations.add(new Specialization(3L, 2L, "Mechanical Engineering"));
        specializations.add(new Specialization(4L, 2L, "Civil Engineering"));
        specializations.add(new Specialization(5L, 3L, "Fine Arts"));
        return specializations;
    }
    private List<StudentCourse> initializeStudentCourseRepo() {
        List<StudentCourse> studentCourses = new ArrayList<>();
        studentCourses.add(new StudentCourse(1L, 1L));
        studentCourses.add(new StudentCourse(1L, 2L));
        studentCourses.add(new StudentCourse(2L, 2L));
        studentCourses.add(new StudentCourse(3L, 3L));
        studentCourses.add(new StudentCourse(2L, 1L));
        return studentCourses;
    }
    private List<StudentGroup> initializeStudentGroupRepo() {
        List<StudentGroup> studentGroups = new ArrayList<>();
        studentGroups.add(new StudentGroup(1L, 101L));
        studentGroups.add(new StudentGroup(1L, 102L));
        studentGroups.add(new StudentGroup(2L, 101L));
        studentGroups.add(new StudentGroup(3L, 103L));
        studentGroups.add(new StudentGroup(2L, 104L));
        return studentGroups;
    }
    private List<Student> initializeStudentRepo() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1L, Arrays.asList(1L, 2L, 3L, 4L, 5L), "Alice Johnson", "+71234567890", "alice.johnson@example.com"));
        students.add(new Student(2L, Arrays.asList(1L, 2L, 3L, 4L, 5L), "Bob Smith", "+79123456789", "bob.smith@example.com"));
        students.add(new Student(3L, Arrays.asList(1L, 2L, 3L, 4L, 5L),"Charlie Brown", "+79876543210", "charlie.brown@example.com"));
        students.add(new Student(4L, Arrays.asList(1L, 2L, 3L, 4L, 5L), "Diana Prince", "+79012345678", "diana.prince@example.com"));
        students.add(new Student(5L, Arrays.asList(1L, 2L, 3L, 4L, 5L), "Edward Elric", "+71239876543", "edward.elric@example.com"));
        return students;
    }
    private List<Subject> initializeSubjectRepo() {
        List<Subject> subjects = new ArrayList<>();
        subjects.add(new Subject(1L, 1L, "Mathematics", 60));
        subjects.add(new Subject(2L, 2L, "Physics", 45));
        subjects.add(new Subject(3L, 1L, "Chemistry", 30));
        subjects.add(new Subject(4L, 3L, "Biology", 50));
        subjects.add(new Subject(5L, 2L, "History", 40));
        return subjects;
    }
    private List<User> initializeUserRepo() {
        List<User> users = new ArrayList<>();
        String hashedAdminPassword = "$2a$10$550SdgK3Cob2OVMDlnxBK.RNMhINvLxob1R1KY9QFeO88woaI9nTK";
        String hashedJohn_Doe = "$2a$10$yAbtN2WWa2TvTH5WR0PLTubLvKrElCNOghTEdFJ29XFwc/FSmc1j6";
        String hashedJana_Doe = "$2a$10$qFF31DFhuFO/zgAfXLjhj.eeSSWSVa3uCPAXQGI2DuXPW.4aybVeq";
        String hashedAlice_smith = "$2a$10$BuoWx4ml32mTEbg8LHNYq.x0pKCe8t5W4KtITuHMOhLp8FO2RXrQ2";
        String hashedBob_jones = "$2a$10$IjHxE2YAWpzDCDbuZJsxJO1wBnMOyFH1rlyX9mjQRKHoqWzhmrTbG";
        users.add(new User(1L, "admin", hashedAdminPassword));
        users.add(new User(2L, "john_doe", hashedJohn_Doe));
        users.add(new User(3L, "jane_doe", hashedJana_Doe));
        users.add(new User(4L, "alice_smith", hashedAlice_smith));
        users.add(new User(5L, "bob_jones", hashedBob_jones));
        return users;
    }
}
