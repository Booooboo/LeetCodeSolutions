/**
 * Created by sunhongbo on 16/4/14.
 */
public class Array2BST {
    public static void main(String[] args) {
        int[] exa = new int[]{1,2,3};
        TreeNode root = sortedArrayToBST(exa);
        System.out.println(root.val);
        System.out.println(root.left.val);
        System.out.println(root.right.val);
    }
    public static TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        if (n == 0) return null;
        TreeNode root = new TreeNode(nums[n/2]);
        int[] left = new int[n/2];
        int[] right = new int[n - n/2 - 1];
        for (int i = 0; i < n/2; i++) {
            left[i] = nums[i];
        }
        int k = 0;
        for (int j = n/2+1; j < n; j++) {
            right[k++] = nums[j];
        }
        root.left = sortedArrayToBST(left);
        root.right = sortedArrayToBST(right);
        return root;
    }
}
