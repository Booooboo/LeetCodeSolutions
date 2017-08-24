/**
 * Created by sunhongbo on 16/4/18.
 */
public class UglyNumber {
    public static void main(String[] args) {
        //System.out.println(isUgly(13));
        int[] exa = {2, 7, 13, 19};
        System.out.println(nthSuperUglyNumber(12, exa));
    }
    public static boolean isUgly(int num) {
        if (num <= 0) return false;
        while(num % 2 == 0) num /= 2;
        while (num % 3 == 0) num /= 3;
        while (num % 5 == 0) num /= 5;
        if (num == 1) return true;
        return false;
    }

    public static int nthSuperUglyNumber(int n, int[] primes) {
        int res = 0;
        int temp = 0;
        while (res != n) {
            temp++;
            if (isSuperUgly(temp, primes)) {
                res++;
            }
        }
        return temp;
    }
    public static boolean isSuperUgly(int temp, int[] primes) {
        for (int i = 0; i < primes.length; i++) {
            while(temp % primes[i] == 0) temp /= primes[i];
        }
        if (temp == 1) return true;
        return false;
    }
}
