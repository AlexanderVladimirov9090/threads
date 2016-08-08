package com.clouway.counter;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by zumba on 02.08.16.
 *
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 */
public class CounterTest {

    @Test
    public void interruptedThread(){
        String killSymbol = "kill";
        Thread thread = new Thread(new Counter(10));
        ThreadMonitor threadMonitor = new ThreadMonitor(killSymbol);
        ByteArrayOutputStream systemOutString = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(systemOutString);
        PrintStream old = System.out;

        System.setOut(ps);

        thread.start();
        System.out.println(threadMonitor.kill(thread,killSymbol));
        System.out.flush();

        assertThat(systemOutString.toString(), is(equalTo("Thread-1 0\nThread-1 interrupted!\n")));
        System.setOut(old);
    }
}