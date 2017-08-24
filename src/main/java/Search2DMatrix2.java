/**
 * Created by sunhongbo on 16/4/27.
 */
public class Search2DMatrix2 {
    public static void main(String[] args) {
        int[][] exa = {{1, 1}};
        System.out.println(searchMatrix(exa, 2));
    }

    //从右上角开始, 比较target 和 matrix[i][j]的值. 如果小于target, 则该行不可能有此数,  所以i++; 如果大于target, 则该列不可能有此数, 所以j--.
    // 遇到边界则表明该矩阵不含target.
    //[
    //        [1,   4,  7, 11, 15],
    //        [2,   5,  8, 12, 19],
    //        [3,   6,  9, 16, 22],
    //        [10, 13, 14, 17, 24],
    //        [18, 21, 23, 26, 30]
    //        ]
    //public static boolean searchMatrixLLL(int[][] matrix, int target) {
    //    int[][] array01 = new int[matrix.length][matrix[0].length];
    //    int m = matrix.length;
    //    int n = matrix[0].length;
    //    if (matrix[m/2][n/2] > target) {
    //
    //    }
    //}


    public static boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length; //1
        int n = matrix[0].length; //2
        int i = 0;
        int j = n - 1; //1
        while (i < m && j >= 0) {
            if (matrix[i][j] == target)
                return true;
            if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }

        }
        return false;
    }




    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int j = n - 1;
        while (j >= 0 && i < m) {
            if (matrix[i][j] == target)
                return true;
            if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
