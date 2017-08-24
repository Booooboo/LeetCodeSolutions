import java.util.HashMap;
import java.util.Map;


/**
 * Created by sunhongbo on 16/5/19.
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        int[] exa = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] exa2 = {5,2,1,2,1,5};
        int[] exa3 = {4,2,3};
        System.out.println(trap(exa3));
        System.out.println(climbStairs(3));
        int[] s = {3, 2, 2, 1 ,3};
        System.out.println(singleNumber(s));
        int[] q = {3,3,1,4,3,1,1};
        System.out.println(singleNumberII(q));
    }

    //从左右两边往中间靠,每次找出当前比较重的第二最高点,一段一段的计算出水量.
    public static int trap(int[] height) {
        int left = 0;
        int right = height.length-1;
        int area = 0;
        int secHigh = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                secHigh = Math.max(height[left], secHigh);
                area += secHigh - height[left];
                left++;
            } else {
                secHigh = Math.max(height[right], secHigh);
                area += secHigh - height[right];
                right--;
            }
        }
        if (area < 0) return 0;
        return area;
    }



    //0,1,0,2,1,0,1,3,2,1,2,1
    //0,1,2,3,4,5,6,7,8,9,10,11
    //需求看错,该算法适合最低点是0的情况
    public static int traps(int[] height) {
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] == 0 && i != 0) {
                int m = i;
                int n = i;
                while (height[m - 1] > height[m] && m > 0) {
                    m--;
                }
                while (height[n + 1] > height[n] && n < height.length - 1) {
                    n++;
                }
                int high = Math.min(height[m], height[n]);
                res += ((n - m + 1) * (high - height[i]));
                for (int j = m; j < n; j++) {
                    res -= height[j];
                }
                res -= height[i];
            }
        }
        return res;
    }

    //该题目算法
    //0,1,0,2,1,0,1,3,2,1,2,1
    //5,2,1,2,1,5
    //0,1,2,3,4,5,6,7,8,9,10,11
    //public static int trap(int[] height) {
    //    int res = 0;
    //    int i = 1;
    //    while (i < height.length) {
    //        int m = i;
    //        int n = i;
    //        while (m > 0 && height[m - 1] > height[m]) {
    //            m--;
    //        }
    //        while (n < height.length - 1 && height[n + 1] > height[n]) {
    //            n++;
    //        }
    //        if (m == n || m == i || n == i) {
    //            i = n+1;
    //            continue;
    //        }
    //        int high = Math.min(height[m], height[n]);
    //        res += ((n - m + 1) * (high));
    //        for (int j = m; j < n; j++) {
    //            if (height[j] > high) {
    //                res -= high;
    //            } else {
    //                res -= height[j];
    //            }
    //        }
    //        res -= (high);
    //        i = n + 1;
    //    }
    //    return res;
    //}


    public static int climbStairs(int n) {
        //直接用递归 会超时; 所以使用动态规划方法, 保存每次求得的中间值
        //if (n == 1) return 1;
        //if (n == 2) return 2;
        //return climbStairs(n-1) + climbStairs(n-2);
        if (n < 3) {
            return n;
        }
        int[] matrix = new int[n];
        matrix[0] = 1;
        matrix[1] = 2;
        for (int i = 2; i < n; i++) {
            matrix[i] = matrix[i-2] + matrix[i-1];
        }
        return matrix[n-1];
    }

    // 小孩子的排序是确定的, 根据得分给小孩子分糖,只要保证从左到右和从右到左都满足条件即可
    // 所以扫描两次, 一次从左往右, 一次从右往左, 当前位置 取糖果做大的值给孩子分即可满足
    public static int candy(int[] ratings) {
        int len = ratings.length;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = 1;
        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i-1]) {
                left[i] = left[i-1] + 1;
            } else {
                left[i] = 1;
            }
        }
        right[len - 1] = left[len - 1];
        for (int j = len-2; j >= 0; j--) {
            if (ratings[j] > ratings[j+1]) {
                right[j] = right[j+1] + 1;
            } else {
                right[j] = 1;
            }
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            res += Math.max(left[i], right[i]);
        }
        return res;
    }

    public static int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0 ; i < nums.length; i++) {
            res = res ^ nums[i];
        }
        return res;
    }

    public static int singleNumberII(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], 2);
            } else {
                map.put(nums[i], 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == 1) {
                return nums[i];
            }
        }
        return 0;
    }



















}
