import java.util.HashMap;

/**
 * Created by sunhongbo on 16/4/8.
 */
public class RomanToInt {
    public static void main(String[] args) {
        System.out.println(romanToInt("XCIII"));
        System.out.println(IntToRoman(19));
    }
    private static int romanToInt(String s) {
        int ret = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        ret += map.get(s.charAt(s.length() - 1));
        for (int i = s.length() - 2; i >= 0; i--) {
            if (map.get(s.charAt(i+1)) <= map.get(s.charAt(i))) {
                ret += map.get(s.charAt(i));
            } else {
                ret -= map.get(s.charAt(i));
            }
        }
        return ret;
    }

    public static String IntToRoman(int num) {
        String[] str = new String[]{"M","CM","D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] value = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder res = new StringBuilder();
        for (int i = 0; num > 0; i++ ) {
            while (num >= value[i]) {
                num -= value[i];
                res.append(str[i]);
            }
        }
        return res.toString();
    }
}
