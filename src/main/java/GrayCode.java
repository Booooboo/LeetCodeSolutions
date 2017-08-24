import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunhongbo on 16/4/20.
 */
public class GrayCode {
    public static void main(String[] args) {
        List<Integer> res = grayCode(3);

        int[][] matrix = {{0,0,0,5},{4,3,1,4},{0,1,1,4},{1,2,1,3},{0,0,1,1}};
        int[][] ma = {{0 ,1}};
        setZeroes(matrix);
    }
    //n = 2
    //00 01 11 10 000 001 011 01011 1011 ^ 0101 = 1110
    // 二进制转化为格雷码 10 110 100 101 111

    //格雷码公式 Gi = Bi 异或 (Bi >> 1)
    //例:n=4 第五个格雷码计算方法是 0101 异或 0010 = 0111
    public static List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>();
        int gray;
        for (int i = 0; i < Math.pow(2, n); i++) { // Math.Pow计算x的n次幂
            gray = i ^ (i >> 1);
            res.add(gray);
        }
        return  res;
    }

    // 错误解法 , 在原数组上东,原来的非零值会被覆盖成0
    public static void setZeroesWRONG(int[][] matrix) {
        int length = matrix.length;
        int width = matrix[0].length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if (matrix[i][j] == 0) {
                    int temi = 0, temj = 0;

                    while (temi < length) {
                        matrix[temi][j] = 0;
                        temi++;
                    }
                    while (temj < width) {
                        matrix[i][temj] = 0;
                        temj++;
                    }
                }
            }
        }
    }

    public static void setZeroes(int[][] matrix) {
        // 记录第一行和第一列是否要被清零 方法就是 第一行或者第一列有一个为0 一行或者一列就要清0
        // 找到应该清零的行和列  (然后除了第一行和第一列剩下的矩阵中 遇见为0的元素 ,把这个元素所在的行和列的 i0和0j标记为0)
        // 清零上一步找到的行列 (再次遍历除了第一行和第一列剩下的矩阵,把是0的行和列清零)
        boolean row = false , colum = false;
        for (int i = 0; i < matrix.length; i++) { // 第一步
            if (matrix[i][0] == 0) colum = true;
        }
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) row = true;
        }

        for (int i = 1; i < matrix.length; i++) {   // 第二步
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {   // 第三步
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (colum) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][0] = 0;
            }
        }
        if (row) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
    }






}
