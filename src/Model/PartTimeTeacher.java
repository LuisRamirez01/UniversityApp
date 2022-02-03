package Model;

public class PartTimeTeacher extends Teacher{

    private float activeHoursPerWeek;

    public PartTimeTeacher(String name, float activeHoursPerWeek) {
        super(name,"PartTime");
        this.activeHoursPerWeek = activeHoursPerWeek;
    }

    @Override
    public double getSalary() {
        return super.getBaseSalary()*activeHoursPerWeek;
    }

    @Override
    public String toString() {
        return "ID: " + super.getId() +
                "\nName: " + super.getName() +
                "\nBase Salary: $" + super.getBaseSalary() +
                "\nService Type: " + super.getServiceType() +
                "\nActive Hours Per Week: " + this.activeHoursPerWeek+
                "\nTotal Salary: $" + getSalary();

    }
}
