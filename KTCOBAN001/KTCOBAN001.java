import java.util.*;

public class KTCOBAN001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); 
        
        while (t-- > 0) {
            long n = sc.nextLong();
            System.out.println(isArmstrong(n) ? 1 : 0);
        }
        
        sc.close();
    }

   
    public static boolean isArmstrong(long n) {
        long temp = n;
        int numDigits = String.valueOf(n).length(); 
        long sum = 0;

        while (temp > 0) {
            int digit = (int) (temp % 10); 
            sum += Math.pow(digit, numDigits); 
            temp /= 10;
        }

        return sum == n;
    }
}
