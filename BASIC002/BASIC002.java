import java.util.*;

public class BASIC002 {
    static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            int N = sc.nextInt();
            int goal = sc.nextInt();
            System.out.println(solve(N, goal, k));
        }
    }

    public static int solve(int N, int goal, int k) {
        long[][] dp = new long[goal + 1][N + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= goal; i++) {
            for (int j = 1; j <= N; j++) {
               dp[i][j] = (dp[i][j] + dp[i - 1][j - 1] * (N - (j - 1))) % MOD;

               dp[i][j] = (dp[i][j] + dp[i - 1][j] * Math.max(j - k, 0)) % MOD;
            }
        }

        return (int) dp[goal][N];
    }
}