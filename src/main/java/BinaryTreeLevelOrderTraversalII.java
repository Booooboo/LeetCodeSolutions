import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by sunhongbo on 16/5/10.
 */
public class BinaryTreeLevelOrderTraversalII {
    public static void main(String[] args) {

    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        return res;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();

        if (root == null) return res;
        LinkedList<TreeNode> current  = new LinkedList<TreeNode>();
        LinkedList<TreeNode> next = new LinkedList<TreeNode>();
        current.add(root);
        while (!current.isEmpty()) {
            TreeNode node = current.remove();
            if (node.left != null) {
                next.add(node.left);
            }
            if (node.right != null) {
                next.add(node.right);
            }
            temp.add(node.val);
            if (current.isEmpty()) {
                current = next;
                res.add(temp);
                next = new LinkedList<TreeNode>();
                temp = new ArrayList<Integer>();
            }
        }


        reverstList(res);
        return res;
    }
    public static void reverstList(List<List<Integer>> res) {
        int n = res.size();
        int i =0;
        int j = n-1;
        while (i < j) {
            List<Integer> temp = res.get(i);
            res.set(i, res.get(j));
            res.set(j, temp);
            i++;
            j--;
        }
    }

}
