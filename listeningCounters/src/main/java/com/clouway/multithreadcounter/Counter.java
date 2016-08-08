package com.clouway.multithreadcounter;

/**
 * Created by zumba on 04.08.16.
 *
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 */
public class Counter extends Thread {
    private int count;
    private int max;
    private final Thread listener;

    public Counter(int max, Thread listener) {

        this.max = max;
        this.listener = listener;
    }

    @Override
    public void run() {
        synchronized (listener) {
            count();

            System.out.println("Done! " + this.getName());
            listener.notifyAll();

        }

    }

    private void count() {
        while (count < max) {

            count++;
            System.out.println(getName() + ": " + count);
            listener.notify();

            try {
                sleep(1000);
                listener.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


