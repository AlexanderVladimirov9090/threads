package com.clouway.counter;

/**
 * Created by zumba on 01.08.16.
 *
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 *         This class monitors and interrupts Thread when delaying more than given time limit set by user.
 */
class ThreadMonitor {

    /**
     * Kills thread if delays to much.
     *
     * @param thread          monitored thread.
     * @param threadStartTime life cycle of thread.
     * @param delay           time limit set by user.
     */
    String kill(Thread thread, long threadStartTime, int delay) {
        while (thread.isAlive()) {
            if (((System.currentTimeMillis() - threadStartTime) > delay) && thread.isAlive()) {
                thread.interrupt();
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return thread.getName() + " interrupted!";
            }
        }
        return null;
    }
}