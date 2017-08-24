import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * Created by sunhongbo on 16/3/28.
 */
public class SingleNumber {
    public static void main(String[] args) {
        int[] simple = {2,3,4,4,7,2,3};
        int ret =singleNumberE(simple);
        System.out.print(ret);
        int[] exa = {2,1,4,4,4,1,1};
        int res = singleNumber2(exa);
        System.out.println(res);
    }

    public static int singleNumberE(int[] nums) {
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            ret = ret^nums[i];
        }
        return ret;
    }

    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], 2);
            } else {
                map.put(nums[i], 1);
            }
        }
        for (int k = 0; k < nums.length; k++) {
            if (map.get(nums[k]) == 1) {
                return nums[k];
            }
        }
        return 0;
    }

    public static int singleNumber2(int[] nums) {
        int re = 0;
        return re;
    }
}
