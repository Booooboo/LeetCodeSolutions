/**
 * Created by sunhongbo on 16/6/22.
 */
public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int[] exa = {2,3,1,2,8,4,3};
        System.out.println(minSubArrayLen(7, exa));
    }

    public static int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0; // 子数组最左边数字的下标
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                min = Math.min(min, i - left + 1);
                sum -= nums[left++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    // 参考
    // 注意题意是要大于等于s的 最小子数组,当数组中有一个数大于s时候,那肯定返回的是1
    public static int minSubArrayLenW(int s, int[] nums) {
        if(nums==null||nums.length==0)
            return 0;
        int left=0,sum=0,min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i]; //从头遍历整个数组,看当前子数组合大小,跟s相比
            while(sum>=s){ //大于等于s, 更新子数组的个数到min
                min=Math.min(min, i-left+1); // 更新当前子数组 个数
                sum-=nums[left++]; // 移除子数组中第一个数字
            }
        }
        return min==Integer.MAX_VALUE?0:min; // 返回子数组个数最小值
    }
}
