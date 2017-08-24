import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by sunhongbo on 16/5/24.
 */
public class FlattenBinaryTreetoLinkedList {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        flatten(root);
    }
    //用一个栈和一个队列来实现 ，队列用来存储先序遍历的结果，栈用于先序遍历。
    public static void flatten(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        stack.push(root);
        queue.add(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.peek();
            if (temp.left != null) {
                stack.push(temp.left);
                queue.add(temp.left);
                temp.left = null;
            } else if (temp.right != null){
                stack.push(temp.right);
                queue.add(temp.right);
                temp.right = null;
            } else {
                stack.pop();
            }
        }
        //把根root取出来
        TreeNode node = queue.poll();
        while (!queue.isEmpty()) {
            node.right = queue.poll();
            node = node.right;
        }
    }
}
