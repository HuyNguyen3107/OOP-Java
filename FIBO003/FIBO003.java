import java.util.*;

public class FIBO003 {
    // Hàm kiểm tra số Fibonacci
    public static boolean isFibonacci(long n) {
        long a = 0, b = 1;
        while (b < n) {
            long temp = b;
            b = a + b;
            a = temp;
        }
        return (b == n); // Trả về true nếu n là số Fibonacci
    }

    public static long nextNonFibonacci(long n) {
        long a = 0, b = 1;
        while (b <= n) { // Tìm số Fibonacci lớn hơn n
            long temp = b;
            b = a + b;
            a = temp;
        }
        // Bây giờ b là số Fibonacci đầu tiên lớn hơn n
        long result = n + 1;
        while (isFibonacci(result)) {
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Số lượng test case

        while (t-- > 0) {
            long n = sc.nextLong();
            System.out.println(nextNonFibonacci(n));
        }
        sc.close();
    }
}
