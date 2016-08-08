package com.clouway.fixedsizelist;

/**
 * Created by zumba on 08.08.16.
 *
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 */
public class RemovingManager implements Runnable{
    private final FixedList fixedList;

    public RemovingManager(FixedList fixedList) {
        this.fixedList = fixedList;
    }

    public void run() {
        synchronized (this){

            remove();
        }
    }

    private void remove() {
        while (true) {

            try {
                fixedList.remove();
            }catch (ListEmptyException e){

                try {
                    wait();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }catch ( ArrayIndexOutOfBoundsException ignored){}

            System.out.println("Removed item from Array.");
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
