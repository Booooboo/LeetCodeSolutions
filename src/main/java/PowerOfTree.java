/**
 * Created by sunhongbo on 16/4/19.
 */
public class PowerOfTree {
    public static void main(String[] args) {
        System.out.println(isPowerOfThree(1));
    }
    public static boolean isPowerOfThree(int n) {
        if (n == 0) return false;
        double res = Math.log10(n) / Math.log10(3);
        return (res - (int) res ) == 0;
        //return  (Math.abs(res - Math.round(res)) < 10e-15);
    }
    //2的幂次有个特点:二进制表示形式中只有一位为1,其余各位都是0
    public static boolean isPowerOfThree2(int n) {
        return n > 0 && (n & (n-1)) == 0;
    }
}
