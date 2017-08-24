/**
 * Created by sunhongbo on 16/4/26.
 */
public class MaxContainer {
    public static void main(String[] args) {

    }
    //贪心算法
    //求最大的面积
    public static int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int res = 0;
        while(start < end) {
            res = Math.max(res, Math.min(height[start], height[end]) * (end-start));
            if (height[start] <= height[end]) {
                start++;
            } else {
                end--;
            }
        }
        return res;
    }
}
