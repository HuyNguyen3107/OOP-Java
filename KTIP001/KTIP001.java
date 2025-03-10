import java.util.*;

public class KTIP001 {
    static int count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            count = 0;
            backTrack(s, 0, 0);
            System.out.println(count);
        }
    }

    public static void backTrack(String s, int index, int parts) {
        if (parts == 4) {
            if (index == s.length()) {
                count++;
            }
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (index + i <= s.length()) {
                String sub = s.substring(index, index + i);
                if (isValid(sub)) {
                    backTrack(s, index + i, parts + 1);
                }
            }
        }
    }

    public static boolean isValid(String s) {
        if (s.length() == 0 || s.length() > 3) {
            return false;
        }

        if (s.charAt(0) == '0' && s.length() > 1) {
            return false;
        }

        int num = Integer.parseInt(s);
        return num >= 0 && num <= 255;
    }
}