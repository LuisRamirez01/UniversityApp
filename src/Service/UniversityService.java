package Service;

import Model.Course;
import Model.Student;
import Model.Teacher;

import java.util.List;

public interface UniversityService {
    List<Teacher> getTeachers();
    List<Course> getCourses();
    List<Student> getStudents();
    List<String> getCoursesByStudent(Student student);
    boolean validateTeacherExists(String name);
    boolean validateStudentExists(String name);
    Student getStudentByName(String name);
    Teacher getTeacherByName(String name);
    void createStudent(String name, int age);
    void createCourse(String name,String assignedClassroom,List<Student> students,Teacher teacher);
    void addStudentToCourse(Student student,String courseName);
}
