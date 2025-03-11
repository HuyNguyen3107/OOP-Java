import java.util.*;

class Dog {
    String name;
    String breed;
    int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    public void printDogDetail() {
        System.out.println("Name:" + this.name + "--Breed:" + this.breed + "--Age:" + this.age);
    }
}

class TET_HOLIDAY {}

public class OOP001 {
    public static void main(String[] args) {
        Dog dog1 = new Dog();
        dog1.setName("Micky");
        dog1.setBreed("Husky");
        dog1.setAge(12);
        dog1.printDogDetail();
    }
}