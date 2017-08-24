/**
 * Created by sunhongbo on 16/5/13.
 */
public class RemoveDuplicatesfromSortedArray {
    public static void main(String[] args) {
        int[] exa = {0,1,1,2,3,3};
        System.out.println(removeDuplicates(exa));

    }
    //{1,1,1,2,3,3}
    public static int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 1;
        while(j < nums.length) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
            j++;
        }
        return i+1;
    }
}
