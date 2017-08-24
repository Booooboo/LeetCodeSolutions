/**
 * Created by sunhongbo on 16/3/30.
 */
public class HardSingleNUmber {
    public static void main(String[] args) {
        int[] exa = {5, 2, 1, 8, 2, 5};
        int[] res = singleNumber(exa);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }

    //因为有两个只出现1次的变量，所以我们将所有数字一起异或后得到的数实际上是这两个数异或的结果。对于这个结果，如果某一位是0，那么这两个数在这一位上有可能都是0，或者都是1。如果某一位是1
    //，那么这两个数载这一位上一定是不一样的，一个是1，一个是0，才能异或出1。所以我们随便找一位是1的（除非两个数相等，不然不可能没有一位是1），将所有数中这一位是1的分一组，这一位是0
    //的分一组。这样两个数肯定在两个不同组里。我们对两个组分别异或，就能得到两个数。

    public static int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            n ^= nums[i];
        }
        n = n & ~(n - 1);
        for (int i = 0; i < nums.length; i++) {
            if ((n & nums[i]) == n) {
                res[0] ^= nums[i];
            } else {
                res[1] ^= nums[i];
            }
        }
        return res;
    }
}
