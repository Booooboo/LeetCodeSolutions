import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by sunhongbo on 16/6/17.
 */
public class CombinationSumII {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return null;
        Arrays.sort(candidates);
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        getConbination(candidates, res, temp, target, 0);

        // 去重res中的数组
        HashSet<List<Integer>> set = new HashSet<List<Integer>>(res);
        res.clear();
        res.addAll(set);
        return res;
    }
    public static void getConbination(int[] candidates, List<List<Integer>> res, List<Integer> temp, int target, int start) {
        // target为0,说明找到数组
        if (target == 0) {
            res.add(new ArrayList<Integer>(temp));
            return;
        }

        // 每次传进来的start 指定数组candidates的起始点下标
        for (int i = start; i < candidates.length; i++) {
            if (target < candidates[i]) {
                continue;
            }
            temp.add(candidates[i]);
            getConbination(candidates, res, temp, target - candidates[i], i+1);
            // 递归调用
            temp.remove(temp.size() - 1);
        }
    }
}
