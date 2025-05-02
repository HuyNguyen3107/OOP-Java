import java.util.*;

interface Filter<T> {
    boolean test(T t);
}

class GenericFilter {
    public static <T> List<T> filter(List<T> input, Filter<T> filter) {
        List<T> result = new ArrayList<>();
        for (T item : input) {
            if (filter.test(item)) {
                result.add(item);
            }
        }
        return result;
    }
}

class IntegerEvenFilter implements Filter<Integer> {
    @Override
    public boolean test(Integer t) {
        return t % 2 == 0;
    }
}

class StringLengthFilter implements Filter<String> {
    private int minLength;

    public StringLengthFilter(int minLength) {
        this.minLength = minLength;
    }

    @Override
    public boolean test(String s) {
        return s.length() >= minLength;
    }
}

class EmployeeSalaryFilter implements Filter<Employee> {
    private double minSalary;

    public EmployeeSalaryFilter(double minSalary) {
        this.minSalary = minSalary;
    }

    @Override
    public boolean test(Employee e) {
        return e.getSalary() >= minSalary;
    }
}

class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return name + " " + salary;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = Integer.parseInt(sc.nextLine()); // chỉ dùng 1

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.equals("End")) break;

            String[] parts = line.split(" ");
            String command = parts[0];

            switch (command) {
                case "FilterIntEven":
                    int n = Integer.parseInt(parts[1]);
                    List<Integer> intList = new ArrayList<>();
                    for (int i = 0; i < n; i++) {
                        intList.add(Integer.parseInt(parts[2 + i]));
                    }
                    List<Integer> evenFiltered = GenericFilter.filter(intList, new IntegerEvenFilter());
                    printList(evenFiltered);
                    break;

                case "FilterStringLength":
                    int minLen = Integer.parseInt(parts[1]);
                    int sn = Integer.parseInt(parts[2]);
                    List<String> stringList = new ArrayList<>();
                    for (int i = 0; i < sn; i++) {
                        stringList.add(parts[3 + i]);
                    }
                    List<String> stringFiltered = GenericFilter.filter(stringList, new StringLengthFilter(minLen));
                    printList(stringFiltered);
                    break;

                case "FilterEmployeeSalary":
                    double minSalary = Double.parseDouble(parts[1]);
                    int en = Integer.parseInt(parts[2]);
                    List<Employee> employees = new ArrayList<>();
                    int index = 3;
                    for (int i = 0; i < en; i++) {
                        String name = parts[index++];
                        double salary = Double.parseDouble(parts[index++]);
                        employees.add(new Employee(name, salary));
                    }
                    List<Employee> employeeFiltered = GenericFilter.filter(employees, new EmployeeSalaryFilter(minSalary));
                    printList(employeeFiltered);
                    break;
            }
        }
    }

    private static <T> void printList(List<T> list) {
        if (list.isEmpty()) {
            System.out.println("None");
        } else {
            for (T item : list) {
                System.out.println(item);
            }
        }
    }
}