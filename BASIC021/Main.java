import java.util.Scanner;

public class Main {
    // Hàm tính giai thừa của một số nguyên
    public static long factorial(int num) {
        long result = 1;
        for (int i = 2; i <= num; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // Nhập số nguyên n
        long sum = 0;

        System.out.println("Factorials of numbers from 1 to " + n + ":");

        for (int i = 1; i <= n; i++) {
            long fact = factorial(i);
            System.out.println(i + "! = " + fact);
            sum += fact;
        }

        System.out.println("The sum of these factorials is: " + sum);
    }
}
