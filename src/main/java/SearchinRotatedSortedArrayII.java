/**
 * Created by sunhongbo on 16/5/19.
 */
public class SearchinRotatedSortedArrayII {
    public static void main(String[] args) {
        int[] exa = {6, 6, 9, 2, 3, 3, 5};
        int[] exa1= {1, 3};
        System.out.println(search(exa1, 3));

    }
    //6 6 9 2 3 3 5
    //0 1 2 3 4 5 6
    //nums[mid] > nums[left] 不能确定递增  那就把left++看看
    //1 3 1 1 1
    public static boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right-left)/2;
            if (target == nums[mid]) {
                return true;
            }
            if (nums[left] < nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid;
                } else {
                    left = mid+1;
                }
            } else if (nums[left] > nums[mid]) {
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid+1;
                } else {
                    right = mid;
                }
            } else {
                left++;
            }
        }
        return false;
    }
}
