import java.util.*;

// Functional interfaces
interface Filter<T> {
    boolean test(T t);
}

interface Mapper<T, R> {
    R map(T t);
}

// Danh sách xử lý
class ListProcessor {
    public static <T> List<T> filter(List<T> input, Filter<T> filter) {
        List<T> result = new ArrayList<>();
        for (T item : input) {
            if (filter.test(item)) {
                result.add(item);
            }
        }
        return result;
    }

    public static <T, R> List<R> map(List<T> input, Mapper<T, R> mapper) {
        List<R> result = new ArrayList<>();
        for (T item : input) {
            result.add(mapper.map(item));
        }
        return result;
    }

    public static <T> List<T> sort(List<T> input, Comparator<T> comparator) {
        List<T> result = new ArrayList<>(input);
        result.sort(comparator);
        return result;
    }
}

// Class Student
class Student {
    private String name;
    private double gpa;

    public Student(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    public String getName() { return name; }
    public double getGpa() { return gpa; }

    @Override
    public String toString() {
        return name + " " + gpa;
    }
}

// ============================
// Các class implements interface
// ============================

// Filter: GPA > threshold
class FilterGpaAboveThreshold implements Filter<Student> {
    private double threshold;

    public FilterGpaAboveThreshold(double threshold) {
        this.threshold = threshold;
    }

    @Override
    public boolean test(Student s) {
        return s.getGpa() > threshold;
    }
}

// Mapper: Student -> name
class StudentToNameMapper implements Mapper<Student, String> {
    @Override
    public String map(Student s) {
        return s.getName();
    }
}

// Filter: odd numbers
class IntOddFilter implements Filter<Integer> {
    @Override
    public boolean test(Integer x) {
        return x % 2 != 0;
    }
}

// Mapper: x -> x^2
class IntSquareMapper implements Mapper<Integer, Integer> {
    @Override
    public Integer map(Integer x) {
        return x * x;
    }
}

// ============================
// Main
// ============================
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextLine(); // bỏ qua số lượng test case

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.equals("End")) break;

            String[] tokens = line.split(" ");
            String command = tokens[0];

            switch (command) {
                case "FilterGpaAbove": {
                    double threshold = Double.parseDouble(tokens[1]);
                    int n = Integer.parseInt(tokens[2]);
                    List<Student> students = new ArrayList<>();
                    for (int i = 0; i < n; i++) {
                        String name = tokens[3 + i * 2];
                        double gpa = Double.parseDouble(tokens[4 + i * 2]);
                        students.add(new Student(name, gpa));
                    }

                    FilterGpaAboveThreshold filter = new FilterGpaAboveThreshold(threshold);
                    List<Student> result = ListProcessor.filter(students, filter);
                    for (Student s : result) {
                        System.out.println(s);
                    }
                    break;
                }

                case "MapStudentToName": {
                    int n = Integer.parseInt(tokens[1]);
                    List<Student> students = new ArrayList<>();
                    for (int i = 0; i < n; i++) {
                        String name = tokens[2 + i * 2];
                        double gpa = Double.parseDouble(tokens[3 + i * 2]);
                        students.add(new Student(name, gpa));
                    }

                    StudentToNameMapper mapper = new StudentToNameMapper();
                    List<String> result = ListProcessor.map(students, mapper);
                    for (String s : result) {
                        System.out.println(s);
                    }
                    break;
                }

                case "SortStudentByGpa": {
                    int n = Integer.parseInt(tokens[1]);
                    List<Student> students = new ArrayList<>();
                    for (int i = 0; i < n; i++) {
                        String name = tokens[2 + i * 2];
                        double gpa = Double.parseDouble(tokens[3 + i * 2]);
                        students.add(new Student(name, gpa));
                    }

                    List<Student> result = ListProcessor.sort(students,
                            new Comparator<Student>() {
                                public int compare(Student a, Student b) {
                                    return Double.compare(a.getGpa(), b.getGpa());
                                }
                            });
                    for (Student s : result) {
                        System.out.println(s);
                    }
                    break;
                }

                case "FilterIntOdd": {
                    int n = Integer.parseInt(tokens[1]);
                    List<Integer> nums = new ArrayList<>();
                    for (int i = 0; i < n; i++) {
                        nums.add(Integer.parseInt(tokens[2 + i]));
                    }

                    IntOddFilter filter = new IntOddFilter();
                    List<Integer> result = ListProcessor.filter(nums, filter);
                    for (Integer i : result) {
                        System.out.println(i);
                    }
                    break;
                }

                case "SortIntAsc": {
                    int n = Integer.parseInt(tokens[1]);
                    List<Integer> nums = new ArrayList<>();
                    for (int i = 0; i < n; i++) {
                        nums.add(Integer.parseInt(tokens[2 + i]));
                    }

                    List<Integer> result = ListProcessor.sort(nums, Integer::compare);
                    for (Integer i : result) {
                        System.out.println(i);
                    }
                    break;
                }

                case "MapIntToSquare": {
                    int n = Integer.parseInt(tokens[1]);
                    List<Integer> nums = new ArrayList<>();
                    for (int i = 0; i < n; i++) {
                        nums.add(Integer.parseInt(tokens[2 + i]));
                    }

                    IntSquareMapper mapper = new IntSquareMapper();
                    List<Integer> result = ListProcessor.map(nums, mapper);
                    for (Integer i : result) {
                        System.out.println(i);
                    }
                    break;
                }
            }
        }

        sc.close();
    }
}
