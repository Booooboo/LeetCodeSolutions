/**
 * Created by sunhongbo on 16/5/16.
 */
public class FindPeakElement {
    public static void main(String[] args) {
        int[] exa = {3,2,1};
        System.out.println(findPeakElement(exa));
    }
    //[1, 2, 3, 1]
    public static int findPeakElement(int[] nums) {
        if (nums.length <= 1) return 0;
        int res = 0;
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                max = nums[i-1];
                res = i;
                if (i < nums.length-1) {
                    if (nums[i] > nums[i+1])
                        return i;
                }
            } else {
                if (nums[i-1] > max) {
                    res = i-1;
                    max = nums[i-1];
                }
            }
        }
        return res;
    }
}
