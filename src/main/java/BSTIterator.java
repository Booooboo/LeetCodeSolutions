import java.util.Stack;

/**
 * Created by sunhongbo on 16/4/27.
 */
public class BSTIterator {

    private TreeNode cur;
    private Stack<TreeNode> st = new Stack<TreeNode>();
    public BSTIterator(TreeNode root) {
        cur = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if (cur.left != null || !st.isEmpty()) return true;
        return false;
    }

    /** @return the next smallest number */
    public int next() {
        while (cur.left != null) {
            st.push(cur);
            cur = cur.left;
        }
        cur = st.pop();
        TreeNode node = cur;
        cur = cur.right;
        return node.val;
    }
}
