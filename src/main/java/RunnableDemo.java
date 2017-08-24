/**
 * Created by sunhongbo on 16/4/7.
 */

public class RunnableDemo implements Runnable {

    private String startMsg;

    private String endMsg;


    public RunnableDemo(String startMsg, String endMsg) {

        super();

        this.startMsg = startMsg;

        this.endMsg = endMsg;

    }


    @Override

    public void run() {

        System.out.println(this + startMsg + " start");

        for (int i = 0; i < 3; i++) {

            System.out.println("run " + i);

            Thread.yield();

        }

        System.out.println(this + endMsg + " end");

    }


}
