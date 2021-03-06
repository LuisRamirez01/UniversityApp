package UI;

import Model.Course;
import Model.Student;
import Model.Teacher;
import Service.IUniversityService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InterfaceTemplates {

    private IUniversityService service = new IUniversityService();
    private List<Teacher> teachers = service.getTeachers();
    private List<Course> courses = service.getCourses();
    private Scanner sc;

    public InterfaceTemplates() {
        sc = new Scanner(System.in);
    }

    public void welcomeApp(){
        System.out.println("********* Welcome to Globant University *********");
    }

    public String mainMenu(){
        System.out.println("Choose an option:");
        System.out.println("a.- Print All Teachers");
        System.out.println("b.- Print All Classes");
        System.out.println("c.- Create and Add Student to a Class");
        System.out.println("d.- Create a Class And Add Data");
        System.out.println("e.- List Student's Classes");
        System.out.println("f.- Exit");
        String optionPicked = sc.nextLine();
        return optionPicked;
    }

    public void separateData(){
        System.out.println("--------------");
    }

    public void printAllTeachers(){
        System.out.println("TEACHER'S LIST");
        for (Teacher teacher :
                teachers) {
            System.out.println("\n" + teacher + "\n");
            separateData();
        }
    }

    private void printTeachersName(){
        System.out.println("LIST OF TEACHERS\n");
        int counter = 1;
        for (Teacher teacher :
                teachers) {
            System.out.println( counter + ".- " + teacher.getName() + "\n");
            counter++;
        }
    }

    private void printStudentsNameUniversity() {
        System.out.println("LIST OF STUDENTS\n");
        int counter = 1;
        for (Student student :
                service.getStudents()) {
            System.out.println(counter + ".- " + student.getName() + " - Code: " + student.getId() + "\n");
            counter++;
        }
    }

    private void printStudentsNameCourse(List<Student> students){
        System.out.println("List of Students: ");
        int counter = 1;
        for (Student student :
                students) {
            System.out.println( "\t" + counter + ".- " + student.getName());
            counter++;
        }
    }

    public void printCoursesName(){
        System.out.println("LIST OF COURSES\n");
        int counter = 1;
        for (Course course :
                courses) {
            System.out.println( counter + ".- " + course.getName() + "\n");
            counter++;
        }
    }
    public void printCourseInfo(){
        System.out.println("Please, Enter the name of the course you want information about: ");
        String courseSelected = sc.nextLine();
        boolean courseFound = false;
        separateData();
        for (Course course :
                courses) {
            if (course.getName().equalsIgnoreCase(courseSelected)) {
                System.out.println(course);
                printStudentsNameCourse(course.getStudents());
                courseFound = true;
            }
        }
        if (!courseFound){
            System.out.println("Course Not Found");
        }
        separateData();
    }

    public void createStudentAndAddCourse(){
        System.out.println("CREATING NEW STUDENT:\n");
        System.out.println("Please Insert The Student Name:");
        String studentName = sc.nextLine();
        System.out.println("Please Insert The Student Age:");
        int studentAge = sc.nextInt();
        service.createStudent(studentName,studentAge);
        System.out.println("Student Created!\n");
        printCoursesName();
        System.out.println("Enter The Course Name You Want To Get Enrolled:\n");
        sc = new Scanner(System.in);
        String courseToBeEnrolledIn = sc.nextLine();
        Student studentByName = service.getStudentByName(studentName);
        service.addStudentToCourse(studentByName,courseToBeEnrolledIn);
        System.out.println("\nStudent " + studentName +" Enrolled In " + courseToBeEnrolledIn + " Successfully\n");
    }

    public void createCourseMenu(){
        System.out.println("CREATING NEW COURSE:\n");
        System.out.println("Please Insert The Course Name:");
        String courseName = sc.nextLine();
        System.out.println("Please Insert The Assigned Classroom:");
        String assignedClassroom = sc.nextLine();
        printTeachersName();
        System.out.println("From the above list choose the Teacher's Name for this Course:");
        boolean teacherFound = false;
        Teacher teacher = new Teacher("","") {
            @Override
            public double getSalary() {
                return 0;
            }
        };
        while (!teacherFound){
            String teacherName = sc.nextLine();
            teacherFound = service.validateTeacherExists(teacherName);
            if (teacherFound){
                 teacher = service.getTeacherByName(teacherName);
            }else {
                System.out.println("Please, Insert an existing teacher from the list: ");
            }
        }
        System.out.println("**** Inserting Student Sub Menu ****");
        List<Student> studentsToBeAdded = new ArrayList<>();
        boolean isOver = false;
        while (!isOver){
            System.out.println("Select an option: ");
            System.out.println("1.- Add student");
            System.out.println("2.- Exit");
            String optionPicked = sc.nextLine();
            if (optionPicked.equalsIgnoreCase("1")) {
                printStudentsNameUniversity();
                System.out.println("Insert the student name to be enrolled:");
                boolean studentFound = false;
                while (!studentFound){
                    String studentName = sc.nextLine();
                    studentFound = service.validateStudentExists(studentName);
                    boolean studentExistInTheCourse = false;
                    for (Student student :
                            studentsToBeAdded) {
                        if (student.getName().equalsIgnoreCase(studentName)) {
                            System.out.println("The student is already enrolled\n");
                            studentExistInTheCourse = true;
                        }
                    }
                    if (!studentExistInTheCourse){
                        if (studentFound){
                            Student student = service.getStudentByName(studentName);
                            studentsToBeAdded.add(student);
                            System.out.println("Student Added to the course successfully!\n");
                        }else {
                            System.out.println("\nPlease, Insert an existing student from the list: ");
                        }
                    }
                }
            } else {
                isOver = true;
                service.createCourse(courseName,assignedClassroom,studentsToBeAdded,teacher);
                System.out.println("\nThe course was created successfully!\n");
            }
        }
    }

    public void listStudentCourses(){
        printStudentsNameUniversity();
        Student studentFound = new Student();
        List<String> coursesName = new ArrayList<>();
        System.out.println("Enter the name of the student to get info about him courses: ");
        boolean studentExists = false;
        while (!studentExists){
            String studentName = sc.nextLine();
            studentExists = service.validateStudentExists(studentName);
            if (studentExists){
                studentFound = service.getStudentByName(studentName);
                coursesName = service.getCoursesByStudent(studentFound);
            }else {
                System.out.println("Please, Enter the name of an existing Student");
            }
        }
        System.out.println("\n" + studentFound.getName() + " is enrolled in: " + coursesName);
    }

    public void printGoodBye(){
        System.out.println("\nThanks for using our service. GoodBye");
    }


}
