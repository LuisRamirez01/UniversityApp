package Database;

import Model.Course;
import Model.Student;
import Model.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CourseDatabase {

    private List<Course> courses;

    public CourseDatabase(List<Student> studentData,List<Teacher> teacherData) {

        ArrayList<Course> newCourses = new ArrayList<>();

        Course math = new Course("Math", "402B", studentData.stream().collect(Collectors.toList()), teacherData.get(0));
        Course linuxIntro = new Course("Linux Intro", "205C", studentData.stream().collect(Collectors.toList()), teacherData.get(1));
        Course artificialIntelligence = new Course("Artificial Intelligence", "308D", studentData.stream().collect(Collectors.toList()), teacherData.get(2));
        Course operatingSystems = new Course("Operating Systems", "408D", studentData.stream().collect(Collectors.toList()), teacherData.get(3));

        newCourses.add(math);
        newCourses.add(linuxIntro);
        newCourses.add(artificialIntelligence);
        newCourses.add(operatingSystems);

        setCourses(newCourses);
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
