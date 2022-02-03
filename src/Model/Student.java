package Model;

import java.util.List;

public class Student extends Person{

    private int age;

    public Student() {
    }

    public Student(String name, int age){
        super(name);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
