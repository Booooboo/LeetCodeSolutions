/**
 * Created by sunhongbo on 16/5/9.
 */
public class HourseRobber1 {
    public static void main(String[] args) {
        int[] exa = {5,1,2,6,1,7,2};
        int[] exa1 = {2,1,1,1};
        System.out.println(rob(exa1));
    }
    //5,1,2,6,1,7,2
    //public static int rob(int[] nums) {
    //    int[] res = new int[nums.length];
    //    res[0] = nums[0];
    //    for (int i = 1; i < nums.length; i++) {
    //        res[i] = Math.max(res[i-1] - nums[i-1] + nums[i], res[i-1]);
    //    }
    //    return res[nums.length-1];
    //}

    public static int rob1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int res[] = new int[nums.length + 1];
        res[0] = 0;
        res[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            res[i] = Math.max(res[i-1], res[i-2] + nums[i-1]);
        }
        return res[nums.length];
    }

    //House Robber II
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        return Math.max(robTool(nums, 0, nums.length-2),robTool(nums, 1, nums.length-1));
    }

    public static int robTool(int[] nums, int start, int end) {
        int[] res = new int[end - start + 1];
        res[0] = nums[start];
        res[1] = Math.max(nums[start], nums[start+1]);
        for (int i = 2; i < end-start+1; i++) {
            res[i] = Math.max(res[i-1], res[i-2] + nums[start+i]);
        }
        return res[end-start];
    }
}
