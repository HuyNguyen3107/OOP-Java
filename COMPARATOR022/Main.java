import java.util.*;

class Student {
    String name;
    int birthYear;
    double gpa;
    int credit;

    public Student(String name, int birthYear, double gpa, int credit) {
        this.name = name;
        this.birthYear = birthYear;
        this.gpa = gpa;
        this.credit = credit;
    }

    @Override
    public String toString() {
        return name + " " + birthYear + " " + gpa + " " + credit;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(" ");
            String name = parts[0];
            int birthYear = Integer.parseInt(parts[1]);
            double gpa = Double.parseDouble(parts[2]);
            int credit = Integer.parseInt(parts[3]);
            students.add(new Student(name, birthYear, gpa, credit));
        }

        String criteria = sc.nextLine();

        if (criteria.equals("BY_GPA_CREDIT_NAME")) {
            students.sort(
                Comparator.comparingDouble((Student s) -> -s.gpa)
                    .thenComparingInt(s -> -s.credit)
                    .thenComparing(s -> s.name)
            );
        } else if (criteria.equals("BY_BIRTH_GPA_NAME")) {
            students.sort(
                Comparator.comparingInt((Student s) -> s.birthYear)
                    .thenComparingDouble(s -> -s.gpa)
                    .thenComparing(s -> s.name)
            );
        }

        for (Student s : students) {
            System.out.println(s);
        }
    }
}
