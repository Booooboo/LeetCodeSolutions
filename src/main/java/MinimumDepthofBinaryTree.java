/**
 * Created by sunhongbo on 16/5/25.
 */
public class MinimumDepthofBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        System.out.println(minDepth(root));
    }

    public static int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right != null)
            return minDepth(root.right) + 1;
        if (root.right == null && root.left != null)
            return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left) + 1, minDepth(root.right) + 1);
    }
}
