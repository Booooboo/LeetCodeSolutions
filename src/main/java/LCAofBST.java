/**
 * Created by sunhongbo on 16/4/11.
 */
public class LCAofBST {
    public static void main(String[] args) {

    }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (p == null && q != null) return q;
        if (p != null && q == null) return p;
        if (Math.max(p.val, q.val) < root.val) {
            return lowestCommonAncestor(root.left, p , q);
        } else if (Math.min(p.val, q.val) > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
}
