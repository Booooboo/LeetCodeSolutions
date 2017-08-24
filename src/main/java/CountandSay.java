/**
 * Created by sunhongbo on 16/6/6.
 */
public class CountandSay {
    public static void main(String[] args) {
        System.out.println(countAndSay(6));
    }

    //n代表第n个输出的字符串
    //1, 11, 21, 1211, 111221, ...
    public static String countAndSay1(int n) {
        if (n <= 0)
            return null;

        String result = "1";
        int i = 1;

        while (i < n) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j) == result.charAt(j - 1)) {
                    count++;
                } else {
                    sb.append(count);
                    sb.append(result.charAt(j - 1));
                    count = 1;
                }
            }

            sb.append(count);
            sb.append(result.charAt(result.length() - 1));
            result = sb.toString();
            i++;
        }

        return result;
    }

    public static String countAndSay(int n) {
        int i= 1;
        String result = "1";
        while (i < n) {
            StringBuilder temp = new StringBuilder();
            int count = 1;
            for (int j = 1; j < result.length(); j++) {
                //result里连着的个数
                if (result.charAt(j) == result.charAt(j-1)) {
                    count++;
                } else {
                    temp.append(count);
                    temp.append(result.charAt(j-1)); //把第j-1个char添加
                    count = 1;
                }
            }
            //result最后一个char
            temp.append(count);
            temp.append(result.charAt(result.length() - 1));
            result = temp.toString();
            i++;
        }
        return result;
    }
    //21 1211
    //public static String countAndSay(int n) {
    //    String res = "";
    //    int div;
    //    int remainder;
    //    int temp = 1;
    //    int a = n;
    //    while (a >= 10) {
    //        temp *= 10;
    //        a /= 10;
    //    }
    //    while(n != 0) {
    //        remainder = n % 10;
    //        div = n / 10;
    //        n %= temp;
    //        temp /= 10;
    //        if (n != 0) {
    //            res += ("1"+div);
    //        } else {
    //            res += ("1"+remainder);
    //        }
    //    }
    //    return res;
    //}
}
