import java.util.*;

public class FIBO004 {
    // Hàm sinh dãy Fibonacci đến N
    public static List<Integer> generateFibonacci(int N) {
        List<Integer> fibo = new ArrayList<>();
        fibo.add(0);
        fibo.add(1);
        int a = 0, b = 1;
        while (b <= N) {
            int next = a + b;
            fibo.add(next);
            a = b;
            b = next;
        }
        return fibo;
    }

    // Tìm cặp Fibonacci có tổng bằng N
    public static String findFibonacciPair(int N, List<Integer> fibo) {
        Set<Integer> fiboSet = new HashSet<>(fibo); // Tăng tốc độ tìm kiếm
        for (int num : fibo) {
            int complement = N - num;
            if (fiboSet.contains(complement)) {
                return num + " " + complement;
            }
        }
        return "-1";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Số lượng test case
        List<Integer> fibo = generateFibonacci(1000000); // Tạo danh sách Fibonacci trước

        while (t-- > 0) {
            int N = sc.nextInt();
            System.out.println(findFibonacciPair(N, fibo));
        }
        sc.close();
    }
}
