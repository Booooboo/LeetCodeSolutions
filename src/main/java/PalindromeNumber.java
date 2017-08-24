/**
 * Created by sunhongbo on 16/5/20.
 */
public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(12321));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int div = 1;
        //算出除以多少能剩下首位 除数为div
        while (x / div >= 10) {
            div *= 10;
        }

        //将x首位和末尾(取余) 相比较
        while (x != 0) {
            int left = x/div;
            int right = x%10;
            if (left != right) return false;

            //将首位和末尾去掉, 除数div也去掉两个
            x = (x % div) / 10; // 12321 % div10000 = 2321 % 10 = 232
            div /= 100;
        }
        return true;
    }






    public static boolean isPalindrome1(int x) {
        if (x < 0)
            return false;

        // initialize how many zeros
        int div = 1;
        while (x / div >= 10) {
            div *= 10;
        }

        while (x != 0) {
            int left = x / div;
            int right = x % 10;

            if (left != right)
                return false;

            x = (x % div) / 10;
            div /= 100;
        }

        return true;
    }
}
