/**
 * Created by sunhongbo on 16/5/26.
 */
public class ConvertSListtoBST {
    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        sortedListToBST(root);
    }

    static ListNode h;

    public static TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        h = head;
        int n = getLength(head);
        return sortedListBST(0, n-1);
    }

    public static int getLength(ListNode root) {
        int n = 0;
        ListNode p = root;
        while (p != null) {
            n++;
            p = p.next;
        }
        return n;
    }

    public static TreeNode sortedListBST(int start, int end) {
        if (start > end) return null;

        int mid = start + (end-start)/2;
        TreeNode left= sortedListBST(start, mid-1);
        TreeNode root = new TreeNode(h.val);
        h = h.next;
        TreeNode right = sortedListBST(mid+1, end);

        root.left = left;
        root.right = right;
        return root;
    }

    //static ListNode h;

    //public static TreeNode sortedListToBST(ListNode head) {
    //    if (head == null)
    //        return null;
    //
    //    h = head;
    //    int len = getLength(head);
    //    return sortedListToBST(0, len - 1);
    //}

    // get list length
    //public static int getLength(ListNode head) {
    //    int len = 0;
    //    ListNode p = head;
    //
    //    while (p != null) {
    //        len++;
    //        p = p.next;
    //    }
    //    return len;
    //}

    // build tree bottom-up
    public static TreeNode sortedListToBST(int start, int end) {
        if (start > end)
            return null;

        // mid
        int mid = (start + end) / 2;

        TreeNode left = sortedListToBST(start, mid - 1);
        TreeNode root = new TreeNode(h.val);
        h = h.next;
        TreeNode right = sortedListToBST(mid + 1, end);

        root.left = left;
        root.right = right;

        return root;
    }
}
