import java.util.HashSet;
import java.util.Set;

/**
 * Created by sunhongbo on 16/5/19.
 */
public class LongestConsecutiveSequence {
    public static void main(String[] args) {

    }
    //要求使用线性的时间复杂度O(n) 所以使用hashset
    //HashSet实现了Set接口，它不允许集合中有重复的值  HashSet仅仅存储对象（且无重复对象）
    //HashMap储存键值对
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Set<Integer> hashSet = new HashSet<Integer>();
        int res = 1;
        for(int e : nums) {
            hashSet.add(e);
        }
        for (int e : nums) {
            //每次进来找遍历数组,找出当前元素前后元素个数之和
            int left = e-1;
            int right = e+1;
            int count = 1;

            //如果数组中包含当前元素的左侧相邻元素,将找到的元素remove,继续查找;没有相邻元素,则左侧查找结束
            while (hashSet.contains(left)) {
                hashSet.remove(left);
                count++;
                left--;
            }
            //如果数组中包含当前元素右侧相邻元素,将找到的元素remove,继续查找下一个;没有相邻元素,则右侧查找结束
            while (hashSet.contains(right)) {
                hashSet.remove(right);
                count++;
                right++;
            }
            //更新查找到的最大相邻个数, 用每次当前遍历元素的个数更新
            res = Math.max(res, count);
        }
        return res;
    }
}
