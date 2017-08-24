/**
 * Created by sunhongbo on 16/6/7.
 */
public class ReverseBits {
    public static void main(String[] args) {

        System.out.println(reverseBits(4));
    }
    //100
    public static int reverseBits(int n) {
        for (int i = 0; i < 16; i++) {
            n = swapBits(n, i, 32 - i - 1);
        }

        return n;
    }

    public static int swapBits(int n, int i, int j) {
        int a = (n >> i) & 1;
        int b = (n >> j) & 1;

        if ((a ^ b) != 0) {
            return n ^= (1 << i) | (1 << j);
        }

        return n;
    }
}
