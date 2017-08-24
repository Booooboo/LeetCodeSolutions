import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by sunhongbo on 16/5/31.
 */
public class ContainsDuplicateII {
    public static void main(String[] args) {
        int[] exa = {1,2,1};
        System.out.println(containsNearbyDuplicate(exa, 0));
    }
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        //int len = nums.length;
        //for (int i = 0; i < len; i++) {
        //    for (int j = i+1; j < len; j++) {
        //        if (nums[i] == nums[j]) {
        //            if (j - i <= k) return true;
        //        }
        //    }
        //}
        //return false;

        //HashMap中键唯一
        HashMap<Integer, Integer> temp = new HashMap<Integer, Integer>();
        for (int i = 0 ; i < nums.length; i++) {
            if (temp.containsKey(nums[i])) {
                int pre = temp.get(nums[i]);
                if (k >= Math.abs(i - pre))
                    return true;
            }
            temp.put(nums[i], i);
        }
        return false;
    }
}
