/**
 * Created by sunhongbo on 16/5/17.
 */
public class RemoveDuplicatesfromSortedArrayII {
    public static void main(String[] args) {
        int[] exa = {1,1,1,2,2,3};
        System.out.println(removeDuplicates(exa));
    }
    //111223
    //public static int removeDuplicates(int[] nums) {
    //    if (nums.length == 0) return 0;
    //    boolean flag = false;
    //    int i = 1;
    //    for (int j = 0; j < nums.length; j++) {
    //        if (nums[j] == nums[j+1] && !flag) {
    //            flag = true;
    //            i++;
    //        } else {
    //            flag = true;
    //        }
    //    }
    //}
    //11122
    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 2)
            return nums.length;
        int prev = 1;
        int curr = 2;
        while (curr < nums.length) {
            if (nums[prev] == nums[curr] && nums[curr] == nums[prev - 1]) {
                curr++;
            } else {
                prev++;
                nums[prev] = nums[curr];
                curr++;
            }

        }
        return prev + 1;
    }

    public static int remoceDuplicates1(int[] nums) {

        if (nums.length <= 2)
            return nums.length;

        int prev = 1; // point to previous
        int curr = 2; // point to current

        while (curr < nums.length) {
            if (nums[curr] == nums[prev] && nums[curr] == nums[prev - 1]) {
                curr++;
            } else {
                prev++;
                nums[prev] = nums[curr];
                curr++;
            }
        }

        return prev + 1;
    }
}
