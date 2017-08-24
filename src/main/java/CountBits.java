/**
 * Created by sunhongbo on 16/3/23.
 */
public class CountBits {


    public static void main(String[] args) {
        int result[] = {0};
        result = countBits(5);
        for (int i = 0; i <= 5; i++) {
            System.out.print(result[i]);
        }

    }

    public static int[] countBits(int num) {
        int ret[] = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            ret[i] = 0;
            int temp = i;
            while (temp/2 != 0 || temp%2 !=0) {
                if (temp%2 != 0) {
                    ret[i]++;
                }
                temp = temp / 2;
            }
        }
        return ret;
    }
}
