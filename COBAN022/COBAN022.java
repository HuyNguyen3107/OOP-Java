import java.util.*;

public class COBAN022 {

    public static long maxChocolates(long X, long Y, long M) {
        long chocolates = M / X;
        long wrappers = chocolates;

        while (wrappers >= Y) {
            long newChocolates = wrappers / Y;
            chocolates += newChocolates;
            wrappers = wrappers % Y + newChocolates;
        }
        return chocolates;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long X = sc.nextLong(); // Giá mỗi hộp Sô-cô-la
            long Y = sc.nextLong(); // Số vỏ hộp cần để đổi 1 hộp mới
            long M = sc.nextLong(); // Số tiền có
            
            System.out.println(maxChocolates(X, Y, M));
        }
    }
}