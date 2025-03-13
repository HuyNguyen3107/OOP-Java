import java.io.*;

class Student {
    private String name;
    private int age;
    private static int count = 0; // Biến đếm số lượng đối tượng

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        count++; // Mỗi lần tạo đối tượng, tăng biến count
    }

    public void display() {
        if (age >= 18) {
            System.out.println(name);
        }
    }

    public static int getCount() {
        return count;
    }
}

public class OOP011 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            String name = line;
            int age = Integer.parseInt(br.readLine().trim());
            Student student = new Student(name, age);
            student.display();
        }

        System.out.println(Student.getCount()); // In số lượng đối tượng đã tạo
    }
}
