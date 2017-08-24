import java.util.ArrayList;

/**
 * Created by sunhongbo on 16/4/13.
 */
public class KSmallest {
    public static void main(String[] args) {
        TreeNode exa = new TreeNode(5);
        exa.left = new TreeNode(2);
        exa.left.right = new TreeNode(4);
        exa.right = new TreeNode(8);
        exa.right.right = new TreeNode(9);
        System.out.println(kthSmallest(exa, 1));
    }
    public static int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        Tree2Array(root, res);
        return res.get(k-1);
    }
    public static void Tree2Array(TreeNode temp, ArrayList res) {
        if (temp.left != null) {
            Tree2Array(temp.left, res);
        }
        res.add(temp.val);
        if (temp.right != null) {
            Tree2Array(temp.right, res);
        }
    }
}
