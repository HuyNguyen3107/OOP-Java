import java.util.*;

public class COBAN101 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); 

        while (T-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            if (a > b) { 
                int temp = a;
                a = b;
                b = temp;
            }

            int[] count = new int[10]; 

            for (int i = a; i <= b; i++) {
                countDigits(i, count);
            }

            
            for (int i = 0; i < 10; i++) {
                System.out.print(count[i] + " ");
            }
            System.out.println();
        }
        sc.close();
    }

    
    public static void countDigits(int num, int[] count) {
        if (num == 0) {
            count[0]++;
        }
        while (num > 0) {
            count[num % 10]++; 
            num /= 10; 
        }
    }
}
