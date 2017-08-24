/**
 * Created by sunhongbo on 16/4/13.
 */
public class SearchInsertPosition {
    public static void main(String[] args) {
        int exa[] = new int[]{1};
        System.out.println(searchInsert(exa, 0));
    }
    public static int searchInsert(int[] nums, int target) {
        if (nums[0] >= target) return 0;
        for (int i = 1; i < nums.length; i++) {
            if (target == nums[i]) return i;
            if (nums[i-1]< target && target < nums[i]) return i;
        }
        return nums.length;
    }
}
