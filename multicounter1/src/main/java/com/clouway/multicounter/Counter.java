package com.clouway.multicounter;

/**
 * Created by zumba on 04.08.16.
 *
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 */
public class Counter extends Thread {
    private int count;
    private int max;

    public Counter(int max) {
        this.max = max;

    }

    @Override
    public void run() {

        count();
        this.interrupt();
    }

    /**
     * Counts to given maximum number prints every count and then prints that thread is finished and its name.
     */
    private void count() {
        while (count < max) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
            count++;
            System.out.println(getName() + ": " + count);
        }
        System.out.println("Done! " + this.getName());
    }
}