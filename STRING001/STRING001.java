import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
           String s = sc.nextLine();
           String input = sc.nextLine();

              if (check(s, input)) {
                System.out.println("true");
              } else {
                System.out.println("false");
              }
        }
    }

    public static boolean check(String s, String input) {
        String[] array = s.split(" ");

        for (String str : array) {
            if (str.equals(input)) {
                return true;
            }
        }

        return false;
    }
} 

