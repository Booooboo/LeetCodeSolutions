/**
 * Created by sunhongbo on 16/3/29.
 */
public class InverseTreeNode {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(2);
        tree.left = new TreeNode(1);
        tree.left.right = new TreeNode(5);
        tree.right = new TreeNode(6);
        TreeNode ret = invertTree(tree);
        System.out.println(ret.left.val);
        System.out.println(ret.right.left.val);
    }
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
