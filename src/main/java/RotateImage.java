/**
 * Created by sunhongbo on 16/4/26.
 */
public class RotateImage {
    public static void main(String[] args) {
        int[][] exa = {{1,2}, {3,4}};
        rotate(exa);
        for (int i=0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.println(exa[i][j]);
            }
        }
    }
    // 1 2 3 5   3 5 7   5 7 9 1  1 2   3 1
    // 2 4 5 7   2 4 5   3 5 7 2  3 4   4 2
    // 3 5 7 9   1 2 3   2 4 5 5
    // 3 5 2 1           1 2 3 3
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = n-1; j >= 0; j--) {
                res[i][j] = matrix[n-1-j][i];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = res[i][j];
            }
        }
    }
}
