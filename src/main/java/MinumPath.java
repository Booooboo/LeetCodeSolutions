/**
 * Created by sunhongbo on 16/4/25.
 */
public class MinumPath {
    public static void main(String[] args) {
        int[][] exa= new int[][]{{1,4,9},{2,6,3}};
        System.out.println(minPathSum(exa));
    }
    //1 4 9 0
    //2 6 3 0
    //7 8 9 0
    public static int minPathSum(int[][] grid) {
        int[][] res = new int[grid.length][grid[0].length];
        res[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            res[i][0] = res[i-1][0] + grid[i][0];
        }
        for (int j = 1; j < grid[0].length; j++) {
            res[0][j] = res[0][j-1] + grid[0][j];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j <grid[0].length; j++) {
                res[i][j] = Math.min(res[i-1][j], res[i][j-1]) + grid[i][j];
            }
        }
        return res[grid.length-1][grid[0].length-1];
    }
}
