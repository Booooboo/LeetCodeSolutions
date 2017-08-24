/**
 * Created by sunhongbo on 16/6/6.
 */
public class PatchingArray {
    public static void main(String[] args) {
        int[] exa1 = {};
        System.out.println(minPatches(exa1, 8)); //范围(1, 8)
    }
    //假设数组当前可以表示的范围为[1, total)内的所有数字，那么向数组中添加元素add可以将表示范围扩充至[1, total + add)，其中add≤total。
    // 当且仅当add=total时取到范围上限[1, 2 * total)。

    //当数组中有小于等于currSum的元素nums[index]时，则利用数组中的元素，同时 currSum += nums[index]；
    //若没有，则添加新元素currSum入数组，此时范围扩展至最大，同时令currSum <<= 1。
    public static int minPatches1(int[] nums, int n) {
        int patchCount = 0;
        int index = 0;
        long miss = 1; //long类型的
        while (miss <= n) {
            if (index < nums.length && nums[index] <= miss) {
                miss += nums[index++];
            } else {
                miss += miss;
                patchCount++;
            }
        }
        return patchCount;
    }

    public static int minPatches(int[] nums, int n) {
        long miss = 1;
        int index = 0;
        int res = 0;
        while (miss <= n) {
            if (index < nums.length && nums[index] <= miss) { //注意顺序不能反
                miss += nums[index++]; //别忘记index要自加
            } else {
                res++;
                miss += miss; //miss = 2miss ,比2miss小的数 可以通过miss+当前数组中的数相加得到
            }
        }
        return res;
    }
}
