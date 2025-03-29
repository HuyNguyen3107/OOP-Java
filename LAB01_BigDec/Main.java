import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Đọc số lượng test case
        int t = Integer.parseInt(sc.nextLine());

        while (t-- > 0) {
            String[] numbers = sc.nextLine().split(" ");
            BigDecimal sumDecimal = BigDecimal.ZERO;

            for (String num : numbers) {
                BigDecimal number = new BigDecimal(num);
                BigDecimal integerPart = new BigDecimal(number.toBigInteger()); // Lấy phần nguyên
                BigDecimal decimalPart = number.subtract(integerPart).abs(); // Phần thập phân (luôn dương)

                sumDecimal = sumDecimal.add(decimalPart); // Cộng dồn phần thập phân
            }

            // Nếu tổng phần thập phân = 0, in "0" thay vì "0.0"
            if (sumDecimal.compareTo(BigDecimal.ZERO) == 0) {
                System.out.println(0);
            } else {
                System.out.println(sumDecimal.stripTrailingZeros().toPlainString());
            }
        }
        sc.close();
    }
}
