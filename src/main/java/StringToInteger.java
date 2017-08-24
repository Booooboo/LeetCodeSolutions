/**
 * Created by sunhongbo on 16/8/4.
 */
public class StringToInteger {
    public static void main(String[] args) {
        String exa = "2147483648";
        System.out.println(myAtoi(exa));
    }

    public static int myAtoi(String str) {
        if (str.length() == 0 || str == null) {
            return 0;
        }
        char[] chars = str.toCharArray();
        int i = 0;
        double num = 0;
        //float num2 = 0;
        double result = 0;
        char flag = '+';
        while (chars[i] == ' ') {
            i++;
        }
        if (chars[i] == '-' || chars[i] == '+') {
            flag = chars[i];
            i++;
        }
        while (i < chars.length && chars[i] >= '0' && chars[i] <= '9') {
            if (num != 0) {
                num *= 10;
            }
            num += chars[i] - '0';
            i++;
        }

        result = num;
        if (flag == '-') {
            result = 0 - result;
        }

        // 如果结果比最大值还大,返回最大值即可
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (result < Integer.MIN_VALUE) { // 结果比最小值还小,返回最小值即可
            return Integer.MIN_VALUE;
        }
        return (int)result;
    }
}
