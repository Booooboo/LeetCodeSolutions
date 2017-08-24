/**
 * Created by sunhongbo on 17/7/24.
 */
public class charcaters {
    public static void main(String[] args) {

        String s = "0P";
        isPalindrome(s);
        isPalindromeBetter(s);
        String hay = "mississippi";
        String index = "issip";
        String ss = "  -0012a42";
        String st = "-9223372036854775809";
        String sss = "";
        System.out.println(myAtoi(st));
        System.out.println(strStr(hay, index));

        String a = "101111";
        String b = "10";
        System.out.println(addBinary(a, b));
    }


    public static boolean isPalindromeBetter(String s) {
        if (s == null)
            return false;
        if (s.length() < 2)
            return true;

        s = s.replaceAll("[^a-zA-Z0-9]", ""); // 除了a-z A-Z 0-9之外的字符都去掉(用""代替)
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (Character.toUpperCase(s.charAt(i)) != Character.toUpperCase(s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;

    }

    public static boolean isPalindrome(String s) {
        if (s == null)
            return false;
        if (s.length() < 2)
            return true;
        char[] chars = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            while (i < s.length() && !isNum(chars[i]) && !isAlpha(chars[i])) {
                i++;
            }
            while (j > 0 && !isNum(chars[j]) && !isAlpha(chars[j])) {
                j--;
            }
            if (i >= j)
                break;
            if ((chars[i] >= '0' && chars[i] <= '9') && (chars[j] >= '0' && chars[j] <= '9')) {
                if (chars[i] != chars[j]) {
                    return false;
                }
            } else if (isAlpha(chars[i]) && isAlpha(chars[j])) {
                if (Character.toUpperCase(chars[i]) != Character.toUpperCase(chars[j])) {
                    return false;
                }
            } else {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static boolean isAlpha(char c) {
        if ((c >= 'a' && c <= 'z') || c >= 'A' && c <= 'Z') {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isNum(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        } else {
            return false;
        }
    }

    public static int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0)
            return 0;
        char[] hay = haystack.toCharArray();
        char[] need = needle.toCharArray();
        int i = 0, j = 0;
        while (j < hay.length) {
            if (hay[j] == need[i]) {
                if (i == need.length - 1)
                    return j - need.length + 1;
                i++;
                j++;
                continue;
            } else {
                j = j - i + 1; //注意要搓一位比较
                i = 0;
            }

        }
        return -1;
    }


    public static int myAtoi(String str) {
        if (str == null)
            return 0;
        char[] res = str.toCharArray();
        if (res.length == 0)
            return 0;
        int i = 0;
        boolean num = false;
        double result = 0;
        while (res[i] == ' ') {
            i++;
        }
        if (res[i] == '+') {
            i++;
        } else if (res[i] == '-') {
            i++;
            num = true;
        }
        if (i < res.length) {
            while (i < res.length && (res[i] >= '0' && res[i] <= '9')) {
                if (result > 0) {
                    result *= 10;
                }
                result += res[i] - '0';
                i++;
            }
        }
        if (num) {
            result = 0 - result;
        }

        if (result <= Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else if (result >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else {
            return (int) result;
        }

    }

    public static String addBinary(String a, String b) {
        char[] aDestination = a.toCharArray();char[] bDestination = b.toCharArray();
        int i = aDestination.length - 1;int j = bDestination.length - 1;
        int carry = 0;
        StringBuffer result = new StringBuffer();
        while (i >= 0 && j >= 0) {
            if ((aDestination[i] - '0' + bDestination[j] - '0' + carry) > 1) {
                result.append(aDestination[i] - '0' + bDestination[j] - '0' + carry - 2);
                carry = 1;
            } else {
                result.append((char) (aDestination[i] - '0' + bDestination[j] - '0' + carry + (int) '0'));
                carry = 0;
            }
            i--;
            j--;}
        while (j >= 0) {
            if ((bDestination[j] - '0' + carry) > 1) {
                carry = 1;
                result.append(bDestination[j] - '0' + carry - 2);
            } else {
                result.append((char) (bDestination[j] + carry));
                carry = 0;
            }
            j--;}
        while (i >= 0) {
            if ((aDestination[i] - '0' + carry) > 1) {
                carry = 1;
                result.append(aDestination[i] - '0' + carry - 2);
            } else {
                result.append((char) (aDestination[i] + carry));
                carry = 0;
            }
            i--;}
        if (carry != 0) {
            result.append((char) (carry + (int) '0'));}
        return result.reverse().toString();

    }

}
