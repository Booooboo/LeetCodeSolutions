/**
 * Created by sunhongbo on 16/3/29.
 */
public class MoveZeros {
    public static void main(String[] args) {
        int[] exam = {0, 1, 3, 0, 12, 0, 0, 5};
        moveZero(exam);
        for (int i = 0; i < exam.length; i++) {
            System.out.println(exam[i]);
        }
    }

    public static void moveZero(int[] nums) {
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[pos++] = nums[i];
            }
        }
        for (; pos < nums.length; pos++) {
            nums[pos] = 0;
        }
    }

    public static void moveZeroe(int[] nums) {
        for (int i = 0; i < nums.length-1; i++) {
            int k = i;
            while (nums[i] == 0) {
                if (nums[k + 1] != 0) {
                    nums[i] = nums[k + 1];
                    nums[k + 1] = 0;
                } else {
                    if (k == nums.length - 2) {
                        break;
                    }
                    k++;
                }
            }
        }
    }

    public static void moveZeroeJ(int[] nums) {
        int pos = 0;
        // 将非0数字都尽可能向前排J
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[pos]= nums[i];
                pos++;
            }
        }
        // 将剩余的都置0
        for(;pos<nums.length; pos++){
            nums[pos] = 0;
        }
    }
}
