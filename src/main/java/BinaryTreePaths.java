import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunhongbo on 16/6/8.
 */
public class BinaryTreePaths {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        //[1,2,3,null,5]
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        List<String > res = binaryTreePaths(root);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        List<Integer> temp = new ArrayList<Integer>();
        getPath(root, result, temp);
        return result;
    }
    public static void getPath(TreeNode root, List<String> result, List<Integer> temp) {
        if (root == null) return;
        temp.add(root.val);
        if (root.left == null && root.right == null) { //终止条件,说明找到一条分支,把该条分支放到结果数组里
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < temp.size(); i++) {
                if (i != 0) {
                    stringBuilder.append("->");
                }
                stringBuilder.append(temp.get(i));
            }
            result.add(stringBuilder.toString());
        }
        getPath(root.left, result, temp);// 递归遍历
        getPath(root.right, result, temp);
        temp.remove(temp.size() - 1);
    }
}
