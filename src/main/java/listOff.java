/**
 * Created by sunhongbo on 16/4/7.
 */
public class listOff implements Runnable {
    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;
    public listOff() {}
    public listOff(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return ("#" + id + "("+(countDown > 0 ? countDown : "listOff")+")");
    }

    @Override
    public void run() {
        while (countDown-- > 0) {
            System.out.println(status());
            Thread.yield();
        }
    }
}
