/**
 * Created by sunhongbo on 16/4/7.
 */
public class runnableWorkMain {
    public static void main(String[] args) {

        RunnableDemo demo = new RunnableDemo("a", "b");

        Thread thread1 = new Thread(demo);

        thread1.start();

        Thread thread2 = new Thread(demo);

        thread2.start();

        Thread thread3 = new Thread(demo);

        thread3.start();
    }
}
