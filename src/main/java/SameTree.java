/**
 * Created by sunhongbo on 16/3/30.
 */
public class SameTree {
    public static void main(String[] args) {
        TreeNode exa = new TreeNode(1);
        exa.right = new TreeNode(4);
        exa.right.left = new TreeNode(8);
        TreeNode exa2 = new TreeNode(1);
        exa2.right = new TreeNode(4);
        exa2.right.left = new TreeNode(7);
        boolean ret = isSameTree(exa, exa2);
        System.out.println(ret);
    }
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if ((p == null || q == null)) {
            return false;
        }
        if (p.val == q.val) {
            boolean left = isSameTree(p.left, q.left);
            boolean right = isSameTree(p.right, q.right);
            return left&right;
        } else {
            return false;
        }
    }
}
