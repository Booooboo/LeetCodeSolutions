import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by sunhongbo on 16/4/7.
 */
public class InorderTraversal {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = null;
        tree.right = new TreeNode(2);
        tree.right.left = new TreeNode(3);
        tree.right.right = null;
        List<Integer> exa = inorderTraversals(tree);
        for (int i = 0; i < exa.size(); i++) {
            System.out.println(exa.get(i));
        }
    }

    //使用栈
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        Stack<TreeNode> sk = new Stack<TreeNode>();
        if (root == null) {
            return ret;
        }
        TreeNode p = root;
        while (!sk.isEmpty() || p != null) {
            if (p != null) {
                sk.push(p);
                p = p.left;
            } else {
                TreeNode q = sk.pop();
                ret.add(q.val);
                p = q.right;
            }
        }
        return ret;
    }

    //使用递归
    public static List<Integer> inorderTraversals(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        if (root == null) {
            return ret;
        }
        Traversal(ret, root);
        return ret;
    }

    public static void Traversal(List<Integer> ret, TreeNode root) {
        if (root.left != null) {
            Traversal(ret, root.left);
        }
        ret.add(root.val);
        if (root.right != null) {
            Traversal(ret, root.right);
        }
    }

}
