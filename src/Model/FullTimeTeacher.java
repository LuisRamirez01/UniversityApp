package Model;

public class FullTimeTeacher extends Teacher{

    private int yearsExperienced;

    public FullTimeTeacher(String name, int yearsExperienced){
        super(name,"FullTime");
        this.yearsExperienced = yearsExperienced;
    }

    @Override
    public double getSalary() {
        return super.getBaseSalary()*1.1*yearsExperienced;
    }

    @Override
    public String toString() {
        return "ID: " + super.getId() +
                "\nName: " + super.getName() +
                "\nBase Salary: $" + super.getBaseSalary() +
                "\nService Type: " + super.getServiceType() +
                "\nYears of Experience: " + this.yearsExperienced+
                "\nTotal Salary: $" + getSalary();
    }
}
