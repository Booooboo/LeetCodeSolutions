/**
 * Created by sunhongbo on 16/5/16.
 */
public class FactorialTrailingZeroes {
    public static void main(String[] args) {

    }

    //25 = 5*5 25里面有两个5
    public static int trailingZeroes(int n) {
        int res = 0;
        while(n != 0) {
            res += n/5;
            n /= 5;
        }
        return res;
    }
}
