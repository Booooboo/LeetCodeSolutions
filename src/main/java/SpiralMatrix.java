/**
 * Created by sunhongbo on 16/4/25.
 */
public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] exa = generateMatrix(3);
        for (int i = 0; i < exa.length; i++) {
            for(int j = 0; j < exa[0].length; j++) {
                System.out.println(exa[i][j]);
            }
        }
    }
    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int begin = 0;
        int end = n-1;
        int num = 1;
        while (begin < end) {
            for (int j = begin; j < end; ++j) {
                res[begin][j] = num++;
            }
            for (int i  = begin; i < end; ++i) res[i][end] = num++;
            for (int j = end; j > begin; --j) res[end][j] = num++;
            for (int i = end; i > begin; --i) res[i][begin] = num++;
            begin++;
            end--;
         }
        if (begin == end) res[begin][end] = num;
        return res;
    }
}

