/**
 * Created by sunhongbo on 16/5/11.
 */
public class SymmetryTree {
    public static void main(String[] args) {

    }
    //    1
    //  2   2
    // 34   43
    //5678 8765
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return ifSymmetric(root.left, root.right);
    }

    public static boolean ifSymmetric(TreeNode tree1, TreeNode tree2) {
        if (tree1 == null && tree2 == null) {
            return true;
        }
        if (tree1 == null || tree2 == null) {
            return false;
        }
        if (tree1.val != tree2.val) return false;
        return ifSymmetric(tree1.left, tree2.right) && ifSymmetric(tree1.right, tree2.left);
    }
}
