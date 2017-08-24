/**
 * Created by sunhongbo on 16/4/12.
 */
public class NumberOf1Bits {
    public static void main(String[] args) {
        int exa = 2147483600;
        System.out.println(hammingWeightS(exa));
    }
    //25 1 25 - 16 = 9 (1) 9 - 8 = 1 (2) 1 - 1 = 0 (3)
    //超时
    public static int hammingWeight(int n) {
        int res = 0;
        for(int i = 32; i >= 0; i--) {
            if (n == 0) return res;
            if (n >= (Math.pow(2,i))) {
                n -= Math.pow(2,i);
                res++;
            }
        }
        return res;
    }

    //8 1000 0111 7 0111 6 0110 5 0101

    public static int hammingWeightS(int n) {
        int res = 0;
        while(n != 0) {
            n = n & n-1;
            res++;
        }
        return res;
    }
}
