/**
 * Created by sunhongbo on 16/5/12.
 */
public class RemoveElement {
    public static void main(String[] args) {
        int[] exa = {3,2,2,3};
        System.out.println(removeElement(exa, 3));
        for (int i = 0; i < exa.length; i++) {
            System.out.println(exa[i]);
        }
    }
    //3 2 2 3
    //public static int removeElement(int[] nums, int val) {
    //    int res = nums.length;
    //    for (int i = 0; i < nums.length; i++) {
    //        if (val == nums[i]) {
    //            res--;
    //            for (int j = i; j < nums.length-1; j++) {
    //                //temp = nums[j];
    //                nums[j] = nums[j+1];
    //                //nums[j+1] = temp;
    //            }
    //        }
    //        //int temp;
    //    }
    //    return res;
    //}

    //原地使用这个数组 前半部分存储结果所需数组,并且在生成数组过程中计数,不用考虑后半部分数组
    //从数组第一个变量开始,判断是否跟target一致,一致往后遍历数组,直到遍历到不相等的数组中变量,将当前结果数组中的相应位置替换
    public static int removeElement(int[] nums, int val) {
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            if (val != nums[j]) {
                nums[i] = nums[j];
                i++;
            }
            j++;
        }
        return i;
    }
}
