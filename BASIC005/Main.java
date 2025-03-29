import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String s = sc.nextLine();
            int[] nums = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
            int total = 0;
            for (int i = 0; i < nums.length; i++) {
                total += nums[i];
            }
            System.out.println(total);
        }
    }
}