/**
 * Created by sunhongbo on 16/4/11.
 */
public class FindDuilplateNumber {
    public static void main(String[] args) {
        int[] exa = new int[]{5,5,4,6,3,2,1};
        System.out.println(findDuplicate(exa));
    }
    public static int findDuplicate(int[] nums) { //不需要数组有序,最后找到的跟mid比较的个数就是数组的下标.
        int n = nums.length - 1;
        int low = 1, high = n;
        int mid = 0;
        while (low < high) {
            mid = low + (high-low)/2;
            int c = findPosition(nums, mid);
            if (c <= mid) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
    public static int findPosition(int[] nums, int mid) {
        int c = 0;
        for (int i = 0; i < nums.length; i++) {
            if (mid >= nums[i]) {
                c++;
            }
        }
        return c;
    }


}
