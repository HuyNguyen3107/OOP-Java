import java.util.*;

interface Identifiable {
    String getId();
}

interface Payable {
    double calculateMonthlyPay();
}

class FullTime implements Identifiable, Payable {
    private String name;
    private String id;
    private double monthlySalary;

    public FullTime(String name, String id, double monthlySalary) {
        this.name = name;
        this.id = id;
        this.monthlySalary = monthlySalary;
    }

    public String getId() {
        return id;
    }

    public double calculateMonthlyPay() {
        return monthlySalary;
    }
}

class PartTime implements Identifiable, Payable {
    private String name;
    private String id;
    private double hourlyRate;
    private int hoursWorked;

    public PartTime(String name, String id, double hourlyRate, int hoursWorked) {
        this.name = name;
        this.id = id;
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    public String getId() {
        return id;
    }

    public double calculateMonthlyPay() {
        return hourlyRate * hoursWorked;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Payable> employees = new ArrayList<>();

        sc.nextLine(); // Bỏ qua dòng số lượng test case (luôn là 1)

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.equals("Calculate")) break;

            if (line.startsWith("FullTime")) {
                // Cắt tên trong dấu ngoặc kép
                int firstQuote = line.indexOf('"');
                int secondQuote = line.indexOf('"', firstQuote + 1);
                String name = line.substring(firstQuote + 1, secondQuote);

                // Lấy phần còn lại sau dấu ngoặc kép
                String[] parts = line.substring(secondQuote + 1).trim().split("\\s+");
                String id = parts[0];
                double salary = Double.parseDouble(parts[1]);

                employees.add(new FullTime(name, id, salary));
            } else if (line.startsWith("PartTime")) {
                int firstQuote = line.indexOf('"');
                int secondQuote = line.indexOf('"', firstQuote + 1);
                String name = line.substring(firstQuote + 1, secondQuote);

                String[] parts = line.substring(secondQuote + 1).trim().split("\\s+");
                String id = parts[0];
                double hourlyRate = Double.parseDouble(parts[1]);
                int hoursWorked = Integer.parseInt(parts[2]);

                employees.add(new PartTime(name, id, hourlyRate, hoursWorked));
            }
        }

        double total = 0.0;
        for (Payable p : employees) {
            total += p.calculateMonthlyPay();
        }

        System.out.printf("Total Monthly Payroll: %.2f\n", total);
    }
}
