/**
 * Created by sunhongbo on 16/6/14.
 */
public class UglyNumberII {
    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
    }

    //当前要生成的丑数肯定是前面某一个丑数乘以2,3或5。但并不需要把当前每个丑数都乘以2,
    // 3和5，因为已生成的丑数在数组是按顺序存放的。对于乘以2而言，肯定存在某一个丑数t2，
    // 使得排在它之前的每一个丑数乘以2得到的结果都会小于已有最大丑数，在它之后的每个丑数乘以2
    // 得到的结果都会大于当前最大丑数。我们只需要记下这个丑数的位置，同时每次生成新的丑数时去更新这个t2。对于3和5，同样存在t3和t5。
    public static int nthUglyNumber1(int n) {
        int[] ids = new int[3];
        int[] uglys = new int[n];
        uglys[0] = 1;
        for (int i = 1; i < n; i++) {
            int a = uglys[ids[0]] * 2; // ids记录 uglys的下标
            int b = uglys[ids[1]] * 3;
            int c = uglys[ids[2]] * 5;
            int min = Math.min(a, Math.min(b, c)); // 去三个数中的最小值, 作为下一个uglyNumber
            // 最小的uglyNumber 对应的因子加1
            if (a == min)
                ids[0]++;
            if (b == min)
                ids[1]++;
            if (c == min)
                ids[2]++;
            uglys[i] = min;
        }
        return uglys[n - 1];
    }

    public static int nthUglyNumber(int n) {
        int[] ids = new int[3];
        int[] uglys = new int[n];
        uglys[0] = 1;
        for (int i = 1; i < n; i++) {
            int a = uglys[ids[0]] * 2;
            int b = uglys[ids[1]] * 3;
            int c = uglys[ids[2]] * 5;
            int min = Math.min(a, Math.min(b, c));
            if (min == a) ids[0]++;
            if (min == b) ids[1]++;
            if (min == c) ids[2]++;
            uglys[i] = min;
        }
        return uglys[n-1];
    }

    public static int nthUglyNumberTimeOut(int n) {
        int count = 0;
        int num = 0;
        while (count < n) {
            num++;
            if (isUgly(num)) {
                count++;
            }
        }
        return num;
    }

    public static boolean isUgly(int cur) {
        if (cur <= 0)
            return false;
        while (cur % 2 == 0)
            cur /= 2;
        while (cur % 3 == 0)
            cur /= 3;
        while (cur % 5 == 0)
            cur /= 5;
        if (cur == 1) {
            return true;
        } else {
            return false;
        }
    }
}
