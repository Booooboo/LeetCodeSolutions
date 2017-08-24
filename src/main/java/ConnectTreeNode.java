/**
 * Created by sunhongbo on 16/4/18.
 */
public class ConnectTreeNode {
    public static void main(String[] args) {

    }
    public static void connect(TreeLinkNode root) {
        if (root == null) return;
        TreeLinkNode cur;
        while (root.left != null || root.right != null) {
            cur = root;
            while (cur != null) {
                if (cur.left != null) {
                    cur.left.next = cur.right;
                }
                if (cur.next != null) {
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            if (root.left != null) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
    }
}
