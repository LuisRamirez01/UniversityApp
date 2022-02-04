package Model;

import java.util.ArrayList;
import java.util.List;

public class University {

    private List<Teacher> teachers;
    private List<Student> students;
    private List<Course> courses;

    public University(List<Teacher> teachers, List<Student> students, List<Course> courses) {
        this.teachers = teachers;
        this.students = students;
        this.courses = courses;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void addStudent(Student student){
        this.students.add(student);
    }

    public void addCourse(Course course){
        this.courses.add(course);
    }

    public Course getCourseByName(String name){

        Course courseFound = new Course();

        for (Course course :
                courses) {
            if (course.getName().equalsIgnoreCase(name)) {
                courseFound = course;
            }
        }
        return courseFound;
    }

    public List<String> getCoursesByStudent(Student studentUniversity){
        List<String> coursesName = new ArrayList<>();
        for (Course course :
                courses) {
            List<Student> students = course.getStudents();
            for (Student studentCourse :
                    students) {
                if (studentCourse.getName().equalsIgnoreCase(studentUniversity.getName())){
                    coursesName.add(course.getName());
                }
            }
        }
        return coursesName;
    }

    public Student getStudentByName(String name){

        Student studentFound = new Student();

        for (Student student :
                students) {
            if (student.getName().equalsIgnoreCase(name)) {
                studentFound = student;
            }
        }
        return studentFound;
    }

    public Teacher getTeacherByName(String name) {
        Teacher teacherFound = null;
        for (Teacher teacher :
                teachers) {
            if (teacher.getName().equalsIgnoreCase(name)) {
                teacherFound = teacher;
            }
        }
        return teacherFound;
    }

    public boolean validateTeacherExists(String name){
        boolean teacherFound = false;
        for (Teacher teacher:
                teachers){
            if (teacher.getName().equalsIgnoreCase(name)){
                teacherFound = true;
            }
        }
        return teacherFound;
    }

    public boolean validateStudentExists(String name) {
        boolean studentFound = false;
        for (Student student:
                students){
            if (student.getName().equalsIgnoreCase(name)) {
                studentFound = true;
            }
        }
        return studentFound;
    }
}
