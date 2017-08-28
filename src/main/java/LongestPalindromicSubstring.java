/**
 * Created by sunhongbo on 17/8/25.
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String s = "aaaabaaa";
        System.out.println(longestPalindrome(s));
    }

    //暴利破解法
    //逐个元素左右遍历
    public static String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int maxLen = 1;
        int tmp = 1;
        String result = String.valueOf(chars[0]);
        int left = 0, right = 0, cur = 0;
        for (int i = 0; i < chars.length; i++) {
            tmp = 1;
            cur = i;
            while (i < chars.length-1 && chars[i] == chars[i+1]) {
                tmp++;
                i++;
            }
            left = cur - 1;
            right = i + 1;
            while (left >= 0 && right < chars.length && chars[left] == chars[right]) {
                tmp += 2; // 计算对称元素的个数,不是 对 数
                left--;
                right++;
            }

            if (tmp > maxLen) {
                result = s.substring(left + 1, right); // 函数获取[)左闭右开区间
                maxLen = tmp;
            }

        }
        return result;

    }

    public static String longestPalindRome(String s) {
        if(s == null || s.length()==0)
            return "";
        boolean[][] palin = new boolean[s.length()][s.length()];
        String res = "";
        int maxLen = 0;
        for(int i=s.length()-1;i>=0;i--)
        {
            for(int j=i;j<s.length();j++)
            {
                if(s.charAt(i)==s.charAt(j) && (j-i<=2 || palin[i+1][j-1]))
                {
                    palin[i][j] = true;
                    if(maxLen<j-i+1)
                    {
                        maxLen=j-i+1;
                        res = s.substring(i,j+1);
                    }
                }
            }
        }
        return res;
    }
}
