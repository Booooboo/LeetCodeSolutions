/**
 * Created by sunhongbo on 16/6/7.
 */
public class SearchforaRange {
    public static void main(String[] args) {
        //int[] exa = {5, 7, 7, 8, 8, 10};
        //int[] res = (searchRange(exa, 8));
        int[] exa1 = {1, 3};
        int[] res = searchRange(exa1, 1);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
    public static int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len;
        int mid;
        int[] back = {-1, -1};
        while (left <= right) {
            mid = (left+right)/2;
            if (mid > len -1) return back;
            if (nums[mid] == target) {
                int a = mid;
                int b = mid;
                while(a > 0 && nums[a - 1] == target) a--;
                while(b < len -1 && nums[b + 1] == target) b++;
                int[] res = {a, b};
                return res;
            } else if (nums[mid] < target) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return back;
    }
}
