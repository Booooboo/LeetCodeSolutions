/**
 * Created by sunhongbo on 16/4/8.
 */
public class HardQueens2 {
    static int ret;
    public static void main(String[] args) {
        System.out.println(totalNQueens(2));
    }
    public static int totalNQueens(int n) {
        ret = 0;
        if (n <= 0) return ret;
        int[] loc = new int[n];
        dfs(loc, 0, n);
        return ret;
    }
    public static void dfs(int[] loc, int cur, int n) {
        if (cur == n) {
            ret += 1;
            return;
        }
        for (int i = 0; i < n; i++) {
            loc[cur] = i;
            if (isValid(loc, cur)) {
                dfs(loc, cur + 1, n);
            }
        }
    }
    public static boolean isValid(int[] loc, int cur) {
        for (int i = 0; i < cur; i++) {
            if(loc[i]==loc[cur]||Math.abs(loc[i]-loc[cur])==(cur-i)) {
                return false;
            }
        }
        return true;
    }

    //static int res;
    //public static int totalNQueens(int n) {
    //    res = 0;
    //    if(n<=0) return res;
    //    int[] loc = new int[n];
    //    dfs(loc,0,n);
    //    return res;
    //}
    //
    //public static void dfs(int[] loc, int cur, int n){
    //    if (cur==n) {
    //        res+=1;
    //        return;
    //    }
    //    for(int i=0;i<n;i++){
    //        loc[cur] = i;
    //        if(isValid(loc,cur))
    //            dfs(loc,cur+1,n);
    //    }
    //}
    //
    //public static boolean isValid(int[] loc, int cur){
    //    for(int i=0;i<cur;i++){
    //        if(loc[i]==loc[cur]||Math.abs(loc[i]-loc[cur])==(cur-i))
    //            return false;
    //    }
    //    return true;
    //}

}
