import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by sunhongbo on 16/6/7.
 */
public class SumClosest {
    public static void main(String[] args) {
        int[] fs = {1, 0, -1, 0, -2, 2};
        int[] fs1 = {-1, 0, 1, 2, -1, -4};
        int[] fs2 = {4, -9, -2, -2, -7, 9, 9, 5, 10, -10, 4, 5, 2, -4, -2, 4, -9, 5};

        int[] g = {3, 2, 1};
        nextPermutation(g);

        System.out.println(getPermutation(3, 4));

        test();

        List<List<Integer>> fourSum = new ArrayList<List<Integer>>();
        fourSum = fourSum(fs2, -13);
        for (int i = 0; i < fourSum.size(); i++) {
            System.out.println(fourSum.get(i));
        }

        int[][] a = {{1, 2, 3}};
        System.out.println(a[0].length);

        int[][] b = {{1}};
        rotate(b);

        int[] res = {9};
        int[] result = plusOne(res);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
        }

    }
    //Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target
    // . Return the sum of the three integers. You may assume that each input would have exactly one MaximumGap.

    public static int threeSumClosest(int[] nums, int target) {
        int result = 0;
        int min = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                int diff = Math.abs(sum - target);

                if (diff == 0)
                    return sum;
                if (diff < min) {
                    min = diff;
                    result = sum;
                }
                if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i == 0 || nums[i] > nums[i - 1]) {
                for (int j = i + 1; j < nums.length - 2; j++) {
                    if (j != i + 1 && nums[j] == nums[j - 1]) { // 去重第二个点的重复点, 跟第一个点重复的不算重复
                        continue;
                    }
                    int k = j + 1;
                    int s = nums.length - 1;
                    while (k < s) {
                        if (nums[j] + nums[k] + nums[s] == target - nums[i]) {
                            List<Integer> temp = new ArrayList<Integer>();
                            temp.add(nums[i]);
                            temp.add(nums[j]);
                            temp.add(nums[k]);
                            temp.add(nums[s]);
                            result.add(temp);
                            k++;
                            s--;
                            while (k < s && nums[k] == nums[k - 1]) { // 除去第三个点重复的点
                                k++;
                            }
                            while (k < s && nums[s] == nums[s + 1]) { // 除去第四个点重复的点
                                s--;
                            }
                        } else if (nums[i] + nums[j] + nums[k] + nums[s] < target) {
                            k++;
                        } else {
                            s--;
                        }

                    }
                }
            }
        }
        return result;
    }

    public static void nextPermutation(int[] nums) {
        int x = nums.length - 2;
        while (x >= 0 && nums[x] >= nums[x + 1]) { // 第一个等号:遍历到index为0的元素 第二个等号:仍然可能是升序
            x--;
        }
        int changeIndex = x;

        if (changeIndex >= 0) { // 如果整个序列逆序, 下一个字典序列 直接reverse当前序列即可
            int changeDes = changeIndex + 1; // 替换index
            while (changeDes < nums.length && nums[changeIndex] < nums[changeDes]) {
                changeDes++;
            }
            changeDes--;

            int tempValue = nums[changeIndex];
            nums[changeIndex] = nums[changeDes];
            nums[changeDes] = tempValue;
        }
        reverse(nums, changeIndex + 1);
    }

    private static void reverse(int[] nums, int start) { // 反转数组算法
        int end = nums.length - 1;
        while (start < end) { // 左右边界两个指针交换 向内收缩
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }


    public static String getPermutation(int n, int k) {
        String res = "";
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            arrayList.add(i);
        }
        // 算阶乘
        int mod = 1;
        for (int i = 1; i <= n; i++) {
            mod *= i;
        }

        //用k除以mod算数组的index值, 所以要把k--
        k--;
        for (int i = 0; i < n; i++) {
            mod /= n - i;
            int index = k / mod;
            res += arrayList.get(index);
            k = k % mod;
            arrayList.remove(index); // 关键点
        }
        return res;
    }

    public static boolean isValidSudoku(char[][] board) {
        HashSet<Character> set = new HashSet<Character>();
        for (int i = 0; i < 9; i++) { // 检查每行
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                } else if (set.contains(board[i][j])) {
                    return false;
                } else {
                    set.add(board[i][j]);
                }
            }
            set.clear();
        }
        for (int j = 0; j < 9; j++) {
            for (int i = 0; i < 9; i++) {
                if (board[i][j] == '.') {
                    continue;
                } else if (set.contains(board[i][j])) {
                    return false;
                } else {
                    set.add(board[i][j]);
                }
            }
            set.clear();
        }
        // k = 0   i = 0(j=012) i = 1(j=012) i = 2(j=012) ; k = 1  i=0(j=345) i=1(j=345) i=2(j=345)...
        // k = 3   i = 3(j=012) i = 4(j=012)...
        for (int k = 0; k < 9; k++) {
            for (int i = k / 3 * 3; i < k / 3 * 3 + 3; i++) { // 1/3 = 0, 所以k = 0 1 2的时候 都是前三排
                for (int j = (k % 3) * 3; j < (k % 3) * 3 + 3; j++) {
                    if (board[i][j] == '.')
                        continue;
                    if (set.contains(board[i][j]))
                        return false;
                    set.add(board[i][j]);
                }
            }
            set.clear();
        }
        return true;
    }

    private static void test() {
        for (int k = 0; k < 9; k++) {
            for (int i = k / 3 * 3; i < k / 3 * 3 + 3; i++) {
                for (int j = (k % 3) * 3; j < (k % 3) * 3 + 3; j++) {
                    System.out.print(i);
                    System.out.println(j);
                }
            }
        }
    }


    public static int trap(int[] height) {
        // 数组的两端开始逼近中间, 找到当前左右指针所指值中低点,与当前第二高的点比较,大的作为新的第二高点,
        // 然后求第二高点减去当年指针所指的点即为存水量
        int left = 0;
        int right = height.length - 1;
        int secHeight = 0;
        int result = 0;
        while (left < right) {
            if (height[left] <= height[right]) {
                secHeight = Math.max(secHeight, height[left]);
                result += secHeight - height[left];
                left++;
            } else {
                secHeight = Math.max(secHeight, height[right]);
                result += secHeight - height[right];
                right--;
            }
        }
        return result;
    }


    public static void rotate(int[][] matrix) {
        if (matrix == null) {
            return;
        }
        int len = matrix.length; //获得二维数组的行数
        int[][] temp = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                temp[j][len - i - 1] = matrix[i][j];
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                matrix[i][j] = temp[i][j];
            }
        }
    }


    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        boolean flag = false;
        int count = 0;
        if (digits[n - 1] + 1 < 10) {
            digits[n - 1] = digits[n - 1] + 1;
            return digits;
        }
        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1) {
                count = 1;
            }
            if (count != 0) {
                if (digits[i] + count >= 10) {
                    count = 1;
                    digits[i] = digits[i] + count - 10;
                } else {
                    digits[i] = digits[i] + count;
                    count = 0;
                }
            }
            if (i == 0 && count != 0) {
                flag = true;
            }
        }
        if (flag) {
            int[] result = new int[n + 1];
            for (int  i = n; i > 0; i--) {
                result[i] = digits[n-1];
            }
            result[0] = count;
            return result;
        } else {
            return digits;
        }
    }

}
