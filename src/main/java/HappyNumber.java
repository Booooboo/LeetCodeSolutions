import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by sunhongbo on 16/4/19.
 */
public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(isHappy(2));
    }
    public static boolean isHappy(int n) {
        int temp = 0;
        HashSet<Integer> hash = new HashSet<Integer>();
        while(n != 0) {
            temp += (n%10)*(n%10);
            if (1<=n && n <= 9) {
                if (temp == 1) return true;
                if (hash.contains(temp)) return false;
                hash.add(temp);
                n = temp;
                temp = 0;
            } else {
                n = n/10;
            }
        }
        return false;
    }
}
