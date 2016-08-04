package com.clouway.counter;

/**
 * Created by zumba on 01.08.16.
 *
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 *         This class monitors and interrupts Thread when delaying more than given time limit set by user.
 */
class ThreadMonitor {
    private final String killSymbol;

    ThreadMonitor(String killSymbol) {
        this.killSymbol = killSymbol;
    }

    /**
     * Kills thread.
     * @param thread targeted thread.
     * @param kill command to kill thread.
     * @return
     */
    String kill(Thread thread, String kill) {
        while (thread.isAlive()) {
            if (kill.equals(killSymbol) && thread.isAlive()) {
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