import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sunhongbo on 16/5/24.
 */
public class CountofSmallerNumbersAfterSelf {
    public static void main(String[] args) {
        int[] exa = {26, 78, 27, 100, 33, 67, 90, 23, 66, 5, 38, 7, 35, 23, 52, 22, 83, 51, 98, 69, 81, 32, 78, 28,
                94, 13, 2, 97, 3, 76, 99, 51, 9, 21, 84, 66, 65, 36, 100, 41};
        int[] exa1 = {1};
        List<Integer> res = countSmaller(exa);
        for (int a : res) {
            System.out.println(a);
        }
    }

    public static List<Integer> countSmaller(int[] nums) {
        Integer[] ans = new Integer[nums.length];
        List<Integer> sorted = new ArrayList<Integer>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int index;
            index = findIndex(sorted, nums[i]);
            ans[i] = index;
            sorted.add(index, nums[i]);
        }
        return Arrays.asList(ans);
    }

    public static int findIndex(List<Integer> sorted, int num) {
        if (sorted.size() == 0)
            return 0;
        int start = 0;
        int end = sorted.size() - 1;

        if (sorted.get(end) < num) {
            return end + 1;
        }
        if (sorted.get(start) >= num) {
            return 0;
        }

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (sorted.get(mid) < num) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        if (sorted.get(start) >= num) {
            return start;
        }
        return end;
    }


    //Traverse from the back to the beginning of the array, maintain an sorted array of numbers have been visited.
    // Use findIndex() to find the first element in the sorted array which is larger or equal to target number. For
    // example, [5,2,3,6,1], when we reach 2, we have a sorted array[1,3,6], findIndex() returns 1, which is the
    // index where 2 should be inserted and is also the number smaller than 2. Then we insert 2 into the sorted array
    // to form [1,2,3,6].
    //从数组后往前看,把第i个元素在当前的有序数组(也就是第一个元素右边的数组)中找到合适位置,并把位置值返回来,作为返回值
    public static List<Integer> countSmaller1(int[] nums) {
        Integer[] ans = new Integer[nums.length];
        List<Integer> sorted = new ArrayList<Integer>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int index = findIndex1(sorted, nums[i]);
            ans[i] = index;
            sorted.add(index, nums[i]);
        }
        return Arrays.asList(ans);
    }

    private static int findIndex1(List<Integer> sorted, int target) {
        if (sorted.size() == 0)
            return 0;
        int start = 0;
        int end = sorted.size() - 1;
        if (sorted.get(end) < target)
            return end + 1;
        if (sorted.get(start) >= target)
            return 0;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (sorted.get(mid) < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        if (sorted.get(start) >= target)
            return start;
        return end;
    }

}
