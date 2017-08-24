import java.util.HashSet;
import java.util.Set;

/**
 * Created by sunhongbo on 16/7/6.
 */
public class WordBreak {
    public static void main(String[] args) {
        String s = "leetcode";
        Set<String> dict = new HashSet<String>();
        dict.add("leet");
        dict.add("code");
        System.out.println(wordBreak(s, dict));
    }
    // 暴力遍历方法 exceeds the time limited
    //动态规划
    public static boolean wordBreak(String s, Set<String> wordDict) {
        // 用一个一位数组代表t[], t[i] = true 代表s到第i个字符是可以被wordDict组合的
        boolean[] t = new boolean[s.length() + 1];
        t[0] = true;
        for (int i = 0; i < s.length(); i++) { // 从s的第一个开始比较 在dict中存在则设置成true
            if (!t[i]) { // s中第i个节点 如果为false 直接跳过,说明dict中没有到达当前点的字符串
                continue;
            }
            for (String a : wordDict) { // 遍历wordDict中的字符串 对比s中从第i个开始的字符是否跟wordDict中的字符串相等
                int len = a.length();
                int end = i + len;
                if (end > s.length()) continue;
                if (t[end]) continue;
                if (s.substring(i, end).equals(a)) {
                    t[end] = true; // 相等 当前为字符出为true
                }
            }
        }
        return t[s.length()]; // 判断是否到达字符串结尾
    }
}
