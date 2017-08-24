/**
 * Created by sunhongbo on 16/5/4.
 */
public class LIS {
    public static void main(String[] args) {
        int[] exa = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(exa));

    }
    //[10, 9, 2, 5, 3, 7, 101, 18]
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int max = 1;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && res[i] < res[j] + 1) {
                    res[i] = res[j] + 1;
                    if (res[i] > max) {
                        max = res[i];
                    }
                }
            }
        }
        return max;
    }

}
