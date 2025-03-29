import java.util.*;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] arr = sc.nextLine().split(" ");
            int index = Integer.parseInt(arr[1]);
            // The character at position 0 is F
            System.out.println("The character at position " + index + " is " + arr[0].charAt(index));
        }
    }
}