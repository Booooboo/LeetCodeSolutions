
/**
 * Created by sunhongbo on 16/6/7.
 */
public class BinaryTreeFromPITraversal {
    public static void main(String[] args) {
        int[] left = {1,2};
        int[] right = {1,2};
        TreeNode a = buildTree(left, right);
    }
    //中序遍历和后序遍历
    public static TreeNode buildTree1(int[] inorder, int[] postorder) {
        if (inorder.length == 0) return null;
        TreeNode res= buildTree(inorder, 0,inorder.length-1,  postorder, 0, postorder.length-1);
        return res;
    }
    public static TreeNode buildTree(int[] inorder,int ileft, int iright, int[] postorder, int pleft, int pright) {
        if (ileft > iright) return null;
        int mid = 0;
        for (int i = ileft; i <= iright; i++) {
            if (inorder[i] == postorder[pright]) {
                mid = i;
                break;
            }
        }
        int len = mid - ileft;
        // 中序遍历 bcade
        // 后序遍历 cbdea
        TreeNode left = buildTree(inorder, ileft, mid-1, postorder,pleft, pleft + len -1); // cb 是做孩子 pleft, pleft+len -1
        TreeNode right = buildTree(inorder, mid+1, iright, postorder, pleft+len, pright-1); //de 是右孩子 pleft+len, pright-1
        TreeNode node = new TreeNode(postorder[pright]);
        node.left = left;
        node.right = right;
        return node;
    }

    //前序遍历和中序遍历
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreePI(inorder, 0, inorder.length - 1, preorder, 0, preorder.length-1);
    }

    public static TreeNode buildTreePI(int[] inorder,int ileft, int iright, int[] preorder, int pleft, int pright) {
        if (ileft > iright) return null;
        int mid = 0;
        for (int i = ileft; i <= iright; i++) {
            if (inorder[i] == preorder[pleft]) {
                mid = i;
                break;
            }
        }
        int len = mid - ileft;
        //先序遍历 abced
        //中序遍历 bcade
        TreeNode left = buildTreePI(inorder, ileft, mid-1, preorder,pleft+1, pleft + len); //bc 是pleft+1到pleft+len
        TreeNode right = buildTreePI(inorder, mid+1, iright, preorder, pleft+len+1, pright); //de 是pleft+len+1和pright
        TreeNode node = new TreeNode((preorder[pleft]));
        node.left = left;
        node.right = right;
        return node;
    }
}
