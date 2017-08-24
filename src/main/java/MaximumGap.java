/**
 * Created by sunhongbo on 16/6/24.
 */
public class MaximumGap {

    public static void main(String[] args) {
        int[] exa = {21, 8, 3, 22, 10};
        System.out.println(maximumGap(exa));
    }

    //证明 gap一定不在一个桶中
    //假设有N个元素A到B。

    //那么最大差值不会小于ceiling[(B - A) / (N - 1)]
    //
    //令bucket（桶）的大小len = ceiling[(B - A) / (N - 1)]，则最多会有(B - A) / len + 1个桶
    //
    //对于数组中的任意整数K，很容易通过算式loc = (K - A) / len找出其桶的位置，然后维护每一个桶的最大值和最小值
    //
    //由于同一个桶内的元素之间的差值至多为len - 1，因此最终答案不会从同一个桶中选择。
    //
    //对于每一个非空的桶p，找出下一个非空的桶q，则q.min - p.max可能就是备选答案。返回所有这些可能值中的最大值。


    public static int maximumGap(int[] num) {
        if (num == null || num.length < 2)
            return 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < num.length; i++) {
            min = Math.min(min, num[i]);
            max = Math.max(max, num[i]);
        }

        double Interval = (double) num.length / (max - min); // 注意 interval是double类型的

        int[][] solutions = new int[num.length + 1][2];
        // solotions[i] 代表有多少个桶
        // solution[][2] 代表每个桶中的最大数和最小数
        for (int i = 0; i < solutions.length; i++) {
            solutions[i][0] = -1;
            solutions[i][1] = -1;
        }

        for (int i = 0; i < num.length; i++) {
            int index = (int) (Interval * (num[i] - min)); // 每个数分桶
            if (solutions[index][0] == -1) { // 桶中数排大小
                solutions[index][0] = num[i];
                solutions[index][1] = num[i];
            } else {
                solutions[index][0] = Math.min(num[i], solutions[index][0]);
                solutions[index][1] = Math.max(num[i], solutions[index][1]);
            }
        }

        int res = 0;
        int pre = solutions[0][1];
        // 相邻桶 计算间隔(相邻桶间隔肯定比一个桶中的数的间隔大)
        for (int i = 1; i < solutions.length; i++) {
            if (solutions[i][0] != -1) {
                res = Math.max(res, solutions[i][0] - pre);
                pre = solutions[i][1];
            }
        }
        return res;

    }

}
