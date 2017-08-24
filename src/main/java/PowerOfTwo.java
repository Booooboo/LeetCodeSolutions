/**
 * Created by sunhongbo on 16/4/19.
 */
public class PowerOfTwo {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(1));
    }
    public static boolean isPowerOfTwo(int n) {
        if (n ==0) return false;
        while (n % 2 == 0) {
            n /= 2;
        }
        if (n == 1) return true;
        return false;
    }
}
