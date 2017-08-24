import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunhongbo on 16/6/8.
 */
public class UniqueBinarySearchTreesII {
    public static void main(String[] args) {
        List<TreeNode> a= generateTrees(3);
        for(int i = 0; i < a.size(); i++) {
            System.out.println(a.get(i));
        }
     }

    public static List<TreeNode> generateTrees(int n) {
        if(n==0){
            return new ArrayList<TreeNode>();
        }

        return helper(1, n);
    }

    public static List<TreeNode> helper(int m, int n){
        List<TreeNode> result = new ArrayList<TreeNode>();
        if(m>n){
            result.add(null);
            return result;
        }

        for(int i=m; i<=n; i++){
            List<TreeNode> ls = helper(m, i-1); // 左子树
            List<TreeNode> rs = helper(i+1, n); // 右子树
            for(TreeNode l: ls){
                for(TreeNode r: rs){
                    TreeNode curr = new TreeNode(i);
                    curr.left=l;
                    curr.right=r;
                    result.add(curr);
                }
            }
        }

        return result;
    }
}
