import java.util.*;

public class STRING003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            StringBuffer sb = new StringBuffer(s);
            System.out.println(sb.length());
        }
    }
} 

