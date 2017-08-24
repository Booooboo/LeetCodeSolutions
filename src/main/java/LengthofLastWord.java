/**
 * Created by sunhongbo on 16/6/6.
 */
public class LengthofLastWord {
    public static void main(String[] args) {
        String s = "Hello World";
        String a = "a  ";
        System.out.println(lengthOfLastWord(a));
    }

    public static int lengthOfLastWord(String s) {
        if (s.isEmpty() || s == null)
            return 0;
        char[] temp = s.toCharArray();
        int res = 0;
        int len = temp.length - 1;
        while (len >= 0 && temp[len] == ' ')
            len--;
        for (int i = len; i >= 0; i--) {
            while (i >= 0 && temp[i] != ' ') {
                res++;
                i--;
            }
            break;
        }
        return res;
    }

    //MaximumGap on the Internet
    public static int lengthOfLastWord1(String s) {
        //去掉"   "情况
        if (s.trim().equals("") || s.length() == 0) {
            return 0;
        }

        //trim()首尾空格被去掉，中间的还保留
        String[] ss = s.trim().split(" ");
        int len = ss.length;
        return ss[len - 1].length();
    }
}
