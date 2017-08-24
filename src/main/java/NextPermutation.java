/**
 * Created by sunhongbo on 16/6/27.
 */
public class NextPermutation {
    public static void main(String[] args) {
        //int[] exa = {5,1,1};
        //nextPermutation(exa);
        int[] a = {3, 2, 1};
        nextPermutation(a);
    }

    //比如排列是(2,3,6,5,4,1)，求下一个排列的基本步骤是这样：
    //        1) 先从后往前找到第一个不是依次增长的数，记录下位置p。比如例子中的3，对应的位置是1;
    //2) 接下来分两种情况：
    //        (1) 如果上面的数字都是依次增长的，那么说明这是最后一个排列，下一个就是第一个，其实把所有数字反转过来即可(比如(6,5,4,3,2,1)下一个是(1,2,3,4,5,6));
    //(2) 否则，如果p存在，从p开始往后找，找到下一个数就比p对应的数小的数字，然后两个调换位置，比如例子中的4。调换位置后得到(2,4,6,5,3,1)。最后把p之后的所有数字倒序，比如例子中得到(2,4,1,3,5,6)
    // , 这个即是要求的下一个排列。

    public static void nextPermutation(int[] nums) {
        if (nums== null || nums.length == 0) return;
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i+1]) {// 遍历到index为0的元素
                i--;
        }
        if (i >= 0) { // 如果整个序列逆序, 下一个字典序列 直接reverse当前序列即可
            int j = i + 1;
            //while (j < nums.length) { // 错误写法,会陷入死循环
            //    if (nums[i] < nums[j]) {
            //        j++;
            //    }
            //}
            while (j < nums.length && nums[i] < nums[j]) {
                j++; // 因为这个序列一定是升序的 所以可以直接往后找到最近接 要替换的值
            }
            j--;
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        reverse(nums, i+1);
    }
    public static void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
