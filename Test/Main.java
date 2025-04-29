import java.util.*;


class NumberNotEqualOneException extends Exception {
    public NumberNotEqualOneException(String message) {
        super(message);
    }
}

public class Main {
    
    public static int division() throws ArithmeticException, NumberNotEqualOneException {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if (num == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }

        if (num == 1) {
            throw new NumberNotEqualOneException("Number is equal to one.");
        }

        return 4 / num;
    }
    
    public static void main(String[] args) {
        try {
            division();
        } catch (ArithmeticException e) {
            System.out.println("Caught an ArithmeticException: " + e.getMessage());
        } catch (NumberNotEqualOneException e) {
            System.out.println("Caught a NumberNotEqualOneException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Caught a general Exception: " + e.getMessage());
        } finally {
            System.out.println("Execution completed.");
        }
    }
}