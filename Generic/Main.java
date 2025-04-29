import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Person {
    private String name;
    public Person(String name) {
        this.name = name;
    }

    public String toString() {
        return "Person name: " + this.name;
    }
}

class Course {
    private String name;
    public Course(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    public String toString() {
        return "Course name: " + this.name;
    }
}

class CourseNameComparator implements Comparator<Course> {

    @Override
    public int compare(Course o1, Course o2) {
        return o1.getName().compareTo(o2.getName());
    }   
}

class PersonNameComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o2.toString().compareTo(o1.toString());
    }
}

class Repository<T> {
    private List<T> ls;
    public Repository() {
        this.ls = new ArrayList<>();
    }

    public void add(T t) {
        this.ls.add(t);
    }

    public List<T> getList() {
        return this.ls;
    }

    public void print() {
        for (T t : ls) {
            System.out.println(t);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Repository<Person> persons = new Repository<>();
        persons.add(new Person("camnh"));
        persons.add(new Person("congnv"));
        persons.print();

        Collections.sort(persons.getList(), new PersonNameComparator());
        System.out.println("After sorting: ");
        persons.print();
        System.out.println("===================================");

        Repository<Course> courses = new Repository<>();
        courses.add(new Course("OOP"));
        courses.add(new Course("CNPM"));
        Collections.sort(courses.getList(), new CourseNameComparator());
        System.out.println("After sorting: ");
        courses.print();
    }
}

// class RepositoryPerson {
//     private List<Person> persons;
//     public RepositoryPerson() {
//         this.persons = new ArrayList<>();
//     }

//     public void add(Person p) {
//         this.persons.add(p);
//     }
// }

// class RepositoryCourse {
//     private List<Course> courses;
//     public RepositoryCourse() {
//         this.courses = new ArrayList<>();
//     }

//     public void add(Course p) {
//         this.courses.add(p);
//     }
// }