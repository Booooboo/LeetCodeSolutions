/**
 * Created by sunhongbo on 16/7/27.
 */
public class ValidNumber {
    public static void main(String[] args) {

    }
    public static boolean isNumber(String s) {
        while (s.startsWith(" "))
            s = s.substring(1);
        while (s.endsWith(" "))
            s = s.substring(0, s.length() - 1);
        if (s.length() < 1)
            return false;
        // 以e为分割线,e的前面可以有小数点,e的后面不可以有小数点
        if (!s.contains("e")) {
            return check(s, true);
        } else {
            return check(s.substring(0, s.indexOf('e')), true) && check(s.substring(s.indexOf('e')+1), false);
        }
    }
    public static boolean check(String s, boolean point) {
        if (s.length() < 1)
            return false;
        char[] chars = s.toCharArray();
        int i = 0;
        boolean num = false;
        // 有符号数,带一个加号或者一个减号
        if (chars[i] == '+' || chars[i] == '-') {
            i++;
        }
        // 如果符号后面没有数字,返回false
        if (i == chars.length)
            return false;
        // 数字是0-9之间的一个数
        while (i < chars.length && chars[i] <= '9' && chars[i] >= '0') {
            i++;
            num = true;
        }

        // 没有到最后一个数字并且不带小数点,返回false
        if (i < chars.length && !point)
            return false;
        // 看小数点后面的数
        if (i < chars.length && chars[i] == '.') {
            boolean num2 = false;
            i++;
            while (i < chars.length && chars[i] <= '9' && chars[i] >= '0') {
                i++;
                num2 = true;
            }
            // 小数点前面或者后面 至少有一个有数字
            if (!num && !num2)
                return false;
        }

        // 是否遍历到数的最后一个
        return i == chars.length;
    }
}
