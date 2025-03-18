import java.util.*;

public class BASIC011 {
    public static int minGap(int[] arr) {
        if (arr.length < 2) return 0; // Nếu mảng có ít hơn 2 phần tử, trả về 0
        
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            int diff = arr[i] - arr[i - 1];
            minDiff = Math.min(minDiff, diff);
        }
        return minDiff;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfTestCases = Integer.parseInt(sc.nextLine()); // Đọc số lượng test case

        for (int i = 0; i < numberOfTestCases; i++) {
            String[] input = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
            System.out.println(minGap(arr));
        }

        sc.close();
    }
}
