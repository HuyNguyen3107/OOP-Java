import java.util.Scanner;

public class KTCOBAN0101 {
    static final int MOD = 1000000007;

    // Hàm tính (a^n) % MOD bằng nhân bình phương có lũy thừa
    public static long powerMod(long a, long n, int mod) {
        long result = 1;
        while (n > 0) {
            if (n % 2 == 1) { // Nếu n lẻ
                result = (result * a) % mod;
            }
            a = (a * a) % mod; // Bình phương cơ số
            n /= 2;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Số test case
        while (t-- > 0) {
            long a = sc.nextLong();
            long n = sc.nextLong();
            System.out.println(powerMod(a, n, MOD));
        }
        sc.close();
    }
}
