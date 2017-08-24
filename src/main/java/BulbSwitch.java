/**
 * Created by sunhongbo on 16/4/6.
 */
public class BulbSwitch {
    public static void main(String[] args) {

    }
    public static int bulbSwitch(int n) {
        //1 1 1 1 1;
        //1 0 1 0 1;
        //1 0 0 0 1;
        //1 0 0 1 1;
        //1 0 0 1 0;
        return (int)Math.sqrt(n);
    }
}
