/**
 * Created by sunhongbo on 16/5/16.
 */
public class KthLargestNumberInArray {
    public static void main(String[] args) {
        int[] exa = {3,2,1,5,6,4};
        System.out.println(findKthLargest(exa, 2));
    }
    public static int findKthLargest(int[] nums, int k) {
        sort(nums);
        return nums[nums.length - k];
    }
    public static void sort(int[] nums) {
        for (int i = 0; i  < nums.length; i++) {
            for (int j = 0; j < nums.length-i-1; j++) {
                if (nums[j] > nums[j+1]) {
                    int temp;
                    temp = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }
}
