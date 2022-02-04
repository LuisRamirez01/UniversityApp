package Test;

import UI.InterfaceTemplates;

public class Runner {
    public static void main(String[] args) {

        InterfaceTemplates ui = new InterfaceTemplates();

        boolean isOver = false;

        ui.welcomeApp();

        while (!isOver){
            String optionPicked = ui.mainMenu();
            switch (optionPicked){
                case "a":
                    ui.separateData();
                    ui.printAllTeachers();
                    break;
                case "b":
                    ui.separateData();
                    ui.printCoursesName();
                    ui.printCourseInfo();
                    break;
                case "c":
                    ui.separateData();
                    ui.createStudentAndAddCourse();
                    ui.separateData();
                    break;
                case "d":
                    ui.separateData();
                    ui.createCourseMenu();
                    ui.separateData();
                    break;
                case "e":
                    ui.separateData();
                    ui.listStudentCourses();
                    ui.separateData();
                    break;
                case "f":
                    isOver = true;
                    ui.printGoodBye();
                    break;
            }
        }
    }
}
