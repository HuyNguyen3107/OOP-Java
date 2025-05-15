import java.util.Scanner;

// Lớp cha: Teacher
class Teacher {
    protected String name;
    protected double baseSalary;

    public Teacher(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public String getInfo() {
        return "Họ tên: " + name;
    }

    public double calculateSalary() {
        return baseSalary;
    }
}

// Lớp con: PermanentLecturer
class PermanentLecturer extends Teacher {
    private double researchAllowance;

    public PermanentLecturer(String name, double baseSalary, double researchAllowance) {
        super(name, baseSalary);
        this.researchAllowance = researchAllowance;
    }

    @Override
    public double calculateSalary() {
        return baseSalary + researchAllowance;
    }

    public void printInfo() {
        System.out.println("Loại giảng viên: Permanent");
        System.out.println(getInfo());
        System.out.println("Lương thực nhận: " + String.format("%.1f", calculateSalary()));
    }
}

// Lớp con: VisitingLecturer
class VisitingLecturer extends Teacher {
    private int teachingHours;
    private double paymentPerHour;

    public VisitingLecturer(String name, int teachingHours, double paymentPerHour) {
        super(name, 0); // Lương cơ bản không dùng
        this.teachingHours = teachingHours;
        this.paymentPerHour = paymentPerHour;
    }

    @Override
    public double calculateSalary() {
        return teachingHours * paymentPerHour;
    }

    public void printInfo() {
        System.out.println("Loại giảng viên: Visiting");
        System.out.println(getInfo());
        System.out.println("Lương thực nhận: " + String.format("%.1f", calculateSalary()));
    }
}

// Lớp Main
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập thông tin giảng viên 1
        String type1 = sc.nextLine();
        String name1 = sc.nextLine();
        String third1 = sc.nextLine();
        String fourth1 = sc.nextLine();

        System.out.println("--- Thông tin giảng viên ---");

        if (type1.equals("PermanentLecturer")) {
            double baseSalary = Double.parseDouble(third1);
            double allowance = Double.parseDouble(fourth1);
            PermanentLecturer pl1 = new PermanentLecturer(name1, baseSalary, allowance);
            pl1.printInfo();
        } else if (type1.equals("VisitingLecturer")) {
            int hours = Integer.parseInt(third1);
            double rate = Double.parseDouble(fourth1);
            VisitingLecturer vl1 = new VisitingLecturer(name1, hours, rate);
            vl1.printInfo();
        }

        // Nhập thông tin giảng viên 2
        String type2 = sc.nextLine();
        String name2 = sc.nextLine();
        String third2 = sc.nextLine();
        String fourth2 = sc.nextLine();

        if (type2.equals("PermanentLecturer")) {
            double baseSalary = Double.parseDouble(third2);
            double allowance = Double.parseDouble(fourth2);
            PermanentLecturer pl2 = new PermanentLecturer(name2, baseSalary, allowance);
            pl2.printInfo();
        } else if (type2.equals("VisitingLecturer")) {
            int hours = Integer.parseInt(third2);
            double rate = Double.parseDouble(fourth2);
            VisitingLecturer vl2 = new VisitingLecturer(name2, hours, rate);
            vl2.printInfo();
        }
    }
}
