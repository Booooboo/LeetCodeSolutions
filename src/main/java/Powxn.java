/**
 * Created by sunhongbo on 16/6/21.
 */
public class Powxn {
    public static void main(String[] args) {
        // System.out.println(myPow(2.00000, -21474836483)); //
    }
    public static double myPow(double x, int n) {
        // n = 0情况
        if (n < 0) {
            return 1/pow(x, -n);
        } else {
            return pow(x, n);
        }
    }
    // x的n次幂 每次把n除以2 从v等一1开始 逐个 向上
    // 比如倒数第二层的 v*v = x*x * x*x
    public static double pow(double x, int n) {
        if (n == 0) return 1;
        double v = pow(x , n/2);
        if (n % 2 == 0) { // 如果n是超大数, 先判断 n%2 == 1会有问题
            return v * v; //第一次v = 1
        } else {
            return v * v * x;
        }
    }
}
