package com.clouway.fixedsizelist;

import java.lang.*;

/**
 * Created by clouway on 11.05.16.
 */
public class FixedList{
    private final Object[] items;
    private int index = 0;

    public FixedList(int size) {
        this.items = new Object[size];
    }

    public Object[] getItems(){
        return items;
    }
    /**
     * Adding item in items array.
     *
     *
     * @param item Object that is added
     * @throws ListFullException
     */
    public synchronized void add(Object item) throws ListFullException {

        if (index < items.length) {
            items[index] = item;
            index++;
        } else {
            throw new ListFullException();
        }
    }

    /**
     * Removes object from array.
     *
     * @throws ListEmptyException
     */
    public synchronized void remove() throws ListEmptyException {

        if (items[index - 1]==null) {
            throw new ListEmptyException();
        } else {
            items[index - 1] = null;
            index--;
        }
    }

    /**
     * Prints all array as a string
     */
    public synchronized void printAllElements() {

        for (Object item : items) {
            System.out.println(item);
        }
    }

}