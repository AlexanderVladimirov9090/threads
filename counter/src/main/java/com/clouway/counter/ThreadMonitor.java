package com.clouway.counter;

/**
 * Created by zumba on 01.08.16.
 */
public class ThreadMonitor {

    public void kill(Thread thread, long threadStartTime, int delay) {
        while (thread.isAlive()) {
            if (((System.currentTimeMillis() - threadStartTime) > delay) && thread.isAlive()) {
                System.out.format("%s interrupted!\n", thread.getName());
                thread.interrupt();
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
