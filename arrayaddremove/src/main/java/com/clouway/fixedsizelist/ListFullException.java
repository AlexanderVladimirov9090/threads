package com.clouway.fixedsizelist;

/**
 * Created by clouway on 10.05.16.
 */
public class ListFullException extends RuntimeException{

    public ListFullException() {
        super("Can not add list is full");
    }
}
