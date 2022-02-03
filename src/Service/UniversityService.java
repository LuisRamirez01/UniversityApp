package Service;

import Model.Course;
import Model.Student;
import Model.Teacher;

import java.util.List;

public interface UniversityService {
    public List<Teacher> getTeachers();
    public List<Course> getCourses();
    public List<Student> getStudents();
    public Student getStudentByName(String name);
    public void createStudent(String name, int age);
    public void createCourse(String name,String assignedClassroom,List<Student> students,Teacher teacher);
    public void addStudentToCourse(Student student,String courseName);
}
