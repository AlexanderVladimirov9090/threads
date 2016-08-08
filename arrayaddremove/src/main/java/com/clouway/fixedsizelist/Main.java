package com.clouway.fixedsizelist;

/**
 * Created by zumba on 08.08.16.
 *
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 */
public class Main {
    public static void main(String[] args) {

        FixedList fixedList = new FixedList(10);

        synchronized (Thread.class) {
            Thread addingMangerThread = new Thread(new AddingManager(fixedList));
            Thread removingManagerThread = new Thread(new RemovingManager(fixedList));
            addingMangerThread.start();
            removingManagerThread.start();
        }
    }
}
