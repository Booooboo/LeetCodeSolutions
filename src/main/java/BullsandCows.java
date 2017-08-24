/**
 * Created by sunhongbo on 16/6/1.
 */
public class BullsandCows {
    public static void main(String[] args) {
        System.out.println(getHint("4123", "0167"));
    }

    //A的意思是位置正确且数字正确的个数,B的意思是位置不正确但是数字正确的个数
    public static String getHint(String secret, String guess) {
        int bull = 0;
        int cows = 0;
        int[] count = new int[10];
        int len = secret.length();
        for (int i = 0; i < len; i++) {
            int a = secret.charAt(i);
            int b = guess.charAt(i);
            if (a == b) {
                bull++;
            } else {
                //精髓: 一个数组10个数 每位作为标志位,secret里设置成加1, guess里设置成减1,
                // 在secret里看是否小于0相当于判断是否在guess里有
                //注意要把等于0算上,因为刚加了1或者刚减了1,所以如果为0说明加之前或者减之前是小于0或者大于0的
                count[secret.charAt(i) - '0']++;
                if (count[secret.charAt(i) - '0'] <= 0) {
                    cows++;
                }
                count[guess.charAt(i) - '0']--;
                if (count[guess.charAt(i) - '0'] >= 0) {
                    cows++;
                }
            }
        }
        String res = "";
        res += (bull + "A" + cows + "B");
        return res;

    }

    public static String getHint1(String secret, String guess) {
        int bull = 0;
        int cows = 0;
        int[] count = new int[10];
        int len = secret.length();
        for (int i = 0; i < len; i++) {
            int a = secret.charAt(i);
            int b = guess.charAt(i);
            if (a == b) {
                bull++;
            } else {
                count[secret.charAt(i) - '0']++;
                if (count[secret.charAt(i) - '0'] <= 0) {
                    cows++;
                }
                count[guess.charAt(i) - '0']--;
                if (count[guess.charAt(i) - '0'] >= 0) {
                    cows++;
                }
            }
        }
        String res = "";
        res += (bull + "A" + cows + "B");
        return res;
    }
}
