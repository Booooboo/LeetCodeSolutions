/**
 * Created by sunhongbo on 16/5/31.
 */
public class MergeSortedArray {
    public static void main(String[] args) {


    }
    //从后向前添加结果数组中的数据
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        while (m > 0 && n > 0) {
            if (nums1[m-1] > nums2[n-1]) {
                nums1[m+n-1] = nums1[m-1];
                m--;
            } else {
                nums1[m+n-1] = nums2[n-1];
                n--;
            }
        }
        while (n > 0) {
            nums1[m+n-1] = nums2[n-1];
            n--;
        }
    }
}
