import UI.InterfaceTemplates;

import java.util.Scanner;

public class Main {
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
                    break;
                case "e":
                    break;
                case "f":
                    isOver = true;
                    ui.printGoodBye();
                    break;
            }
        }
    }
}
