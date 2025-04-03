import java.util.*;

class Person {
    private String name;
    private String address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public String toString() {
        return this.name + " - " + this.address;
    }
}

class Student extends Person {
    private int credits = 0;
    private int studentID;

    public Student(String name, String address, int studentID) {
        super(name, address);
        this.studentID = studentID;
    }

    public void study() {
        this.credits += 1;
    }

    public int getCredits() {
        return this.credits;
    }
    public String toString() {
        return super.toString() + " " + this.studentID;
    }
}

public class Main {
    public static void main(String[] args) {
        Student student = new Student("Ollie", "6381 Hollywood Blvd. Los Angeles", 90028);
        System.out.println(student.toString());
        System.out.println("Study credits " + student.getCredits());
        student.study();
        System.out.println("Study credits " + student.getCredits());
    }
}
