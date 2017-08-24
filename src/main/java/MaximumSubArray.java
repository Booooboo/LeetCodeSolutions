/**
 * Created by sunhongbo on 16/4/18.
 */
public class MaximumSubArray {
    public static void main(String[] args) {
        int[] exa = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int[] exa1 = {-1};
        System.out.println(maxSubArray(exa1));
    }
    public static int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        int f = 0;
        int result = nums[0];
        for (int i = 0; i < nums.length; i++) {
            f = Math.max(f + nums[i], nums[i]);
            result = Math.max(result, f);
        }
        return result;
    }
}
