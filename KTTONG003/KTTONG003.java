import java.io.*;
import java.util.*;

public class KTTONG003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); 

        StringBuilder output = new StringBuilder(); 

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());

            int[][] matrix = new int[row][col];

            
            for (int i = 0; i < row; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < col; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            
            output.append(findMaxPathSum(matrix, row, col)).append("\n");
        }
        System.out.print(output.toString()); 
    }

    public static int findMaxPathSum(int[][] matrix, int row, int col) {
        int[] dp = new int[row]; 

        
        for (int i = 0; i < row; i++) {
            dp[i] = matrix[i][0];
        }

        
        for (int j = 1; j < col; j++) {
            int[] newDp = new int[row];

            for (int i = 0; i < row; i++) {
                int left = dp[i]; 
                int leftUp = (i > 0) ? dp[i - 1] : Integer.MIN_VALUE; 
                int leftDown = (i < row - 1) ? dp[i + 1] : Integer.MIN_VALUE; 

                
                newDp[i] = matrix[i][j] + Math.max(left, Math.max(leftUp, leftDown));
            }

            
            dp = newDp;
        }

        
        int maxSum = Integer.MIN_VALUE;
        for (int value : dp) {
            maxSum = Math.max(maxSum, value);
        }
        return maxSum;
    }
}
