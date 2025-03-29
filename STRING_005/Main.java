import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String s = sc.nextLine();
            System.out.println(isPangram(s));
        }
    }

    public static boolean isPangram(String s) {
        s = s.toLowerCase();
        boolean[] alphabet = new boolean[26];
        char[] chars = s.toCharArray();

        for (char c : chars) {
            if (c >= 'a' && c <= 'z') {
                alphabet[c - 'a'] = true;
            }
        }
        for (boolean b : alphabet) {
            if (!b) {
                return false;
            }
        }
        return true;
    }
}