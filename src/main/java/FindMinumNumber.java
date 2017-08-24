/**
 * Created by sunhongbo on 16/4/20.
 */
public class FindMinumNumber {
    public static void main(String[] args) {
        int[] exa = new int[]{7,8,9,1,2,3,4,5};
        System.out.println(findMin(exa));
    }
    public static int findMin(int[] nums) {
        int mid;
        int left = 0;
        int right = nums.length - 1;
        while (nums[left] > nums[right]) {
            mid = (left+right)/2;
            if (nums[right] < nums[mid])
                left = mid + 1;
            else {
                right = mid;
            }
        }
        return nums[left];
    }
}
