import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sunhongbo on 16/6/15.
 */

public class SerializeDeserializeBT {
    public static void main(String[] args) {
        TreeNode exa = new TreeNode(1);
        exa.left = new TreeNode(2);
        exa.right = new TreeNode(3);
        exa.left.right = new TreeNode(4);
        System.out.println(serialize(exa));
        String str = "[1,2]";
        TreeNode res = deserialize(str);
    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if (root == null) return null;
        String res = "";
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        res += "[" + root.val;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (temp.left != null) {
                    queue.add(temp.left);
                    res += "," + temp.left.val;
                } else {
                    res += ",null";
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                    res += "," + temp.right.val;
                } else {
                    res += ",null";
                }
            }
            res += "]";
        }
        return res;
    }

     //Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data == null) return null;

        String temp = data.substring(1, data.length()-1);
        String[] vals = temp.split(",");
        int[] nums = new int[vals.length]; // 节点i之前null节点的个数
        TreeNode[] nodes = new TreeNode[vals.length];

        for (int i = 0; i < vals.length; i++) {
            if (i > 0) {
                nums[i] = nums[i - 1];
            }
            if (vals[i].equals("null")) {
                nodes[i] = null;
                nums[i]++;
            } else {
                nodes[i] = new TreeNode(Integer.parseInt(vals[i]));
            }
        }

        for (int i = 0; i < vals.length; i++) {
            if (nodes[i] == null) {
                continue;
            }
            nodes[i].left = nodes[2 * (i - nums[i]) + 1];
            if (2 * (i - nums[i]) + 2 < vals.length) {
                nodes[i].right = nodes[2 * (i - nums[i]) + 2];
            } else {
                nodes[i].right = null;
            }
        }

        return nodes[0];
    }
}
