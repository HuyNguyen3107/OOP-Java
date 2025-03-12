import java.util.*;
import java.io.*;

public class KTDAYSO001 {   
    public static boolean isArithmeticSequence(int[] arr, int n) {
        if (n < 2) return true;

        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;

        HashSet<Integer> set = new HashSet<>();

        for (int num : arr) {
            minVal = Math.min(minVal, num);
            maxVal = Math.max(maxVal, num);
            set.add(num);
        }

        if ((maxVal - minVal) % (n - 1) != 0) return false;

        int d = (maxVal - minVal) / (n - 1);

        for (int i = 0; i < n; i++) {
            if (!set.contains(minVal + i * d)) return false;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder result = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());
        for (int t = 0; t < T; t++) {
           int n = Integer.parseInt(br.readLine().trim());
              int[] arr = new int[n];
                String[] str = br.readLine().trim().split(" ");
                for (int i = 0; i < n; i++) {
                    arr[i] = Integer.parseInt(str[i]);
                }

                result.append(isArithmeticSequence(arr, n) ? "YES" : "NO").append("\n");
        }
        System.out.println(result);
        
    }
}
