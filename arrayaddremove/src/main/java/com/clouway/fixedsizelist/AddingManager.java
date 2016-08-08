package com.clouway.fixedsizelist;

/**
 * Created by zumba on 08.08.16.
 *
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 */
public class AddingManager implements Runnable {
    private final FixedList fixedList;

    public AddingManager(FixedList fixedList) {
        this.fixedList = fixedList;
    }

    public void run() {
        synchronized (this) {

            add();
        }
    }

    private void add() {
        while (true) {

            try {
                fixedList.add(new Object());
            }catch (ListFullException e){
                try {
                    wait();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
            System.out.println("Added Item From Array.");
            fixedList.printAllElements();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            notifyAll();
        }
    }
}
