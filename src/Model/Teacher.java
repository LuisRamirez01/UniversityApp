package Model;

public abstract class Teacher extends Person{

    private Double baseSalary;
    private String serviceType;

    public Teacher(String name, String serviceType){
        super(name);
        this.serviceType = serviceType;
        this.baseSalary = 1200d;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public abstract double getSalary();

    public String getServiceType() {
        return serviceType;
    }
}
