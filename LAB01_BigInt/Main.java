import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Đọc số lượng test case
        int t = Integer.parseInt(sc.nextLine());

        while (t-- > 0) {
            String s = sc.nextLine();
            String[] arr = s.split(" ");

            // Chuyển đổi số lớn sang BigInteger
            BigInteger n1 = new BigInteger(arr[0]);
            BigInteger n2 = new BigInteger(arr[2]);
            String operator = arr[1];

            // Xử lý phép toán
            if (operator.equals("+")) {
                System.out.println(n1.add(n2));
            } else if (operator.equals("-")) {
                System.out.println(n1.subtract(n2));
            } else if (operator.equals("*")) {
                System.out.println(n1.multiply(n2));
            }
        }
        sc.close();
    }
}
