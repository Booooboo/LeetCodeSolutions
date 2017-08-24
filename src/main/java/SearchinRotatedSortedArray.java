/**
 * Created by sunhongbo on 16/5/30.
 */
public class SearchinRotatedSortedArray {
    public static void main(String[] args) {
        int[] exa = {1};
        System.out.println(search(exa, 2));
    }

    //12345678 45678123
    //12345678 78123456
    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[start] <= nums[mid]) {
                if (nums[start] <= target && target < nums[mid]) {
                    end = mid+1;
                } else {
                    start = mid+1;
                }
            } else if (nums[start] > nums[mid]){
                if (nums[mid] < target && target <= nums[end]) {
                    start = mid+1;
                } else {
                    end = mid;
                }
            }
        }
        return -1;
    }
}
