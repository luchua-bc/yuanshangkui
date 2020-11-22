package test;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created with IntelliJ IDEA.
 * User: YuanSK
 * Date: 2020/6/11 / 18:13
 * Description:
 */
public class Test {

    public static void main(String[] args) {
//        long timeMillis = System.currentTimeMillis();
//        String regex = "^1[3-9]\\d{9}$";
//        System.out.println("18673233318".matches(regex));
        System.out.println("open");
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("=-=");
            }
        },0,1000);
        System.out.println("end");
    }

}
