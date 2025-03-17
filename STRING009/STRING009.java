import java.util.*;

public class STRING009 {
    public static String stringSplosion(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i <= str.length(); i++) {
            result.append(str.substring(0, i));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Đọc số test case
        sc.nextLine(); // Đọc ký tự xuống dòng

        while (t-- > 0) {
            String str = sc.nextLine();
            System.out.println(stringSplosion(str));
        }
        sc.close();
    }
}
