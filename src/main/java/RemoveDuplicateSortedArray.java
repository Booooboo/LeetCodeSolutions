import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Created by sunhongbo on 17/6/19.
 */
public class RemoveDuplicateSortedArray {
    public static void main(String[] args) {

        int[] a = {1, 1, 2};
        int[] b = {1, 1, 1, 1, 2, 2, 3, 3};
        int[] c = {4, 5, 6, 7, 0, 1, 2};
        int[] d = {1, 3, 1, 1, 1};
        int[] e = {1, 3, 6, 8, 9, 10};
        int[] f = {2, 4, 5, 7, 12};
        int[] g = {100, 4, 200, 1, 3, 2};
        int[] h = {-1, 0, 1, 2, -1, -4};
        int[] i = {-1, 2, 1, -4};
        int[] j = {1,2,4,8,16,32,64,128};
        threeSum(h);
        int[] k = {3, 2, 2, 3};
        int[] l = {1};

        System.out.println(remove(a));
        System.out.println(removeAllowTwo(b));
        System.out.println(SearchInRotateArray(c, 7));
        System.out.println(SearhInRotateArrayII(d, 1));
        System.out.println(FindMidNum(e, 6, f, 5));
        System.out.println(FindMaxArray(g));
        //System.out.println(ThreeSumCloset(i, -2));
        System.out.println(ThreeSumCloset(j, 82));

        System.out.println(removeElement(l, 1));
    }

    private static int remove(int[] des) {
        int index = 0;
        for (int i = 1; i < des.length; i++) {
            // index和i两个指针, index是新数组的指针, i是原始数组的指针
            if (des[index] != des[i])
                //把后面的数据往前移动
                des[++index] = des[i];
        }
        return index + 1;
    }

    private static int removeAllowTwo(int[] des) {
        int index = 3;
        for (int i = 3; i < des.length; i++) {
            if (des[index - 3] != des[i]) {
                // 11111223 des[0] != des[2] 去重第三个到第n个一样的元素,直至找到最后一个
                des[index] = des[i]; // 11211223 i = 5 index = 2
                index++;
            }
        }

        return index;
    }

    public static int removeElement(int[] nums, int val) {
        // 找两个指针, 一个指新数组的指针并代表个数, 一个指老数组的指针 用于遍历整个数组
        int newIndex = 0;
        for (int oldIndex = 0; oldIndex < nums.length; oldIndex++) {
            if (nums[oldIndex] != val) {
                nums[newIndex++] = nums[oldIndex];
            }
        }
        return newIndex;
    }

    private static int SearchInRotateArray(int nums[], int target) {
        int len = nums.length;
        int left = 0;
        int right = len;
        int mid;
        // 4 5 6 7 0 1 2
        while (left != right) {
            mid = (left + right) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (nums[mid] >= nums[left]) { // 遍历的方式采用mid值和left值对比
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            } else {
                // target和mid值相等是在第一个条件
                if (target > nums[mid] && target <= nums[right - 1]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

        }
        return -1;
    }

    private static boolean SearhInRotateArrayII(int[] des, int target) {
        int len = des.length;
        int left = 0;
        int right = len;
        int mid;
        while (left != right) {
            mid = (left + right) / 2;
            if (des[mid] == target) {
                return true;
            } else if (des[mid] > des[left]) {
                //递增子数组
                if (target >= des[left] && target < des[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            } else if (des[mid] < des[left]) {
                if (target > des[mid] && target <= des[right - 1]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            } else {
                // des[mid] == des[left]
                left++;
            }
        }
        return false;
    }

    private static int FindMidNum(int[] A, int m, int[] B, int n) {
        int total = m + n;
        if ((total & 0x1) != 0) {
            return FindKth(A, m, B, n, total / 2 + 1);
        } else {
            return (FindKth(A, m, B, n, total / 2) + FindKth(A, m, B, n, total / 2 + 1)) / 2;
        }
    }

    private static int FindKth(int[] A, int m, int[] B, int n, int k) {
        // 保证 m>=n
        if (m > n)
            return FindKth(B, n, A, m, k);
        if (m == 0)
            return B[k - 1];
        if (k == 1)
            return Math.min(A[0], B[0]);
        int pa = Math.min(m, k / 2);
        int pb = k - pa;
        if (A[pa - 1] < B[pb - 1]) {
            //注意传进去的数组
            int[] a = new int[m - pa];
            System.arraycopy(A, pa, a, 0, m - pa);
            return FindKth(a, m - pa, B, n, k - pa);
        } else if (A[pa - 1] > B[pb - 1]) {
            int[] b = new int[n - pb];
            System.arraycopy(B, pb, b, 0, n - pb);
            return FindKth(A, m, b, n - pb, k - pb);
        } else {
            return A[pa - 1];
        }
    }

    // 时间复杂度O(n), 空间复杂度O(n)
    private static int FindMaxArray(int[] des) {
        HashMap<Integer, Boolean> used = new HashMap<Integer, Boolean>();
        for (int i = 0; i < des.length; i++) {
            used.put(des[i], false);
        }
        int longest = 0;
        for (int i = 0; i < des.length; i++) {
            if (used.get(des[i]))
                continue; // 当前元素被查过, 直接过
            int length = 1;
            used.put(des[i], true); // 当前元素被遍历, 把值置成true
            /* 遍历哈希表的方法之一 */
            Iterator iterator = used.entrySet().iterator();
            // 查找当前元素的前后元素是否在数组中

            // 判断条件是当前数组是否到结尾 && 当前数组中是否有元素j
            // 查找当前数组中是否有元素j, 使用的方法 get(j) 有元素返回这个元素对应的值,没有返回null
            for (int j = des[i] + 1; iterator.hasNext() && used.get(j) != null; j++) {
                // 使用过该元素, 将该元素对应的值设置成true
                used.put(j, true);
                ++length;
            }

            for (int k = des[i] - 1; iterator.hasNext() && used.get(k) != null; k--) {
                used.put(k, true);
                ++length;
            }
            longest = Math.max(longest, length);
        }
        return longest;
    }


    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (nums == null || nums.length < 3)
            return result;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] > nums[i - 1]) {
                int j = i + 1;
                int k = nums.length - 1;

                while (j < k) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> l = new ArrayList<Integer>();
                        l.add(nums[i]);
                        l.add(nums[j]);
                        l.add(nums[k]);
                        result.add(l);

                        j++;
                        k--;

                        //handle duplicate here
                        while (j < k && nums[j] == nums[j - 1])
                            j++;
                        while (j < k && nums[k] == nums[k + 1])
                            k--;

                    } else if (nums[i] + nums[j] + nums[k] < 0) {
                        j++;
                    } else {
                        k--;
                    }
                }
            }

        }

        return result;
    }


    private static List<List<Integer>> ThreeSum(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (num == null || num.length < 3) {
            return result;
        }
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
            if (i == 0 || num[i] > num[i - 1]) { // 扫描过程中把相同基数去重
                int j = i + 1; // 首指针
                int k = num.length - 1; // 尾指针
                while (j < k) {
                    if (num[i] + num[j] + num[k] == 0) {
                        List<Integer> temp = new ArrayList<Integer>();
                        temp.add(num[i]);
                        temp.add(num[j]);
                        temp.add(num[k]);
                        result.add(temp);

                        j++;
                        k--;
                        //删除相同元素
                        while (j < k && num[j] == num[j - 1])
                            j++; // 首指针去重
                        while (j < k && num[k] == num[k + 1])
                            k--; // 尾指针去重
                    } else if (num[i] + num[j] + num[k] < 0) {
                        j++;
                    } else {
                        k--;
                    }
                }
            }
        }
        return result;
    }

    private static int ThreeSumCloset(int[] nums, int target) {
        int result = 0;
        int min = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] > nums[i - 1]) {
                int j = i + 1;
                int k = nums.length - 1;

                while ((j < k)) {
                    int sum = nums[i] + nums[j] + nums[k];
                    int diff = Math.abs(sum - target);
                    if (diff == 0) {
                        return sum;
                    }
                    if (min > diff) {
                        result = sum;
                        min = diff;
                    }
                    // 每次基数不变, 以此基数为准, 寻找接近target的3sum
                    if (sum < target) {
                        j++;
                    } else {
                        k--;
                    }
                }

            }
        }
        return result;
    }

}
