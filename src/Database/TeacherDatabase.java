package Database;

import Model.FullTimeTeacher;
import Model.PartTimeTeacher;
import Model.Teacher;

import java.util.ArrayList;
import java.util.List;

public class TeacherDatabase {

    private List<Teacher> teachers;

    public TeacherDatabase() {

        List<Teacher> newTeachers = new ArrayList<>();

        FullTimeTeacher teacher1 = new FullTimeTeacher("Juan",4);
        FullTimeTeacher teacher2 = new FullTimeTeacher("Roberto", 8);

        PartTimeTeacher teacher3 = new PartTimeTeacher("Luis", 30.5f);
        PartTimeTeacher teacher4 = new PartTimeTeacher("Pedro", 40);

        newTeachers.add(teacher1);
        newTeachers.add(teacher2);
        newTeachers.add(teacher3);
        newTeachers.add(teacher4);

        setTeachers(newTeachers);
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }
}
