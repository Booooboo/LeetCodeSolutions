/**
 * Created by sunhongbo on 16/5/3.
 */
public class FindMinumNumber2 {
    public static void main(String[] args) {
        int[] exa = new int[]{8,9,1,2,2,2,2,2,2};
        System.out.println(findMin(exa));
    }
    public static int findMin(int[] nums) {
        int right = nums.length - 1;
        int left = 0;
        int mid;
        while (left < right && nums[left] >= nums[right]) {
            mid =left + (right - left) / 2;
            if (nums[right] < nums[mid]) {
                left = mid + 1;
            } else if(nums[mid] == nums[left]){
                left ++;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

}
