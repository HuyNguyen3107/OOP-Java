import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < t; i++) {
            String str = sc.nextLine();
            String result = getUpperChar(str);
            System.out.println("My initials are: " + result);
        }
    }

    public static String getUpperChar(String str) {
        char[] charArr = str.toCharArray();
        String result = "";

        for (int i = 0; i < charArr.length; i++) {
            if (Character.isUpperCase(charArr[i])) {
                result += charArr[i];
            }
        }
        return result;
    }
}