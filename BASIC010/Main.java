import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        while(t-- > 0) {
            String s = sc.nextLine();
            System.out.println(solve(s));
        }
    }

    public static String solve(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;

        if (n % 2 == 0) {
            for (int i = 0; i < n - 1; i += 2) {
                char temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        } else {
            for (int i = 1; i < n - 1; i += 2) {
                char temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }

        return new String(arr);
    }
}