class Person {
    private int id;
    private String name;
    private int age;

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String printInfo() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age;
    }
}


class Employee extends Person {
    private int salary;

    public Employee(int id, String name, int age, int salary) {
        super(id, name, age);
        this.salary = salary;
    }

    public String printInfo() {
        return super.printInfo() + ", Salary: " + salary;
    }
}

class Student extends Person {
    private int credits;

    public Student(int id, String name, int age, int credits) {
        super(id, name, age);
        this.credits = credits;
    }   

    public String printInfo() {
        return super.printInfo() + ", Credits: " + credits;
    }
}

public class Main {
    public static void main(String[] args) {
        Person person = new Person(1, "Alice", 30);
        Employee employee = new Employee(2, "Bob", 40, 50000);
        Student student = new Student(3, "Charlie", 20, 30);

        System.out.println(person.printInfo());
        System.out.println(employee.printInfo());
        System.out.println(student.printInfo());
    }
}