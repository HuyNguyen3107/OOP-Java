import java.util.*;

public class KTGIAITHUA002 {
    public static long count (long m) {
        long count = 0;
        while (m >= 5) {
            m /= 5;
            count += m;
        }
        return count;
    }

    public static long findMin(long n) {
        long low = 0; 
        long high = n * 5;
        while (low < high) {
            long mid = (low +high) / 2;
            if (count(mid) >= n) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Số test case
        while (t-- > 0) {
            long n = scanner.nextLong();
            System.out.println(findMin(n));
        }
        scanner.close();
    }
}