import java.util.*;

// Functional Interface dùng để định nghĩa một phép chuyển đổi
interface Mapper<T, R> {
    R map(T t);
}

// Lớp xử lý chuyển đổi danh sách dựa vào Mapper
class GenericMapper {
    public static <T, R> List<R> map(List<T> input, Mapper<T, R> mapper) {
        List<R> result = new ArrayList<>();
        for (T item : input) {
            result.add(mapper.map(item));
        }
        return result;
    }
}

// Lớp biểu diễn đối tượng Employee
class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() { return name; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return name + ":" + salary;
    }
}

// ====== CÁC MAPPER CỤ THỂ ====== //

// Integer -> String
class IntegerToStringMapper implements Mapper<Integer, String> {
    public String map(Integer t) {
        return t.toString();
    }
}

// String -> Integer (độ dài chuỗi)
class StringToLengthMapper implements Mapper<String, Integer> {
    public Integer map(String t) {
        return t.length();
    }
}

// Employee -> String (name:salary)
class EmployeeToStringMapper implements Mapper<Employee, String> {
    public String map(Employee e) {
        return e.toString();
    }
}

// ====== LỚP CHÍNH ====== //

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextLine(); // Bỏ qua dòng số test case

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.equals("End")) break;

            String[] tokens = line.split(" ");
            String command = tokens[0];

            switch (command) {
                case "MapIntToString": {
                    int n = Integer.parseInt(tokens[1]);
                    List<Integer> input = new ArrayList<>();
                    for (int i = 0; i < n; i++) {
                        input.add(Integer.parseInt(tokens[2 + i]));
                    }

                    List<String> result = GenericMapper.map(input, new IntegerToStringMapper());
                    for (String s : result) {
                        System.out.println(s);
                    }
                    break;
                }

                case "MapStringToLength": {
                    int n = Integer.parseInt(tokens[1]);
                    List<String> input = new ArrayList<>();
                    for (int i = 0; i < n; i++) {
                        input.add(tokens[2 + i]);
                    }

                    List<Integer> result = GenericMapper.map(input, new StringToLengthMapper());
                    for (Integer i : result) {
                        System.out.println(i);
                    }
                    break;
                }

                case "MapEmployeeToString": {
                    int n = Integer.parseInt(tokens[1]);
                    List<Employee> input = new ArrayList<>();
                    for (int i = 0; i < n; i++) {
                        String name = tokens[2 + i * 2];
                        double salary = Double.parseDouble(tokens[3 + i * 2]);
                        input.add(new Employee(name, salary));
                    }

                    List<String> result = GenericMapper.map(input, new EmployeeToStringMapper());
                    for (String s : result) {
                        System.out.println(s);
                    }
                    break;
                }
            }
        }

        sc.close();
    }
}
