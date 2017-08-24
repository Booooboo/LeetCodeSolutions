/**
 * Created by sunhongbo on 16/4/6.
 */
public class MissingNumber {
    public static void main(String[] args) {
        int[] exa = new int[]{0,1,2,3,5,6};
        System.out.println(missingNumber2(exa));
    }
    private static int missingNumber(int[] nums) {
        //1 2 3;
        //1+2+3 = (1+3) * 3/2 = 6;
        //6-4 = 2;
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return (0+n)*(n+1)/2 - sum;
     }

    private static int missingNumber2(int[] nums) {
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            ret ^= i ^ nums[i];
        }
        return ret ^ nums.length;
    }
}
