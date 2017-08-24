/**
 * Created by sunhongbo on 16/4/1.
 */
public class ProductArray {
    public static void main(String[] args) {
        int[] exa= {1,2,0,4};
        int[] o = productExceptSelfW(exa);
        for (int i = 0; i < exa.length; i++) {
            System.out.println(o[i]);
        }
    }

    public static int[] productExceptSelfW(int[] nums) {
        int[] ret = new int[nums.length];
        ret[ret.length - 1] = 1;
        for (int i = ret.length - 2; i >= 0; i--) {
            ret[i] = ret[i+1] * nums[i+1];
        }
        int left = 1;
        for (int i=0; i<nums.length; i++) {
            ret[i] *= left;
            left *= nums[i];
        }
        return ret;
    }
    public static int[] productExceptSelf(int[] nums) {
        int[] ret = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int temp = 1;
            for (int k = 0 ; k < nums.length; k ++) {
                if (nums[i] == 0 && i == k) {

                } else {
                    temp *= nums[k];
                }
            }
            if (nums[i] != 0) {
                ret[i] = temp/nums[i];
            } else {
                ret[i] = temp;
            }
        }
        return ret;
    }
}
