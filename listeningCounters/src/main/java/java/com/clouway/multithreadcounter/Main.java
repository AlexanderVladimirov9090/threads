package java.com.clouway.multithreadcounter;

/**
 * Created by zumba on 04.08.16.
 *
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 */
public class Main {
    public static void main(String[] args) {
        Thread listener = new Thread();
        Counter counter = new Counter(5, listener);
        Counter counter2 = new Counter(5, listener);

        synchronized (Thread.class) {
            counter.start();
            counter2.start();
        }
    }
}
