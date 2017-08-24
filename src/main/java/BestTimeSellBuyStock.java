/**
 * Created by sunhongbo on 16/4/21.
 */
public class BestTimeSellBuyStock {
    public static void main(String[] args) {
        int[] exa = new int[]{4,5,2,7,1,9};
        System.out.println(maxProfit(exa));
    }
    public static int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int min = prices[0];
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return maxProfit;
    }
}
