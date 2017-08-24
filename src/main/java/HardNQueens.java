import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunhongbo on 16/4/8.
 */
public class HardNQueens {
    public static void main(String[] args) {
        int n = 10;
    }

    public static List<List<String>> solveNQueens(int n) {
        ArrayList<List<String>> res = new ArrayList<List<String>>();
        int[] loc = new int[n];
        dfs(res, loc, 0, n);
        return res;
    }

    public static void dfs(ArrayList<List<String>> res, int[] loc, int cur, int n) {
        if (cur == n) {
            List<String > ans = new ArrayList<String>();
            for (int i = 0; i < n; i++) {
                String s = new String();
                for (int j = 0; j < n; j++) {
                    if (j == loc[i]) {
                        s += "Q";
                    } else {
                        s += ".";
                    }
                }
                ans.add(s);
            }
            res.add(ans);
        } else {
            for (int i = 0; i < n; i++) {
                loc[cur] = i; //如果第cur行第i列的值可以是Queen,那么就把这个值写成i,那么在输出数组时候就可以根据 j==loc[i]来判断
                if (isValid(loc, cur)) { //判断第cur行第i列的值 是否可以是Queen
                    dfs(res, loc, cur+1, n); //如果可以找出下一行可以成为queens的地方,并把它赋值成第i列的i值
                }
            }
        }

    }

    public static boolean isValid(int[] loc, int cur) {
        for (int i = 0; i < cur; i++) {//判断是否有在同一列上的 queens,因为每行的queens,它的标识是列值.
                                        //或者对角线上的元素,长等于宽
            if (loc[i] == loc[cur] || Math.abs(loc[i] - loc[cur]) == (cur - i))
                return false;
        }
        return true;
    }

    //public ArrayList<String[]> solveNQueens(int n) {
    //    ArrayList<String[]> res = new ArrayList<String[]>();
    //    int[] loc = new int[n];
    //    dfs(res, loc, 0, n);
    //    return res;
    //}
    //
    //public void dfs(ArrayList<String[]> res, int[] loc, int cur, int n) {
    //    if (cur == n)
    //        printboard(res, loc, n);
    //    else {
    //        for (int i = 0; i < n; i++) {
    //            loc[cur] = i;
    //            if (isValid(loc, cur))
    //                dfs(res, loc, cur + 1, n);
    //        }
    //
    //    }
    //}
    //
    //public boolean isValid(int[] loc, int cur) {
    //    for (int i = 0; i < cur; i++) {
    //        if (loc[i] == loc[cur] || Math.abs(loc[i] - loc[cur]) == (cur - i))
    //            return false;
    //    }
    //    return true;
    //}
    //
    //public void printboard(ArrayList<String[]> res, int[] loc, int n) {
    //    String[] ans = new String[n];
    //    for (int i = 0; i < n; i++) {
    //        String row = new String();
    //        for (int j = 0; j < n; j++) {
    //            if (j == loc[i])
    //                row += "Q";
    //            else
    //                row += ".";
    //        }
    //        ans[i] = row;
    //    }
    //    res.add(ans);
    //}
}
