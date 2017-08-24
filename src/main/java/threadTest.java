/**
 * Created by sunhongbo on 16/4/7.
 */
public class threadTest {
    public static void main(String[] args) {
        Thread td = new Thread(new listOff());
        td.start();
        System.out.println("thread start!");
    }
}
