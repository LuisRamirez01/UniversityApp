package Model;

import java.util.List;

public class Course {
    private Long code;
    private String name;
    private String assignedClassroom;
    private List<Student> students;
    private Teacher teacher;
    private static Long counter = 1L;

    public Course() {
    }

    public Course(String name, String assignedClassroom, List<Student> students, Teacher teacher) {
        this.name = name;
        this.assignedClassroom = assignedClassroom;
        this.students = students;
        this.teacher = teacher;
        this.code = counter;
        counter++;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAssignedClassroom() {
        return assignedClassroom;
    }

    public void setAssignedClassroom(String assignedClassroom) {
        this.assignedClassroom = assignedClassroom;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void addStudent(Student student){
        this.students.add(student);
    }

    @Override
    public String toString() {
        return "Course Code: " + code +
                "\nCourse Name: " + name +
                "\nAssigned Classroom: " + assignedClassroom +
                "\nTeacher Name: " + teacher.getName();
    }
}
