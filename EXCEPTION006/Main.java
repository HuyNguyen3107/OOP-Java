import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine()); // Number of test cases
        while (t-- > 0) {
            String str = sc.nextLine(); // Read the actual string
            try {
                String result = solve(str); // Check for vowels
                System.out.println(result); // Print result
            } catch (Exception e) {
                System.out.println(e.getMessage()); // Handle any exceptions
            }
        }
    }

    public static String solve(String str) throws Exception {
        str = str.toLowerCase(); // Convert to lowercase
        char[] arr = str.toCharArray(); // Convert string to char array
        String vowels = "aeiou"; // Vowels
        for (char c : arr) {
            if (vowels.indexOf(c) != -1) { // Check if character is a vowel
                return "String has vowels"; 
            }
        }
        throw new Exception("String not contain vowels"); // Throw exception if no vowels
    }
}
