package Model;

import java.util.List;

public abstract class Person {

    private Long id;
    private String name;
    private static Long counter = 1L;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
        this.id = counter;
        counter++;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }
}
