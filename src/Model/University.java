package Model;

import java.util.List;

public class University {

    private List<Teacher> teachers;
    private List<Student> students;
    private List<Course> courses;

    public University() {
    }

    public University(List<Teacher> teachers, List<Student> students, List<Course> courses) {
        this.teachers = teachers;
        this.students = students;
        this.courses = courses;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
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
}
