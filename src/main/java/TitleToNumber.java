import java.util.HashSet;
import java.util.Set;

/**
 * Created by sunhongbo on 16/4/5.
 */
public class TitleToNumber {
    public static void main(String[] args) {
        String s = "AB";
        int exa = titleToNumber(s);
        System.out.println(exa);
        int[] array = new int[]{1,3,4,5,7,4};
        boolean dul = findDulplicate(array);
        System.out.println(dul);
    }
    public static int titleToNumber(String s) {
        char[] param = s.toCharArray();
        int ret = 0;
        for (int i = 0; i < param.length; i++) {
            ret *= 26;
            ret += param[i] - 64;
        }
        return ret;
    }
    //time limit Exceeded
    public static boolean findDul(int[] num) {
        for (int i = 0; i < num.length; i++) {
            for (int j = i+1; j < num.length; j++) {
                if (num[i] == num[j]) {
                    return true;
                }
            }
        }
        return false;
    }
    //
    public static boolean findDulplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i : nums) {
            if (!set.add(i)) {
                return true;
            }
        }
        return false;
    }
    //public static int majorityElement(int[] nums) {
    //
    //}
}
