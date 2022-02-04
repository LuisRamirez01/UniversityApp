package Model;

public class Student extends Person{

    private int age;

    public Student() {
    }

    public Student(String name, int age){
        super(name);
        this.age = age;
    }
}
