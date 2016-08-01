package com.clouway.counter;

/**
 * Created by zumba on 01.08.16.
 */
public class Counter extends Thread {
    private final int max;
    private int count;

    public Counter(int max) {
        this.max = max;
    }

    public void run() {
        System.out.println(increase());
    }

    private String increase() {
        while (count < max) {
            try {
                Thread.sleep(1000);
                count++;
            } catch (InterruptedException e) {
                break;
            }
        }
        return Thread.currentThread().getName() + " " + count;
    }
}
