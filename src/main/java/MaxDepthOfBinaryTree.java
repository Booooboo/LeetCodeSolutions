/**
 * Created by sunhongbo on 16/3/29.
 */
public class MaxDepthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(2);
        tree.left = new TreeNode(1);
        tree.left.right = new TreeNode(5);
        tree.right = new TreeNode(6);
        System.out.println(maxDepth(tree));
    }


    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return theDepth(root);
    }

    public static int theDepth(TreeNode node) {
        int leftDepth = 1;
        int rightDepth = 1;
        if (node.left != null) {
            leftDepth = theDepth(node.left) + 1;
        }
        if (node.right != null) {
            rightDepth = theDepth(node.right) + 1;
        }
        return Math.max(leftDepth, rightDepth);
    }
}

