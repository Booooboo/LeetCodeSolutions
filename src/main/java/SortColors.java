/**
 * Created by sunhongbo on 16/4/26.
 */
public class SortColors {
    public static void main(String[] args) {
        int[] exa = {2,1,2,1,1,0,0,1};
        sortColors(exa);
        for (int i=0; i < exa.length; i++) {
            System.out.println(exa[i]);
        }
    }
    public static void sortColors(int[] nums) {
        int index = 0;
        int[] num = new int[3];
        for (int i = 0; i < nums.length; i++) {
            num[nums[i]]++;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < num[i]; j++) {
                nums[index++] = i;
            }
        }
    }
}
