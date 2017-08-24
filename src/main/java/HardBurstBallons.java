/**
 * Created by sunhongbo on 16/4/19.
 */
public class HardBurstBallons {
    public static void main(String[] args) {

    }
    public static int maxCoins(int[] nums) {
        int[] num = new int[nums.length + 2];
        int n = 1;
        for (int x : nums) if (x > 0) num[n++] = x;
        num[0] = num[n++] = 1;

        int[][] dp = new int[n][n];
        for (int k = 2; k < n; ++k)
            for (int l = 0; l < n - k; ++l) {
                int r = l + k;
                for (int m = l + 1; m < r; ++m)
                    dp[l][r] = Math.max(dp[l][r],
                                        num[l] * num[m] * num[r] + dp[l][m] + dp[m][r]);
            }

        return dp[0][n - 1];
    }
}
