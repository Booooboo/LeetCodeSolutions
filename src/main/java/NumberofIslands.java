/**
 * Created by sunhongbo on 16/6/17.
 */
public class NumberofIslands {
    public static void main(String[] args) {

    }
    // 找到一个1把1周围相邻的上下左右的节点都设置成X 这样 遍历的第一个1的个数就是islands的个数
    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    merge(grid, i, j);
                }
            }
        }
        return count;
    }

    public static void merge(char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if (i<0 || i>=m || j<0 || j>=n || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = 'X';
        merge(grid, i-1, j);
        merge(grid, i+1, j);
        merge(grid, i, j-1);
        merge(grid, i, j+1);
    }
}
