/**
 * Created by sunhongbo on 16/6/12.
 */
public class EditDistance {
    public static void main(String[] args) {
        System.out.println(minDistance("intention", "execution"));
    }

    //Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each
    // operation is counted as 1 step.)
    //
    //You have the following 3 operations permitted on a word:
    //
    //a) Insert a character
    //b) Delete a character
    //func) Replace a character
    public static int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        if (len1 == 0)
            return len2;
        if (len2 == 0)
            return len1;
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++)
            dp[i][0] = i; //初始值为i
        for (int j = 0; j <= len2; j++)
            dp[0][j] = j;
        int count;
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                count = (word1.charAt(i - 1) == word2.charAt(j - 1)) ? 0 : 1; // 如果当前比较的字母相等,则不需要处理,否则替换需要一步操作.
                // 动态规划 取最小的步骤
                dp[i][j] = Math.min(dp[i - 1][j - 1] + count, Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
            }
        }
        return dp[len1][len2];
    }
}
