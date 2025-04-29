import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine()); 
        while (t-- > 0) {
            String str = sc.nextLine(); 
            try {
                String result = solve(str); 
                System.out.println(result); 
            } catch (Exception e) {
                System.out.println(e.getMessage()); 
            }
        }
    }

    public static String solve(String str) throws Exception {
        str = str.toLowerCase(); 
        char[] arr = str.toCharArray(); 
        String vowels = "aeiou"; 
        for (char c : arr) {
            if (vowels.indexOf(c) != -1) { 
                return "String has vowels"; 
            }
        }
        throw new Exception("String not contain vowels"); 
    }
}
