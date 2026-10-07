package bai1;

class Employee {
    private String name;
    private int age;
    
    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public double salary() {
        return 0;
    }
    public void display() {
        System.out.printf("%s (%d tuổi) - Lương: %.2f%n", name, age, salary());
    }
}
class OfficeEmployee extends Employee {
    private static final double DAILY_RATE = 100;
    private int workDays;

    public OfficeEmployee(String name, int age, int workDays) {
        super(name, age);
        this.workDays = workDays;
    }

    @Override
    public double salary() {
        return workDays * DAILY_RATE;
    }
}
class TechnicalEmployee extends Employee {
    private int workHours;
    private double hourlyRate;

    public TechnicalEmployee(String name, int age, int workHours, double hourlyRate) {
        super(name, age);
        this.workHours = workHours;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double salary() {
        return workHours * hourlyRate;
    }
}

    public class bai1 {
        public static void main(String[] args) {
            Employee[] employees = {
                new OfficeEmployee("An", 25, 22),
                new TechnicalEmployee("Bình", 28, 160, 15.5),
                new OfficeEmployee("Chi", 30, 20),
                new TechnicalEmployee("Dũng", 26, 170, 12)
         };
            for (Employee e : employees) {
                e.display();
            }
        
        }
    }
