import java.util.Random;

/**
 * Created by sunhongbo on 17/9/19.
 */
public class Shuffle {

    public static void main(String[] args) {
        shuffle(4);
    }

    public static void shuffle(int len) {
        int[] num = new int[len];
        int index;
        int tmp;
        Random random = new Random();
        for (int i=0; i < len; i++) {
            num[i] = random.nextInt(100);
        }
        for (int j = 0; j < len; j++) {
            System.out.println(num[j]);
        }
        System.out.println();
        for (int j = 0; j < len; j++) {
            index = random.nextInt(num.length);
            tmp = num[j];
            num[j] = num[index];
            num[index] = tmp;
        }
        for (int j = 0; j < len; j++) {
            System.out.println(num[j]);
        }
    }

}
