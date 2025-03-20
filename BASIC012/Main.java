import java.util.*;

public class Main {
    public static int longestNonDecreasingSubsequence(int[] arr) {
        if (arr.length == 0) return 0;

        int maxLength = 1, currentLength = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] >= arr[i - 1]) {
                currentLength++;
            } else {
                maxLength = Math.max(maxLength, currentLength);
                currentLength = 1;
            }
        }
        return Math.max(maxLength, currentLength);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = Integer.parseInt(scanner.nextLine());
        StringBuilder result = new StringBuilder();

        for (int t = 0; t < numberOfTestCases; t++) {
            String[] input = scanner.nextLine().split(" ");
            int[] arr = Arrays.stream(input)
                              .mapToInt(Integer::parseInt)
                              .toArray();
            result.append(longestNonDecreasingSubsequence(arr)).append("\n");
        }

        System.out.print(result);
        scanner.close();
    }
}
