package Database;

import Model.Course;
import Model.Student;
import Model.Teacher;
import Model.University;

import java.util.List;

public class UniversityDatabase {

    public University universityData;

    public UniversityDatabase() {

        TeacherDatabase teacherDatabase = new TeacherDatabase();
        StudentDatabase studentDatabase = new StudentDatabase();

        List<Teacher> teachersData = teacherDatabase.getTeachers();
        List<Student> studentsData = studentDatabase.getStudents();

        CourseDatabase courseDatabase = new CourseDatabase(studentsData,teachersData);

        List<Course> coursesData = courseDatabase.getCourses();

        universityData = new University(teachersData, studentsData, coursesData);
    }
}
