import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunhongbo on 16/6/14.
 */
public class PathSumII {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();

        if (root == null) return res;
        temp.add(root.val);
        path(root, sum-root.val, temp, res);
        return res;
    }

    public static void path(TreeNode root , int sum, List<Integer> temp, List<List<Integer>> res) {
        if (0 == sum && root.left == null && root.right == null) {
            res.add(new ArrayList<Integer>(temp));
        }
        if (root.left != null) {
            temp.add(root.left.val);
            path(root.left, sum - root.left.val, temp, res);
            temp.remove(temp.size() -1); // 回退一个节点
        }
        if (root.right != null) {
            temp.add(root.right.val);
            path(root.right, sum - root.right.val, temp, res);
            temp.remove(temp.size()-1);
        }
    }
}
