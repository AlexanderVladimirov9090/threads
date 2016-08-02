package com.clouway.counter;

import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

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
    public void notInterruptedThread() throws Exception {
        Thread thread = new Thread(new Counter(10));
        ThreadMonitor threadMonitor = new ThreadMonitor();
        ByteArrayOutputStream systemOutString = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(systemOutString);
        PrintStream old = System.out;

        System.setOut(ps);
        long threadStartTime= System.currentTimeMillis();
        thread.start();
        threadMonitor.kill(thread,threadStartTime,11000);
        System.out.flush();

        assertThat(systemOutString.toString(), is(equalTo("Thread-1 10\n")));
        System.setOut(old);
    }

    @Test
    public void interruptedThread(){
        Thread thread = new Thread(new Counter(10));
        ThreadMonitor threadMonitor = new ThreadMonitor();
        ByteArrayOutputStream systemOutString = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(systemOutString);
        PrintStream old = System.out;

        System.setOut(ps);
        long threadStartTime = System.currentTimeMillis();
        thread.start();
        threadMonitor.kill(thread,threadStartTime,1000);
        System.out.flush();

        assertThat(systemOutString.toString(), is(equalTo("Thread-3 interrupted!\nThread-3 0\n")));
        System.setOut(old);
    }
}