/**
 * Created by sunhongbo on 16/5/26.
 */
public class BitwiseANDofNumbersRange {
    public static void main(String[] args) {

    }
    // 5 7 101 110 5和7的共同前缀是100 = 4
    //题目:找出m,n共同的前缀1 组成的数的值(其中 m < n)
    public static int rangeBitwiseAnd(int m, int n) {
        int i = 0;
        while (n != m) {
            n = n >> 1;
            m = m >> 1;
            i++;
        }
        return n <<i;
    }

    //网友的解法
    public static int rangeBitwise(int m, int n) {
        while (n > m) {
            n = n & (n-1);
        }
        return n;
    }
}
