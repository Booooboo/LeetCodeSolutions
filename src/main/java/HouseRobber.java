/**
 * Created by sunhongbo on 16/4/14.
 */
public class HouseRobber {
    public static void main(String[] args) {

    }
    public static int rob(TreeNode root) {
        int[] res = maxRob(root);
        return Math.max(res[0], res[1]);
    }
    public static int[] maxRob(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int[] left = maxRob(root.left);
        int[] right = maxRob(root.right);
        int res[] = new int[2];
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];
        return res;
    }
 }
