/**
 * Created by sunhongbo on 16/6/13.
 */
public class DistinctSubsequences {
    public static void main(String[] args) {
        System.out.println(numDistinct("rabbbit", "rabbit"));
    }
    //只可以用删除字符的方法从第一个字符串变换到第二个字符串，求出一共有多少种变换方法。
    public static int numDistinct(String s, String t) {
        //使用动态规划的方法
        //使用 一个二维数组Dp[i][j] 来存储 i变化到j的方法数
        // S中当前字符串跟T中当前字符串相等, 可以保留 dp[i][j] = dp[i-1][j-1], 也可以不保留s中当前字符 dp[i][j] = dp[i-1][j]
        if (s == null) {
            return 0; //s中没有t
        }
        if (t == null) {
            return 1; // t为空,只有一种方法
        }
        int[][] dp = new int[s.length()+1][t.length()+1];
        dp[0][0] = 1; // 空变到空 变换只有一种方法
        for (int i = 0; i <= s.length(); i++) {
            dp[i][0] = 1; // i 变成 空 只有一种方法
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                dp[i][j] = dp[i-1][j]; // 不保留s当前的字符
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] += dp[i-1][j-1]; // 如果s的第i个 和 t的第j个相等, 跟前一组的方法数一样
                }
            }
        }
        return dp[s.length()][t.length()];
    }



    //题意理解错误
    public static int numDistinctW(String s, String t) {
        int lens = s.length();
        int lent = t.length();
        int[] count = new int[lens];
        int k = 0;
        for (int  i = 0; i < lens; i++) {
            for (int j  = 0; j < lent; j++) {
                if (s.charAt(i) == t.charAt(j) ) {
                    if (j != 0 && t.charAt(j) == t.charAt(j-1)) {
                        continue;
                    }
                    i++;
                    count[k]++;
                } else {
                    k++;
                }
            }
        }
        int res = count[0];
        for (int n = 1; n < lens; n++) {
            if (res < count[n]) {
                res = count[n];
            }
        }
        return res;
    }
}
