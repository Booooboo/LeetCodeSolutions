/**
 * Created by sunhongbo on 16/5/24.
 */
public class PathSum {
    public static void main(String[] args) {

    }
    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.val == sum && root.left == null && root.right == null)
            return true;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
