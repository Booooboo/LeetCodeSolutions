/**
 * Created by sunhongbo on 16/6/15.
 */
public class JumpGame {
    public static void main(String[] args) {
        int[] exa = {2, 3, 1, 1, 4};
        int[] exa1 = {3, 2, 1, 0, 4};
        int[] mock = {3,5,1,0,1};
        //System.out.println(canJump(exa));
        //System.out.println(canJump(exa1));
        System.out.println(canJumpTimeout(mock));
        System.out.println(canJump(mock));
    }
    //Given an array of non-negative integers, you are initially positioned at the first index of the array.

    //Each element in the array represents your maximum jump length at that position.

    //Determine if you are able to reach the last index.

    //For example:
    //A = [2,3,1,1,4], return true.

    //A = [3,2,1,0,4], return false.

    
    // TODO: 16/6/15  该题的题意是只要途径的节点 都可以算作是到达终点的步数

    //设置一个max , max能到达数值结尾说明可达
    //当前节点不能到达下一个节点 ,则不可达
    public static boolean canJump(int[] nums) {
        if (nums.length <= 1) return true;
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (max <= i && nums[i] == 0) { // 当前节点不能前进
                return false;
            }
            if (max < i + nums[i]) {
                max = i + nums[i];
            }
            if (max >= nums.length - 1) {
                return true;
            }
        }
        return false;

    }

    // Time Limit Exceeded
    public static boolean canJumpTimeout(int[] nums) {
        int len = nums.length;
        int index = 0;
        int i = 0;
        while (i < len - 1) {
            index = nums[index];
            i += index;
            if (i < len) {
                if (nums[i] == 0 && i != len - 1)
                    return false;
            }
        }
        return true;
    }

}
