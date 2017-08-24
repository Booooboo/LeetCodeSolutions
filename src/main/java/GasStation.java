/**
 * Created by sunhongbo on 16/6/22.
 */
public class GasStation {
    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};

        System.out.println(canCompleteCircuit(gas, cost));
        System.out.println(canCompleteCircuit1(gas, cost));

    }
    //解题思路
    //　　假设从站点 i 出发，到达站点 k 之前，依然能保证油箱里油没见底儿，从k 出发后，见底儿了。那么就说明 diff[i] + diff[i+1] + … + diff[k] <
    // 0，而除掉diff[k]以外，从diff[i]开始的累加都是 >= 0的。也就是说diff[i] 也是 >= 0的，这个时候我们还有必要从站点 i + 1尝试吗？仔细一想就知道：车要是从站点
    // i+1出发，到达站点k后，甚至还没到站点k，油箱就见底儿了，因为少加了站点 i 的油。。。
    //        　　因此，当我们发现到达k 站点邮箱见底儿后，i 到 k 这些站点都不用作为出发点来试验了，肯定不满足条件，只需要从k+1站点尝试即可！因此解法时间复杂度从O(n2)降到了 O(2n)。之所以是O(2n)
    // ，是因为将k+1站作为始发站，车得绕圈开回k，来验证k+1是否满足。
    //        　　等等，真的需要这样吗？
    //        　　我们模拟一下过程：
    //        　　a. 最开始，站点0是始发站，假设车开出站点p后，油箱空了，假设sum1 = diff[0] +diff[1] + … + diff[p]，可知sum1 < 0；
    //        　　b. 根据上面的论述，我们将p+1作为始发站，开出q站后，油箱又空了， 设sum2 = diff[p+1] +diff[p+2] + … + diff[q]，可知sum2 < 0。
    //        　　func. 将q+1作为始发站，假设一直开到了未循环的最末站，油箱没见底儿，设sum3 = diff[q+1] +diff[q+2] + … + diff[size-1]，可知sum3 >= 0。
    //        　　要想知道车能否开回 q 站，其实就是在sum3 的基础上，依次加上 diff[0] 到 diff[q]，看看sum3在这个过程中是否会小于0。但是我们之前已经知道 diff[0] 到 diff[p-1]
    // 这段路，油箱能一直保持非负，因此我们只要算算sum3 + sum1是否 <0，就知道能不能开到 p+1站了。
    //        　　如果能从p+1站开出，只要算算sum3 + sum1 + sum2 是否 < 0，就知都能不能开回q站了。
    //        　　因为 sum1, sum2 都 < 0，因此如果 sum3 + sum1 + sum2 >=0 那么sum3 + sum1 必然 >= 0，也就是说，只要sum3 + sum1 + sum2
    // >=0，车必然能开回q站。而sum3 + sum1 + sum2 其实就是 diff数组的总和 Total，遍历完所有元素已经算出来了。
    //        　　因此 Total 能否 >= 0，就是是否存在这样的站点的 充分必要条件。
    //        　　这样时间复杂度进一步从O(2n)降到了 O(n)。

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        //排除不符合条件情况
        if (gas == null || gas.length == 0 || gas.length != cost.length) {
            return -1;
        }
        int start = 0; // 符合条件的点
        int sum = 0; // 算start开始汽油剩余量
        int total = 0; // 总的diff
        for (int i = 0; i < gas.length; i++) {
            total += (gas[i] - cost[i]); // 累加箱里汽油
            if (sum < 0) { // 剩余汽油小于0
                sum = gas[i] - cost[i]; // 重新设置箱中的汽油
                start = i; // 重新设置新的起点
            } else {
                sum += gas[i] - cost[i]; // 累加汽油
            }
        }
        return (total >= 0) ? start : -1;
    }

    // 能跑完一圈的必要条件是总的汽油量要大于等于消费的汽油量
    // 当前差值得汽油量足够后面的用即可
    public static int canCompleteCircuit1(int[] gas, int[] cost) {
        if (gas.length != cost.length || gas.length == 0) {
            return -1;
        }
        int start = 0;
        int total = 0; // 代表油箱剩余量的总和
        int sum = 0; // 当前油箱油量
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            if (sum < 0) {
                sum = gas[i] - cost[i];
                start = i;
            } else {
                sum += gas[i] - cost[i];
            }
        }
        return total >= 0 ? start : -1;
    }












}
