import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by sunhongbo on 16/4/22.
 */
public class BinaryPostorderTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(2);
        //croot.right.right = new TreeNode(5);
        List<Integer> exa = postorderTraversal(root);
        for (int i = 0; i < exa.size(); i++) {
            System.out.println(exa.get(i));
        }
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> lst = new ArrayList<Integer>();
        if(root == null)
            return lst;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        TreeNode prev = null;
        while(!stack.empty()){
            TreeNode curr = stack.peek();

            if(prev == null || prev.left == curr || prev.right == curr){
                if(curr.left != null){
                    stack.push(curr.left);
                }else if(curr.right != null){
                    stack.push(curr.right);
                }else{
                    stack.pop();
                    lst.add(curr.val);
                }
                //检查左节点的儿子节点是否入过栈,并且如果右节点为null,这个节点输出
            }else if(curr.left == prev){
                if(curr.right != null){
                    stack.push(curr.right);
                }else{
                    stack.pop();
                    lst.add(curr.val);
                }

            }else if(curr.right == prev){
                stack.pop();
                lst.add(curr.val);
            }
            prev = curr;
        }
        return lst;
    }

    public static List<Integer> postorderTraversalCLEVER(TreeNode root) {
        ArrayList<Integer> lst = new ArrayList<Integer>();
        if(root == null)
            return lst;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode temp = stack.peek();
            if (temp.left == null && temp.right == null) {
                lst.add(temp.val);
                stack.pop();
            }
            if (temp.right != null) {
                stack.push(temp.right);
                temp.right = null;
            }
            if (temp.left != null) {
                stack.push(temp.left);
                temp.left = null;
            }
        }
        return lst;
    }
}
