import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-- > 0) {
            String s = sc.nextLine();
            if (s.isEmpty()) {
                System.out.println("");
                continue;
            }
            System.out.println(solve(s));
        }  
    }

    public static String solve(String s) {
        String[] arr = s.split(" ");

        int max = 0;
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() >= max) {
                max = arr[i].length();
                index = i;
            }
        }
        return arr[index];
    }
}