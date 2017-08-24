/**
 * Created by sunhongbo on 16/5/13.
 */
public class IncreasingTripletSubsequence {
    public static void main(String[] args) {
        int[] exa = {2,1,5,0,3};
        int[] exaBack = {5, 4, 3, 2, 1};
        int[] exanotEnough = {1,2};
        int[] exa4 = {2,4,-2,-3};

        int[] exa5 = {5, 1, 6};
        System.out.println(increasingTriplet(exa));
        //System.out.println(increasingTriplet(exaBack));
    }
    //public static boolean increasingTriplet(int[] nums) {
    //    for (int i = 0; i < nums.length-2; i++) {
    //        if (nums[i] < nums[i+1]) {
    //            if (nums[i+1] < nums[i+2]) {
    //                return true;
    //            }
    //        }
    //    }
    //    return false;
    //}

    public static boolean increasingTriplet(int[] nums) {
        if (nums.length < 2) return false;
        int c1 = 0x7fffffff;
        int c2 = 0x7fffffff;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= c1) {
                c1 = nums[i];
            } else if (nums[i] <= c2) {
                c2 = nums[i];
            } else {
                return true;
            }
        }
        return false;
    }
}
