import java.util.*;
import java.io.*;

public class Main {

    public static int calDivision(int number) throws Exception {
        if (number == 0) {
            throw new Exception("Division by zero is not allowed.");
        }
        return 4 / number; // This will throw an ArithmeticException
    }

    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Result: " + calDivision(scanner.nextInt()));
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}