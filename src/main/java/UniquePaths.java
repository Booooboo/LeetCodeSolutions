/**
 * Created by sunhongbo on 16/4/20.
 */
public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(uniquePaths(10,10));
    }
    public static int uniquePaths(int m, int n) {
        //往右边走m-1 ,往左走n-1, 求m-1和n-1的组合
        if (m == 1 || n ==1) return 1;
        long res = 1;
        //n-1的阶乘
        long x = 1;
        long temp = Math.min(m, n);
        while (temp > 1) {
            res *= Math.max(m, n)-1+1+Math.min(m, n)-temp;
            temp -= 1;
            x *= temp;
        }
        return new Long(res/x).intValue();
    }

    //使用动态规划的方法
    public static int uniquePath(int m, int n) {
        if (m == 0 || n == 0) return 0;
        if (m == 1 || n == 1) return 1;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            res[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            res[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                res[i][j] = res[i-1][j] + res[i][j-1];
            }
        }
        return res[m-1][n-1];
    }
}
