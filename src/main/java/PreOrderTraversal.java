import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by sunhongbo on 16/4/6.
 */
public class PreOrderTraversal {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = null;
        tree.right = new TreeNode(2);
        tree.right.left = new TreeNode(3);
        tree.right.right = null;
        List<Integer> exa = preorderTraversals(tree);
        for (int i = 0; i < exa.size(); i++) {
            System.out.println(exa.get(i));
        }

    }

    private static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new LinkedList<Integer>();
        traversal(ret, root);
        return ret;
    }

    private static void traversal(List<Integer> ret, TreeNode node) {
        if (node == null) {
            return;
        } else {
            ret.add(node.val);
            traversal(ret, node.left);
            traversal(ret, node.right);

        }
    }

    //不使用递归,使用栈实现
    private static List<Integer> preorderTraversals(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        Stack<TreeNode> st = new Stack<TreeNode>();
        st.push(root);
        if (root == null) {
            return ret;
        }
        while (!st.isEmpty()) {
            TreeNode temp = st.pop();
            ret.add(temp.val);
            if (temp.right != null) {
                st.push(temp.right);
            }
            if (temp.left != null) {
                st.push(temp.left);

            }
        }
        return ret;
    }



}
