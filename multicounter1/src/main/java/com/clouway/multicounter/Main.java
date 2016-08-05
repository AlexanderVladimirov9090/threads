package com.clouway.multicounter;

/**
 * Created by zumba on 04.08.16.
 *
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 */
public class Main {
    public static void main(String[] args) {

        synchronized (Counter.class) {
            Counter counter = new Counter(15);
            Counter counter2 = new Counter(10);
            ThreadMonitor threadMonitor = new ThreadMonitor();

            counter.start();
            counter2.start();
            threadMonitor.kill(counter);
            threadMonitor.kill(counter2);
        }
    }
}


