import java.util.ArrayList;

/**
 * Created by sunhongbo on 16/7/6.
 */
public class PermutationSequence {
    public static void main(String[] args) {
        String s = getPermutation(3, 4);
        System.out.println(s);
    }

    public static String getPermutation(int n, int k) {
        String res = "";
        ArrayList<Integer> nub = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            nub.add(i);
        }
        k--;
        int mod = 1;
        for (int i = 1; i <= n; i++) {
            mod *= i;
        }

        for (int i = 0; i < n; i++) {
            mod = mod/(n-i);
            int currentIndex = k / mod;
            k = k % mod;
            res += nub.get(currentIndex);
            nub.remove(currentIndex);
        }
        return res.toString();
    }

    public static String getPermutationInternetCorrect(int n, int k) {
        // initialize all numbers
        ArrayList<Integer> numberList = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            numberList.add(i);
        }

        // change k to be index
        k--;

        // set factorial of n
        int mod = 1;
        for (int i = 1; i <= n; i++) {
            mod = mod * i;
        }

        String result = "";

        // find sequence
        for (int i = 0; i < n; i++) {
            mod = mod / (n - i); // 阶乘
            // find the right number(curIndex) of
            int curIndex = k / mod;
            // update k
            k = k % mod;

            // get number according to curIndex
            result += numberList.get(curIndex);
            // remove from list
            numberList.remove(curIndex);
        }

        return result.toString();
    }


    //time out
    public static String getPermutationInternet(int n, int k) {
        boolean[] output = new boolean[n];
        StringBuilder buf = new StringBuilder("");

        int[] res = new int[n];
        res[0] = 1;

        for (int i = 1; i < n; i++)
            res[i] = res[i - 1] * i; // 计算阶乘

        for (int i = n - 1; i >= 0; i--) { // 1打头的有n-1个组合, 2打头的有n-2个组合...所以算n-1次
            int s = 1; // 当前要添加的字符

            while (k > res[i]) { // k大于(比如1打头)n-1  // 找到打头的字符 s是它的index
                s++; // 2打头
                k = k - res[i];
            }

            for (int j = 0; j < n; j++) {
                if (j + 1 <= s && output[j]) { // 当前字符如果已经被添加到返回字符串 则找下一个
                    s++; // 找接下来的字符
                }
            }

            output[s - 1] = true; // 把已经添加的字符 设置标志位
            buf.append(Integer.toString(s)); // 添加当前遍历到的字符
        }

        return buf.toString();
    }
}
