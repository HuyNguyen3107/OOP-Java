import java.util.Scanner;

public class Main {
    // Hàm kiểm tra một số có phải là số nguyên tố không
    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n < 0) {
            System.out.println("Invalid input. Program terminated.");
            return;
        }

        System.out.println("Primes in the range 2 to " + n + ":");
        int primeCount = 0;

        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                System.out.println(i);
                primeCount++;
            }
        }

        System.out.println("Total number of primes in the range: " + primeCount);

        if (isPrime(primeCount)) {
            System.out.println("The prime count " + primeCount + " is a prime number.");
        } else {
            System.out.println("The prime count " + primeCount + " is not a prime number.");
        }
    }
}
