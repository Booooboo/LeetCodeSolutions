/**
 * Created by sunhongbo on 16/6/14.
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {

    }
    public static String longestCommonPrefix(String[] strs) {
        String res = "";

        if (strs.length == 0) {
            return res;
        }

        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() <= i || strs[j].charAt(i) != strs[0].charAt(i)) {
                    return strs[0].substring(0, i); //substring(start, end)函数 不包括end位置,个数是end - start
                }
            }
        }
        return strs[0];
    }
}
