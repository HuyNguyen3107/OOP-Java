import java.util.Scanner;

// Lớp cha
class Employee {
    protected String name;
    protected double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getInfo() {
        return "Họ tên: " + name;
    }

    public double calculateSalary() {
        return salary;
    }
}

// Lớp con FullTime
class FullTimeEmployee extends Employee {
    private double bonus;

    public FullTimeEmployee(String name, double salary, double bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return salary + bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void printInfo() {
        System.out.println("Loại: FullTime");
        System.out.println(getInfo());
        System.out.println("Lương cơ bản: " + String.format("%.1f", salary));
        System.out.println("Thưởng: " + String.format("%.1f", bonus));
        System.out.println("=> Lương thực nhận: " + String.format("%.1f", calculateSalary()));
    }
}

// Lớp con PartTime
class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name, int hoursWorked, double hourlyRate) {
        super(name, 0); // Lương cơ bản không dùng
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }

    public void printInfo() {
        System.out.println("Loại: PartTime");
        System.out.println(getInfo());
        System.out.println("Số giờ làm việc: " + hoursWorked + " giờ");
        System.out.println("Tiền công mỗi giờ: " + String.format("%.1f", hourlyRate));
        System.out.println("=> Lương thực nhận: " + String.format("%.1f", calculateSalary()));
    }
}

// Lớp Main
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhân viên 1
        String type1 = sc.nextLine();
        String name1 = sc.nextLine();
        String third1 = sc.nextLine();
        String fourth1 = sc.nextLine();

        System.out.println("--- Thông tin nhân viên ---");

        if (type1.equals("FullTime")) {
            double baseSalary = Double.parseDouble(third1);
            double bonus = Double.parseDouble(fourth1);
            FullTimeEmployee emp1 = new FullTimeEmployee(name1, baseSalary, bonus);
            emp1.printInfo();
        } else {
            int hoursWorked = Integer.parseInt(third1);
            double hourlyRate = Double.parseDouble(fourth1);
            PartTimeEmployee emp1 = new PartTimeEmployee(name1, hoursWorked, hourlyRate);
            emp1.printInfo();
        }

        System.out.println(); // Dòng trắng ngăn cách

        // Nhân viên 2
        String type2 = sc.nextLine();
        String name2 = sc.nextLine();
        String third2 = sc.nextLine();
        String fourth2 = sc.nextLine();

        if (type2.equals("FullTime")) {
            double baseSalary = Double.parseDouble(third2);
            double bonus = Double.parseDouble(fourth2);
            FullTimeEmployee emp2 = new FullTimeEmployee(name2, baseSalary, bonus);
            emp2.printInfo();
        } else {
            int hoursWorked = Integer.parseInt(third2);
            double hourlyRate = Double.parseDouble(fourth2);
            PartTimeEmployee emp2 = new PartTimeEmployee(name2, hoursWorked, hourlyRate);
            emp2.printInfo();
        }
    }
}
