package Service;

import Database.UniversityDatabase;
import Model.Course;
import Model.Student;
import Model.Teacher;
import Model.University;

import java.util.List;

public class IUniversityService implements UniversityService{

    private UniversityDatabase universityDatabase = new UniversityDatabase();
    private University data = universityDatabase.universityData;

    @Override
    public List<Teacher> getTeachers() {
        return data.getTeachers();
    }

    @Override
    public List<Course> getCourses() {
        return data.getCourses();
    }

    @Override
    public List<Student> getStudents() {
        return data.getStudents();
    }

    @Override
    public boolean validateTeacherExists(String name) {
        return data.validateTeacherExists(name);
    }

    @Override
    public boolean validateStudentExists(String name) {
        return data.validateStudentExists(name);
    }

    @Override
    public Student getStudentByName(String name) {
        return data.getStudentByName(name);
    }

    @Override
    public Teacher getTeacherByName(String name) {
        return data.getTeacherByName(name);
    }

    @Override
    public void createStudent(String name, int age) {
        Student student = new Student(name, age);
        data.addStudent(student);
    }

    @Override
    public void createCourse(String name, String assignedClassroom, List<Student> students, Teacher teacher) {
        Course course = new Course(name, assignedClassroom, students, teacher);
        data.addCourse(course);
    }

    @Override
    public void addStudentToCourse(Student student,String courseName) {
        Course courseByName = data.getCourseByName(courseName);
        courseByName.addStudent(student);
    }
}
