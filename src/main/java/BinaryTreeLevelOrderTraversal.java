import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by sunhongbo on 16/5/16.
 */
public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {

    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        if (root == null) return res;

        LinkedList<TreeNode> current = new LinkedList<TreeNode>();
        LinkedList<TreeNode> next = new LinkedList<TreeNode>();
        current.add(root);
        while (!current.isEmpty()) {
            TreeNode treeNode = current.remove();
            if (treeNode.left != null) next.add(treeNode.left);
            if (treeNode.right != null) next.add(treeNode.right);
            temp.add(treeNode.val);
            if (current.isEmpty()) {
                res.add(temp);
                current = next;
                next = new LinkedList<TreeNode>();
                temp = new ArrayList<Integer>();
            }
        }
        return res;
    }
}
