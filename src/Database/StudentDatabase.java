package Database;

import Model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDatabase {

    private List<Student> students;

    public StudentDatabase() {

        ArrayList<Student> newStudents = new ArrayList<>();

        Student student = new Student("Niky", 18);
        Student student1 = new Student("James", 25);
        Student student2 = new Student("Marcos", 23);
        Student student3 = new Student("Albert", 28);
        Student student4 = new Student("Elena", 19);
        Student student5 = new Student("Piero", 21);

        newStudents.add(student);
        newStudents.add(student1);
        newStudents.add(student2);
        newStudents.add(student3);
        newStudents.add(student4);
        newStudents.add(student5);

        setStudents(newStudents);

    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
