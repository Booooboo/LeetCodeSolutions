import java.security.PublicKey;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by sunhongbo on 16/4/27.
 */
public class BinaryTreeRightSideView {
    public static void main(String[] args) {
        //     1            <---
        //   /   \
        //  2     3         <---
        // /
        // 4
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        List<Integer> res = new ArrayList<Integer>();
        res = rightSideView(root);
        for (int i =0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
    //public static List<Integer> rightSideView(TreeNode root) {
    //    List<Integer> res = new ArrayList<Integer>();
    //    rightSideViewtemp(res, root);
    //    return res;
    //}
    //public static void rightSideViewtemp(List<Integer> res, TreeNode root) {
    //    if (root == null) return;
    //    TreeNode node = root;
    //    res.add(node.val);
    //    while (node.right == null && node.left != null) {
    //        res.add(node.left.val);
    //        node = node.left;
    //    }
    //    rightSideViewtemp(res, node.right);
    //}

    //每次都入队列从右孩子开始,每次一层就把最右边的加入返回值,下层再逐个假如队列.
    public static List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        if (root == null) return res;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode top = queue.remove();
                if (i == 0) {
                    res.add(top.val);
                }
                if (top.right != null) queue.add(top.right);
                if (top.left != null) queue.add(top.left);
            }
        }
        return res;
    }
}
