/**
 * Created by sunhongbo on 16/4/18.
 */
public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(44));
    }
    // 1111 211 121 22 112
    public static int climbStairs(int n) {
        if (n < 3) {
            return n;
        }
        int[] matrix = new int[n];
        matrix[0] = 1;
        matrix[1] = 2;
        for (int i = 2; i < n; i++) {
            matrix[i] = matrix[i-1] + matrix[i-2];
        }
        return matrix[n-1];
    }
}
