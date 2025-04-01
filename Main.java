import java.util.*;
abstract class Shape {
    public abstract double calculateArea();
}

class Circle extends Shape {
    private double radius;
    
    public Circle(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return 3.14 * radius * radius;
    }
}

class Rectangle extends Shape {
    private double height;
    private double width;
    
    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    public double calculateArea() {
        return height * width;
    }
}

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(5.0);
        Rectangle rectangle = new Rectangle(4.0, 6.0);
        
        System.out.println("Circle area: " + circle.calculateArea());
        System.out.println("Rectangle area: " + rectangle.calculateArea());
    }
}