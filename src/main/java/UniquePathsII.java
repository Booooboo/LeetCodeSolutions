/**
 * Created by sunhongbo on 16/6/3.
 */
public class UniquePathsII {
    public static void main(String[] args) {
        int[][] exa = {{0,0,0}, {0,1,0}, {0,0,0}};
        System.out.println(uniquePathsWithObstacles(exa));
    }

    //动态规划的方法
    public static int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length==0 || obstacleGrid[0].length==0)
            return 0;
        //更新的时候用一个以为数组就足够了
        int[] res = new int[obstacleGrid[0].length]; //每行都用这个以为数组来记录路径数
        res[0] = 1;
        for(int i=0;i<obstacleGrid.length;i++)
        {
            for(int j=0;j<obstacleGrid[0].length;j++)
            {
                if(obstacleGrid[i][j]==1)
                {
                    res[j]=0;
                }
                else
                {
                    if(j>0)
                        res[j] += res[j-1];// 相当于是 res[i][j] = res[i][j-1] + res[i-1][j]
                }
            }
        }
        return res[obstacleGrid[0].length-1];
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        int[] res = new int[obstacleGrid[0].length];
        res[0] = 1;
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    res[j] = 0;
                } else {
                    if (j > 0) {
                        res[j] += res[j - 1];
                    }
                }
            }
        }
        return res[obstacleGrid[0].length -1];
    }
}
