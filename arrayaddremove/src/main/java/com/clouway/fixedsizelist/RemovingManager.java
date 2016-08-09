package com.clouway.fixedsizelist;

/**
 * Created by zumba on 08.08.16.
 *
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 */
public class RemovingManager extends Thread{
    private final FixedList fixedList;
    private final AddingManager addingManager;
    public RemovingManager(FixedList fixedList, AddingManager addingManager) {
        this.fixedList = fixedList;
        this.addingManager = addingManager;
    }

    @Override
    public void run() {
        synchronized (addingManager) {

            remove();
        }
    }

    private void remove() {
        while (true) {
            try {

                System.out.println("\nRemoving item." + Thread.currentThread().getName());
                fixedList.remove();
                addingManager.notifyAll();
            } catch (ListEmptyException e) {
             try {
                addingManager.notifyAll();
                    wait();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            } catch (ArrayIndexOutOfBoundsException ignored) {
                try {
                    System.out.println("Waiting for other thread.");
                addingManager.notifyAll();
                addingManager.wait();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }

            System.out.println("Removed item from Array. " + Thread.currentThread().getName());
            fixedList.printAllElements();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
          addingManager.notifyAll();
        }
    }
}
