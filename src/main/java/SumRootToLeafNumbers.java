/**
 * Created by sunhongbo on 16/5/16.
 */
public class SumRootToLeafNumbers {
    public static void main(String[] args) {

    }
    public static int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }
    public static int dfs(TreeNode tree, int sum) {
        if (tree == null) {
            return 0;
        }
        if (tree.left == null && tree.right == null) {
            return 10*sum + tree.val;
        }
        return dfs(tree.left, sum*10 + tree.val) + dfs(tree.right, sum*10 + tree.val);
    }
}
