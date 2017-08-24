/**
 * Created by sunhongbo on 16/6/24.
 */
public class ceilFunc {
    public static void main(String[] args) {
        System.out.println(com());
    }
    public static double com() {
        int  waitMinutes = 2;
        int  waitStep = 10;
        return (int)Math.ceil((double)waitMinutes / (double)waitStep);
    }
}
