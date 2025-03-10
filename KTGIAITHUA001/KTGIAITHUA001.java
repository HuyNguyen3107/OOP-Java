import java.math.BigInteger;
import java.util.Scanner;

public class KTGIAITHUA001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); 
        
        while (t-- > 0) {
            int n = sc.nextInt(); 
            System.out.println(factorial(n)); 
        }
        sc.close();
    }

    public static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE; 
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i)); 
        }
        return result;
    }
}
