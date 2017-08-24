import java.util.ArrayList;

/**
 * Created by sunhongbo on 16/4/13.
 */
public class UniqueBinaryST {
    public static void main(String[] args) {
        System.out.println(numTrees(2));
    }
    public static int numTrees(int n) {
        int[] res = new int[n+1];
        res[0] = 1;
        res[1] = 1;
        res[2] = 2;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                res[i] += res[j - 1] * res[i - j];
            }
        }
        return res[n];
    }
}
