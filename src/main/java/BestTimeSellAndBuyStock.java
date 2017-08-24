/**
 * Created by sunhongbo on 16/4/15.
 */
public class BestTimeSellAndBuyStock {
    public static void main(String[] args) {
        int[] exa = new int[]{1,2,3,0,2};
        System.out.println(maxProfit(exa));
    }
    //对于当天最终未持股的状态，最终最大利润有两种可能，一是今天没动作跟昨天未持股状态一样，二是昨天持股了，今天卖了。所以我们只要取这两者之间最大值即可，表达式如下：

    //sellDp[i] = Math.max(sellDp[i - 1], buyDp[i - 1] + prices[i]);
    //对于当天最终持股的状态，最终最大利润有两种可能，一是今天没动作跟昨天持股状态一样，二是前天还没持股，今天买了股票，这里是因为cooldown的原因，所以今天买股要追溯到前天的状态。我们只要取这两者之间最大值即可，表达式如下：
    //
    //buyDp[i] = Math.max(buyDp[i - 1], sellDp[i - 2] - prices[i]);
    //最终我们要求的结果是
    //
    //sellDp[n - 1] 表示最后一天结束时手里没股票时的累积最大利润


    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        // 表示当天最终未持股的情况下，当天结束后的累计最大利润
        int[] sellDp = new int[prices.length];
        // 表示当天最终持股的情况下，当天结束后的累计最大利润
        int[] buyDp = new int[prices.length];

        // 考虑初始情况
        buyDp[0] = -prices[0];
        sellDp[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            sellDp[i] = Math.max(sellDp[i - 1], buyDp[i - 1] + prices[i]);
            if (i >= 2) {
                buyDp[i] = Math.max(buyDp[i - 1], sellDp[i - 2] - prices[i]);
            } else {
                buyDp[i] = Math.max(buyDp[i - 1], -prices[i]);
            }
        }
        return sellDp[prices.length - 1];
    }
}
