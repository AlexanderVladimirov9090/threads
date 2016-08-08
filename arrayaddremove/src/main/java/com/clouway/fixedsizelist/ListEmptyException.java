package com.clouway.fixedsizelist;

/**
 * Created by clouway on 10.05.16.
 */
public class ListEmptyException extends RuntimeException{

    public ListEmptyException() {
        super("Can not remove list is empty");
    }
}
