import java.util.*;

public class KTUOCSO003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); 
        
        while (t-- > 0) {
            long n = sc.nextLong();
            System.out.println(isPerfectNumber(n) ? 1 : 0);
        }
        
        sc.close();
    }

    
    public static boolean isPerfectNumber(long n) {
        if (n == 1) return false;  
        if (n % 2 == 1) return false; 

        long sum = 1; 
        long sqrtN = (long) Math.sqrt(n); 

        for (long i = 2; i <= sqrtN; i++) {
            if (n % i == 0) {
                sum += i;
                if (i != n / i) sum += n / i; 
            }
        }

        return sum == n;
    }
}
