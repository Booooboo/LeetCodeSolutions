import java.util.Arrays;

/**
 * Created by sunhongbo on 16/5/12.
 */
public class PlusOne {
    public static void main(String[] args) {
        int[] exa = {9};
        int[] res = plusOne(exa);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }

        int[] a = {9};
        plusOne1(a);
        int[] gas = {99,98,97,100};
        int[] cost = {100,100,100,97};
        System.out.println(canCompleteCircuit(gas, cost));
    }
    //public static int[] plusOne(int[] digits) {
    //    int n = digits.length;
    //    int[] res = new int[n];
    //    int[] carry = new int[n+1];
    //    for (int i = n-1; i >= 0; i--) {
    //        if (i == n-1) {
    //            if (digits[i] + 1 >= 10) {
    //                carry[i] = (digits[i]+1)/10;
    //                res[i] = (digits[i]+1)%10;
    //            } else {
    //                res[i] = digits[i]+1;
    //            }
    //        } else {
    //            if ((digits[i]+carry[i+1]) >= 10) {
    //                carry[i] = (digits[i]+1+carry[i+1])/10;
    //                res[i] = (digits[i]+carry[i])%10;
    //            } else {
    //                res[i] = digits[i]+carry[i+1];
    //                carry[i] = 0;
    //            }
    //        }
    //    }
    //    if (carry[0] > 0) {
    //        res = Arrays.copyOf(res, n+1);
    //        for (int i = n; i > 0; i++) {
    //            res[n] = res[n-1];
    //        }
    //        res[0] = carry[0];
    //    }
    //   return res;
    //}

    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        boolean flag = true;
        for (int i = n-1; i >= 0; i--) {
            if(flag) {
                if (digits[i] == 9) {
                    digits[i] = 0;
                } else {
                    digits[i] += 1;
                    flag = false;
                }
                if (i == 0 && digits[i] == 0) {
                    int[] res = new int[n+1];
                    res[0] = 1;
                    for (int j = 0; j < n; j++) {
                        res[j+1] = digits[j];
                    }
                    digits = res;
                }
            }
        }
        return digits;
    }

    public static int[] plusOne1(int[] digits) {
        int n = digits.length;
        int carry = 1;
        for (int i = n - 1; i >= 0; i--) {
            int val = digits[i] + carry;
            carry = val/10;
            digits[i] = val%10;

            if (carry == 0) {
                return digits;
            }
        }
        if (carry > 0) {
            int[] res = new int[n + 1];
            res[0] = carry;
            return res;
        } else {
            return digits;
        }
    }

    // WRONG ANSWER 哭
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int temp = 0;
        int costTemp = 0;
        int count = 0;
        int result = -1;
        for (int i = 0; i < len; i++) {
            temp = 0;
            costTemp = 0;
            int j = i;
            temp += gas[j];
            costTemp += cost[j];
            if (gas[j] >= cost[j] || temp >= costTemp) {
                count++;
                if (count == len) result = i;
            } else {
                continue;
            }
            j = (j+1)%len;
            while (j != i) {
                temp += gas[j];
                costTemp += cost[j];
                if (gas[j] >= cost[j] || temp >= costTemp) {
                    count++;
                    j = (j+1)%len;
                    if (count == len) result = i;
                    continue;
                } else {
                    break;
                }
            }
        }
        return result;
    }












}
