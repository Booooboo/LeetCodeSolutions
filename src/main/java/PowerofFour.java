/**
 * Created by sunhongbo on 16/5/13.
 */
public class PowerofFour {
    public static void main(String[] args) {
        System.out.println(isPowerOfFour(8));
    }
    public static boolean isPowerOfFour(int num) {
        if (num == 0) return false;
        while (num%4 == 0) {
            num /= 4;
        }
        return num == 1;
    }
}
