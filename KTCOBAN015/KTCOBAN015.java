import java.io.*;
import java.util.*;

public class KTCOBAN015 {
    // Hàm sinh tổ hợp bằng đệ quy
    public static void generateCombinations(int n, int k, int start, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current)); // Lưu tổ hợp vào danh sách kết quả
            return;
        }
        
        for (int i = start; i <= n; i++) {
            current.add(i);
            generateCombinations(n, k, i + 1, current, result);
            current.remove(current.size() - 1); // Quay lui
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine().trim()); // Đọc số lượng test case

        while (t-- > 0) {
            String[] input = br.readLine().trim().split(" ");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);

            List<List<Integer>> result = new ArrayList<>();
            generateCombinations(n, k, 1, new ArrayList<>(), result);

            sb.append(result.size()).append("\n"); // In số lượng tổ hợp tìm được
            for (List<Integer> combination : result) {
                sb.append("[");
                for (int i = 0; i < combination.size(); i++) {
                    if (i > 0) sb.append(" ");
                    sb.append(combination.get(i));
                }
                sb.append("]\n");
            }
        }
        System.out.print(sb); // In tất cả kết quả một lần để tối ưu tốc độ
    }
}
