import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.omg.PortableInterceptor.INACTIVE;
import org.omg.PortableInterceptor.Interceptor;

/**
 * Created by sunhongbo on 16/5/23.
 */
public class Subsets {
    public static void main(String[] args) {
        int[] exa = {1, 1, 2, 2};
        List<List<Integer>> res = subsetsWithDup(exa);
        for (List<Integer> a : res) {
            System.out.println(a);
        }
    }

    //subset1
    public static List<List<Integer>> subsets(int[] nums) {
        if (nums == null)
            return null;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        for (int i = 0; i  < nums.length; i++) {
            ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
            for (List<Integer> a : res) {
                temp.add(new ArrayList<Integer>(a));
            }
            for (ArrayList<Integer> a : temp) {
                a.add(nums[i]);
            }

            ArrayList<Integer> Single = new ArrayList<Integer>();
            Single.add(nums[i]);
            temp.add(Single);

            res.addAll(temp);
        }
        res.add(new ArrayList<Integer>());

        return res;
    }

    //1 2 2 subset2 with duplicate
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null)
            return null;

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        ArrayList<ArrayList<Integer>> prev = new ArrayList<ArrayList<Integer>>();

        for (int i = nums.length-1; i >= 0; i--) {

            //get existing sets
            if (i == nums.length - 1 || nums[i] != nums[i + 1] || prev.size() == 0) {
                prev = new ArrayList<ArrayList<Integer>>();
                for (int j = 0; j < result.size(); j++) {
                    prev.add(new ArrayList<Integer>(result.get(j)));
                }
            }

            //add current number to each element of the set
            for (ArrayList<Integer> temp : prev) {
                temp.add(0, nums[i]);
            }

            //add each single number as a set, only if current element is different with previous
            if (i == nums.length - 1 || nums[i] != nums[i + 1]) {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.add(nums[i]);
                prev.add(temp);
            }

            //add all set created in this iteration
            for (ArrayList<Integer> temp : prev) {
                result.add(new ArrayList<Integer>(temp));
            }
        }

        //add empty set
        result.add(new ArrayList<Integer>());

        return result;

    }

    public static List<List<Integer>> subsetDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        ArrayList<ArrayList<Integer>> prev = new ArrayList<ArrayList<Integer>>();

        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1 || prev.size() == 0 || nums[i] != nums[i+1]) {
                prev = new ArrayList<ArrayList<Integer>>();
                for (int j = 0; j < res.size(); j++) {
                    prev.add(new ArrayList<Integer>(res.get(j)));
                }
            }
            for (ArrayList<Integer> a : prev) {
                a.add(0 ,nums[i]);
            }
            if (i == nums.length - 1 || nums[i] != nums[i+1]) {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.add(nums[i]);
                prev.add(temp);
            }
            for (ArrayList<Integer> a : prev) {
                res.add(new ArrayList<Integer>(a));
            }
        }
        res.add(new ArrayList<Integer>());
        return res;
    }
}
