import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunhongbo on 16/4/21.
 */
public class CombinationNum {
    public static void main(String[] args) {
        List<List<Integer>> exa = combine(4, 2);
        for (int i = 0; i < exa.size(); i++) {
            List<Integer> inner = exa.get(i);
            for(int j = 0; j  < inner.size(); j++) {
                System.out.println(inner.get(j));
            }
        }
    }

    //combine1
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> array = new ArrayList<Integer>();
        combination(res, 1, n, array, k);
        return res;
    }
    public static void combination(List<List<Integer>> res, int start, int sum, List<Integer> array, int k) {
        if (sum == 0 && array.size() == k) {
            List<Integer> temp = new ArrayList<Integer>();
            temp.addAll(array);
            res.add(temp);
        }
        for (int i = start; i <= 9; i++) {
            if (sum - i < 0) return;
            if (array.size() > k) return;

            array.add(i);
            combination(res, i+1, sum-i, array, k);
            array.remove(array.size() - 1);
        }
    }

    //combine2
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> array = new ArrayList<Integer>();
        combination1(res, 1, n, array, k);
        return res;
    }
    public static void combination1(List<List<Integer>> res, int start, int n, List<Integer> array, int k) {
        if (array.size() == k) {
            List<Integer> temp = new ArrayList<Integer>();
            temp.addAll(array);
            res.add(temp);
        }
        for (int i = start; i <= n; i++) {
            if (array.size() > k) return;

            array.add(i);
            combination1(res, i+1, n, array, k);
            array.remove(array.size() - 1);
        }
    }
}
